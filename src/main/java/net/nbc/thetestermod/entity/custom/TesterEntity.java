package net.nbc.thetestermod.entity.custom;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
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
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TesterEntity extends Monster {

    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(TesterEntity.class, EntityDataSerializers.INT);

    private boolean isReinforcement = false;

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public TesterEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setPersistenceRequired();
    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(0, new FloatGoal(this));

        // Panic when attacked
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.5));

        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 96.0F));

        // Create RetreatGoal first so we can pass it to ChaseAndPauseGoal
        RetreatGoal retreatGoal = new RetreatGoal(this, 48.0, 2.5);
        ChaseAndPauseGoal chaseGoal = new ChaseAndPauseGoal(this, 1.0, retreatGoal);

        // Add goals
        this.goalSelector.addGoal(3, chaseGoal);
        this.goalSelector.addGoal(4, retreatGoal);

        // Attack when close
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true) {
            @Override
            public boolean canUse() {
                // Only allow the melee attack goal if the mob is not in pause state (moveTicks > 0)
                return chaseGoal.getMoveTicks() <= 0 && super.canUse();  // Only use if moveTicks is 0
            }

            @Override
            public boolean canContinueToUse() {
                // Similar logic, only continue melee attack if the mob is actively moving
                return chaseGoal.getMoveTicks() > 0 && super.canContinueToUse();  // Only continue when moveTicks > 0
            }

            @Override
            public void tick() {
                super.tick();

                if (this.mob.swinging) {
                    retreatGoal.forceRetreat();
                }
            }
        });

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true, false));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D)
                .add(Attributes.FOLLOW_RANGE, 96D)
                .add(Attributes.ARMOR, 20D)
                .add(Attributes.ARMOR_TOUGHNESS, 20D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.5D)
                .add(Attributes.BURNING_TIME, 0.0D)
                .add(Attributes.FALL_DAMAGE_MULTIPLIER, 0.01D)
                .add(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, 20D)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, 0.01D)
                .add(Attributes.ATTACK_DAMAGE, 7.5D)
                .add(Attributes.ATTACK_KNOCKBACK, 2.5D)
                .add(Attributes.ATTACK_SPEED, 4D);
    }

    public void setAsReinforcement(boolean bool) {
        this.isReinforcement = bool;
    }

    public boolean isReinforcement() {
        return isReinforcement;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        // Call the super method to ensure the entity takes damage as usual
        boolean hurt = super.hurt(source, amount);

        // Check if the mob is hurt and if the spawn reinforcement chance is triggered
        if (hurt && source.getEntity() instanceof Player) {
            double baseSpawnChance = this.getAttributeValue(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
            double adjustedSpawnChance = Math.min(1.0, baseSpawnChance + (amount * 0.01255075)); // Increase chance based on damage taken

            System.out.println("Base spawn chance: " + baseSpawnChance + ", Adjusted spawn chance: " + adjustedSpawnChance);

            if (this.getRandom().nextDouble() < adjustedSpawnChance) {
                // Schedule reinforcement spawning with a delay
                System.out.println("Reinforcement spawn chance triggered! Attempting to spawn...");
                spawnReinforcements();
            } else {
                System.out.println("Reinforcement spawn chance failed.");
            }
        }
        return hurt;
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

        if (!this.level().isClientSide) {
            Player nearestPlayer = this.level().getNearestPlayer(this, 256);

            // Enable AI when player gets close
            this.setNoAi(nearestPlayer == null || this.distanceTo(nearestPlayer) > 128);  // Disable AI when far away
        }

        if(this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

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
    public void checkDespawn() {
        if (!this.level().isClientSide && this.level() instanceof ServerLevel serverLevel) {
            List<TesterEntity> mobs = serverLevel.getEntities(ModEntities.TESTER_MOB.get(), e -> !e.isReinforcement())
                    .stream()
                    .filter(Objects::nonNull)
                    .map(TesterEntity.class::cast)
                    .toList();

            if (!mobs.isEmpty()) {
                TesterEntity firstSpawned = mobs.get(0); // Get the first mob that spawned
                if (this != firstSpawned && !isReinforcement()) {
                    this.discard(); // Despawn this mob if it's not the first one spawned
                }
            }
        }
    }

    @Override
    public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
        return false;
    }

    @Override
    public boolean isPersistenceRequired() {
        return true;
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



        // If the mob hasn't spawned yet, proceed with the spawn logic
        TesterVariant variant = TesterVariant.WHITE; // Default variant

        if (this.random.nextInt(2048) == 1) {
            variant = TesterVariant.RARE; // Rare chance
        }

        this.setVariant(variant);

        // Mark the mob as spawned
        MobManager.setTesterMobSpawned(true);
        System.out.println("Spawned TesterEntity with variant: " + variant);

        // Example: 50% chance to cancel the spawn
        if (random.nextBoolean()) {
            return super.finalizeSpawn(pLevel, pDifficulty, pSpawnType, null);
        } else {
            return super.finalizeSpawn(pLevel, pDifficulty, pSpawnType, pSpawnGroupData);
        }
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
