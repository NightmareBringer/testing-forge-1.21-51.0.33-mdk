package net.nbc.thetestermod.entity.custom;

import net.minecraft.Util;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.nbc.thetestermod.entity.MobManager;
import net.nbc.thetestermod.entity.ModEntities;
import net.nbc.thetestermod.entity.TesterVariant;
import net.nbc.thetestermod.entity.goals.custom.ChaseAndPauseGoal;
import net.nbc.thetestermod.entity.goals.custom.RetreatGoal;
import net.nbc.thetestermod.item.ModItems;
import net.nbc.thetestermod.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TesterEntity extends Animal {

    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(TesterEntity.class, EntityDataSerializers.INT);

    private boolean isReinforcement = false;

    private int lookTimer = 0; // Tracks continuous player gaze
    private boolean hasAttacked = false; // Ensures rush attack happens only once

    private int retreatTicks = 0;
    private Vec3 retreatTarget = null;

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public TesterEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        //this.setPersistenceRequired();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 120.0F));

        // Attack when close
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false) {
            @Override
            public boolean canUse() {
                return TesterEntity.this.getTarget() != null && !hasAttacked &&
                        TesterEntity.this.distanceTo(TesterEntity.this.getTarget()) < 4.0F;
            }
        });

        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, AlienEntity.class, true, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, false, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D)
                .add(Attributes.FOLLOW_RANGE, 128D)
                .add(Attributes.ATTACK_DAMAGE, 8.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 2.5D)
                //.add(Attributes.BURNING_TIME, 0.0D)
                //.add(Attributes.ATTACK_SPEED, 4D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.5D);
    }

    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 160;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.swinging && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 7;
            this.attackAnimationState.start(this.tickCount);
        } else {
            --this.attackAnimationTimeout;
        }

        if(attackAnimationTimeout == 0) {
            this.swinging = false;
            attackAnimationState.stop();
        }
    }

    @Override
    public void tick() {
        super.tick();
        setupAnimationStates();

        if(this.level().isClientSide()) {
            this.setupAnimationStates();
        }

        if (this.level().isClientSide()) return; // Server-only logic

        if (!this.level().isClientSide) {
            Player nearest = this.level().getNearestPlayer(this, 128.0D);
            if (nearest != null) {
                this.getLookControl().setLookAt(nearest, 30.0F, 30.0F);
            }
        }

        Player nearest = this.level().getNearestPlayer(this, 128.0D);
        if (nearest == null) return;

        // Check if player is staring
        if (playerIsLooking(nearest)) {
            lookTimer++;
            if (lookTimer >= 100) { // ~5 seconds
                applyBlindness(nearest);
                runAwayAndVanish();
            }
        } else {
            lookTimer = 0;
        }

        // Rush attack if close and hasn't attacked yet
        if (!hasAttacked && this.swinging) {
            rushAttack(nearest);
        }

        // Handle retreat movement
        if (retreatTicks > 0 && retreatTarget != null) {
            retreatTicks--;
            this.getNavigation().moveTo(retreatTarget.x, retreatTarget.y, retreatTarget.z, 1.5D);

            // When retreat finished
            if (retreatTicks == 0) {
                this.level().playSound(
                        null,
                        this.getX(), this.getY(), this.getZ(),
                        SoundEvents.FIRE_EXTINGUISH,
                        SoundSource.HOSTILE,
                        1.0F,
                        0.9F
                );
                spawnVanishParticles();
                this.discard();
            }
        }
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        // Always allow environmental or special damage types
        if (!source.is(DamageTypes.GENERIC_KILL)
                && !source.is(DamageTypes.IN_WALL)
                && !source.is(DamageTypes.OUTSIDE_BORDER)
                && !source.is(DamageTypes.WITHER_SKULL)
                && !source.is(DamageTypes.WITHER)
                && !source.is(DamageTypes.SONIC_BOOM)
                && !(source.getEntity() instanceof AlienEntity)
                && !source.is(DamageTypes.FELL_OUT_OF_WORLD)) {
            return true;
        }

        // If a player is the attacker, make it invulnerable
        return source.getEntity() instanceof Player;
    }

    private void startRetreat(Player player) {
        // Vector pointing away from player
        Vec3 away = this.position().subtract(player.position()).normalize();

        // Scale it so mob runs 15–20 blocks away
        double distance = 15 + this.getRandom().nextInt(6); // 15–20 blocks
        retreatTarget = this.position().add(away.scale(distance));

        retreatTicks = 20;
    }

    private Vec3 getRetreatDestination(Player player) {
        // Vector from player to mob
        Vec3 away = this.position().subtract(player.position()).normalize();

        // Scale it so the mob runs 16 blocks away
        Vec3 retreatPos = this.position().add(away.scale(16.0));

        return retreatPos;
    }

    private void spawnVanishParticles() {
        // Placeholder for particles
        this.level().broadcastEntityEvent(this, (byte) 60);
    }

    private boolean playerHasLineOfSight(Player player) {
        Vec3 eyePos = player.getEyePosition(1.0F);
        Vec3 mobPos = this.position().add(0, this.getBbHeight() * 0.5, 0); // center of mob

        ClipContext context = new ClipContext(
                eyePos,
                mobPos,
                ClipContext.Block.COLLIDER, // consider solid blocks
                ClipContext.Fluid.NONE,
                player
        );

        BlockHitResult result = this.level().clip(context);
        return result.getType() == HitResult.Type.MISS; // no block in between
    }

    private boolean playerIsLooking(Player player) {
        // Simplified: checks if player head rotation points roughly at mob
        Vec3 direction = player.getViewVector(1.0F).normalize();
        Vec3 toMob = this.position().subtract(player.position()).normalize();
        double dot = direction.dot(toMob);
        return dot > 0.95 && player.distanceTo(this) > 10 && playerHasLineOfSight(player); // 10+ blocks for look-triggered vanish
    }

    private void rushAttack(Player player) {
        hasAttacked = true;

        // Pathfind toward the player briefly
        this.getNavigation().moveTo(player, 1.5D); // sprint speed
        this.swinging = true;

        // Apply effects on attack
        applyBlindness(player);

        // Trigger retreat/vanish
        startRetreat(player);
    }

    private void applyBlindness(Player player) {
        if (!(getTarget() instanceof AlienEntity)) {
            this.level().playSound(
                    null,
                    player.getX(), player.getY(), player.getZ(),
                    SoundEvents.ZOMBIE_VILLAGER_CURE,
                    SoundSource.HOSTILE,
                    0.5F,
                    0.5F
            );

            player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 1, false, false));
            player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 4, false, false));
        }
    }

    private void runAwayAndVanish() {
        // Optional: play particle effect here
        this.level().broadcastEntityEvent(this, (byte) 60); // custom vanish particle packet

        // Move a few blocks away for visual effect
        Vec3 retreatVec = this.position().add(0, 0, -5); // simple backward motion
        this.getNavigation().moveTo(retreatVec.x, retreatVec.y, retreatVec.z, 1.5D);

        this.level().playSound(
                null,
                this.getX(), this.getY(), this.getZ(),
                SoundEvents.FIRE_EXTINGUISH,
                SoundSource.HOSTILE,
                1.0F,
                0.9F
        );

        // Despawn
        this.discard();
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean hurt = super.hurt(source, amount);
        if (hurt && source.getEntity() instanceof Player player) {
            applyBlindness(player);
            runAwayAndVanish();
        }
        return hurt;
    }

    /*
    public void setAsReinforcement(boolean bool) {
        this.isReinforcement = bool;
    }

    public boolean isReinforcement() {
        return isReinforcement;
    }

    // Method to spawn reinforcements
    private void spawnReinforcements() {
        // Attempt to spawn reinforcements with a delay to avoid immediate appearance
        // Check if the position is clear
        int x = (int) (this.getX());  // Cast to int for BlockPos
        int y = (int) (this.getY());  // Cast to int for BlockPos
        int z = (int) (this.getZ());  // Cast to int for BlockPos

        this.level().scheduleTick(new BlockPos(x, y, z), Blocks.AIR, 60); // 60 ticks delay

        // Try to spawn 1 reinforcement
        for (int i = 0; i < 1; i++) {
            // Try finding a valid position (clear of blocks) for reinforcements
            Vec3 spawnLocation = findValidSpawnLocation();
            if (spawnLocation != null) {
                TesterEntity reinforcement = ModEntities.TESTER_MOB.get().create(this.level());  // Create new reinforcement entity

                if (reinforcement != null) {
                    // Set the reinforcement's position
                    reinforcement.setPos(spawnLocation.x, spawnLocation.y, spawnLocation.z);
                    reinforcement.setAsReinforcement(true); // Mark as reinforcement
                    this.level().addFreshEntity(reinforcement);
                    System.out.println("Reinforcement successfully spawned at: " + spawnLocation);
                } else {
                    System.out.println("Failed to create reinforcement entity.");
                }
            } else {
                System.out.println("Failed to find a valid spawn location.");
            }
        }
    }

    // Find a valid location for spawning (clear of blocks)
    private Vec3 findValidSpawnLocation() {
        // Try a random nearby position, check if the spot is empty
        int maxAttempts = 10;  // Limit the number of attempts to avoid infinite loop
        for (int attempts = 0; attempts < maxAttempts; attempts++) {
            // Generate random offset within a small radius
            double offsetX = (this.getRandom().nextFloat() - 0.5f) * 96.0;
            double offsetZ = (this.getRandom().nextFloat() - 0.5f) * 96.0;
            double offsetY = 1.0D; // We will leave Y position unchanged for simplicity

            // Check if the position is clear
            int x = (int) (this.getX() + offsetX);  // Cast to int for BlockPos
            int y = (int) (this.getY() + offsetY);  // Cast to int for BlockPos
            int z = (int) (this.getZ() + offsetZ);  // Cast to int for BlockPos

            BlockPos targetPos = new BlockPos(x, y, z);

            // Check if the block at the target position is empty or walkable
            if (this.level().isEmptyBlock(targetPos)) {
                return new Vec3(targetPos.getX(), targetPos.getY(), targetPos.getZ());
            }
        }

        return null; // If no valid position is found after maxAttempts
    } */

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(VARIANT, 0);
    }

    private int getTypeVarient() {
        return this.entityData.get(VARIANT);
    }

    public TesterVariant getVariant() {
        return TesterVariant.byId(this.getTypeVarient() & 255);
    }

    private void setVariant(TesterVariant variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("Variant", this.getTypeVarient());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.entityData.set(VARIANT, pCompound.getInt("Variant"));
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
    }

    @Override
    public void checkDespawn() {
        if (!this.level().isClientSide && this.level() instanceof ServerLevel serverLevel) {
            List<TesterEntity> mobs = serverLevel.getEntities(ModEntities.TESTER_MOB.get(), e -> true)
                    .stream()
                    .filter(Objects::nonNull)
                    .map(TesterEntity.class::cast)
                    .toList();

            if (!mobs.isEmpty()) {
                TesterEntity firstSpawned = mobs.get(0); // Get the first mob that spawned
                if (this != firstSpawned) {
                    this.discard(); // Despawn this mob if it's not the first one spawned
                }
            }
        }
    }

    @Override
    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    @Override
    public boolean canSpawnSprintParticle() {
        return super.canSpawnSprintParticle();
    }

    public static boolean canSpawnTesterEntity(ServerLevel level) {
        // Check if there is already a TesterEntity in the world
        long count = level.getEntities(ModEntities.TESTER_MOB.get(), e -> true).size();

        // Return false if there's already an instance of TesterEntity
        return count == 0;
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pSpawnType, @Nullable SpawnGroupData pSpawnGroupData) {

        TesterVariant variant = TesterVariant.WHITE; // Default variant

        if (this.random.nextInt(50) == 1) {
            variant = TesterVariant.RARE; // Rare variant
        }

        this.setVariant(variant);

        // Mark the mob as spawned
        MobManager.setTesterMobSpawned(true);
        System.out.println("Spawned TesterEntity with variant: " + variant);

        return super.finalizeSpawn(pLevel, pDifficulty, pSpawnType, pSpawnGroupData);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        SoundEvent[] sounds = {
                ModSounds.TESTER_AMBIENT_1.get(),
                ModSounds.TESTER_AMBIENT_2.get(),
        };

        return sounds[this.random.nextInt(sounds.length)];
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource pDamageSource) {
        SoundEvent[] sounds = {
                ModSounds.TESTER_HURT_1.get(),
                ModSounds.TESTER_HURT_2.get(),
        };

        return sounds[this.random.nextInt(sounds.length)];
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return ModSounds.TESTER_DEATH_1.get();
    }

}
