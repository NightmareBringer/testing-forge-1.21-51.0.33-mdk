package net.nbc.thetestermod.entity.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.nbc.thetestermod.entity.ModEntities;
import net.nbc.thetestermod.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

public class AlienEntity extends Animal {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    private boolean hasSpawnedBaby = false;
    private boolean isCooldownPaused = false;
    private int babiesSpawned = 0;
    private int maxBabiesToSpawn = this.getRandom().nextInt(2, 4);
    private int maxBirthCooldown = 720;
    private int birthCooldown = maxBirthCooldown;

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.55D, false));

        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0F));

        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 32.0F));

        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, TesterEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, (p_28879_) -> {
            return p_28879_ instanceof Enemy;
        }));
    }

    public AlienEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 120D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.FOLLOW_RANGE, 64D)
                .add(Attributes.ATTACK_DAMAGE, 12.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 1.2D)
                .add(Attributes.ARMOR, 5.0D)
                //.add(Attributes.BURNING_TIME, 0.0D)
                //.add(Attributes.ATTACK_SPEED, 4D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.35D);
    }

    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 390;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.swinging && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 10;
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

        if (this.level().isClientSide) return;

        LivingEntity target = this.getTarget();

        // --- Handle cooldown tick ---
        if (birthCooldown > 0) {
            if (target instanceof Player player && this.hasLineOfSight(player)) {
                if (isCooldownPaused) {
                    //System.out.println("[AlienDebug] Player visible again — resuming cooldown.");
                    isCooldownPaused = false;
                }

                birthCooldown--;
                if (birthCooldown % 200 == 0) {
                    //System.out.println("[AlienDebug] Cooldown ticking down: " + birthCooldown);
                }

            } else {
                if (!isCooldownPaused) {
                    //System.out.println("[AlienDebug] Lost sight of player. Cooldown paused at: " + birthCooldown);
                    isCooldownPaused = true;
                }
            }
        }

        // --- Handle baby spawning ---
        if (birthCooldown == 0 && !this.isBaby() && babiesSpawned < maxBabiesToSpawn) {
            //System.out.println("[AlienDebug] Cooldown reached zero. Spawning baby...");
            spawnBabyAlien();
            babiesSpawned++;
           //System.out.println("[AlienDebug] Baby spawned! Total: " + babiesSpawned + "/" + maxBabiesToSpawn);

            birthCooldown = maxBirthCooldown; // Reset after spawn
            hasSpawnedBaby = true;
        }

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    public boolean doHurtTarget(Entity entity) {
        this.playSound(SoundEvents.WARDEN_ATTACK_IMPACT, 2.0F, this.getVoicePitch());
        return super.doHurtTarget(entity);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean flag = super.hurt(source, amount);

        if (flag && source.getEntity() instanceof Player player) {

            if (!hasSpawnedBaby && birthCooldown == 0) {
                hasSpawnedBaby = true;
                birthCooldown = maxBirthCooldown / 2;
                //System.out.println("[AlienDebug] First player hit detected. Starting cooldown at half: " + birthCooldown);
            }

            // --- Reduce cooldown based on damage ---
            if (birthCooldown > 0) {
                int reduction = (int) (amount * 10);
                int prevCooldown = birthCooldown;
                birthCooldown = Math.max(0, birthCooldown - reduction);

                //System.out.println("[AlienDebug] Alien hit by player. Cooldown reduced from "
                //        + prevCooldown + " to " + birthCooldown + " (" + reduction + " ticks removed)");
            }
        }

        return flag;
    }

    //Spawns a baby alien near this alien.
    private void spawnBabyAlien() {
        AlienEntity babyAlien = ModEntities.ALIEN_MOB.get().create(this.level());
        if (babyAlien != null) {
            double spawnX = this.getX() + (this.getRandom().nextDouble() - 0.5D) * 2.0D;
            double spawnY = this.getY();
            double spawnZ = this.getZ() + (this.getRandom().nextDouble() - 0.5D) * 2.0D;

            babyAlien.setBaby(true);
            babyAlien.moveTo(spawnX, spawnY, spawnZ, this.getYRot(), this.getXRot());

            this.level().addFreshEntity(babyAlien);

            this.level().levelEvent(2001, babyAlien.blockPosition(), 0); // small particle effect
            this.playSound(SoundEvents.TURTLE_EGG_HATCH, 1.0F, 1.2F);

            System.out.println("[AlienDebug] Baby alien successfully spawned at: " +
                    String.format("(%.2f, %.2f, %.2f)", spawnX, spawnY, spawnZ));
        } else {
            System.out.println("[AlienDebug] ERROR: Failed to create baby alien entity!");
        }
    }

    @Override
    public boolean isBaby() {
        return super.isBaby();
    }

    @Override
    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return ModSounds.ALIEN_AMBIENT.get();
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.ALIEN_HURT.get();
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return ModSounds.ALIEN_DEATH.get();
    }
}
