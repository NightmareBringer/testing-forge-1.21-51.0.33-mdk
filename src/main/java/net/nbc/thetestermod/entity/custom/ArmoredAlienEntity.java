package net.nbc.thetestermod.entity.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
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
import net.minecraft.world.level.ServerLevelAccessor;
import net.nbc.thetestermod.entity.ArmoredAlienVariant;
import net.nbc.thetestermod.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

public class ArmoredAlienEntity extends Animal {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(ArmoredAlienEntity.class, EntityDataSerializers.INT);

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

    public ArmoredAlienEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 150D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.FOLLOW_RANGE, 64D)
                .add(Attributes.ATTACK_DAMAGE, 18.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 1.3D)
                .add(Attributes.ARMOR, 10.0D)
                .add(Attributes.BURNING_TIME, 0.0D)
                .add(Attributes.WATER_MOVEMENT_EFFICIENCY, 20.0D)
                //.add(Attributes.ATTACK_SPEED, 4D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.75D);
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
        //setupAnimationStates();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id == 111) {
            for (int i = 0; i < 10; i++) {
                this.level().addParticle(
                        ParticleTypes.GUST,
                        this.getRandomX(1.0D),
                        this.getRandomY(),
                        this.getRandomZ(1.0D),
                        0.0D, 0.0D, 0.0D
                );
            }
        } else {
            super.handleEntityEvent(id);
        }
    }

    public boolean hurt(DamageSource source, float amount) {
        Crackiness.Level crackiness$level = this.getCrackiness();
        boolean flag = super.hurt(source, amount);
        if (flag && this.getCrackiness() != crackiness$level) {
            this.level().broadcastEntityEvent(this, (byte) 111);
            this.playSound(SoundEvents.IRON_GOLEM_DAMAGE, 1.0F, 0.8F);
        }

        return flag;
    }

    public boolean doHurtTarget(Entity entity) {
        this.playSound(SoundEvents.WARDEN_ATTACK_IMPACT, 2.0F, this.getVoicePitch());
        return super.doHurtTarget(entity);
    }

    @Override
    public boolean isAffectedByPotions() {
        return false;
    }

    public Crackiness.Level getCrackiness() {
        return Crackiness.GOLEM.byFraction(this.getHealth() / this.getMaxHealth());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(VARIANT, 0);
    }

    private int getTypeVarient() {
        return this.entityData.get(VARIANT);
    }

    public ArmoredAlienVariant getVariant() {
        return ArmoredAlienVariant.byId(this.getTypeVarient() & 255);
    }

    private void setVariant(ArmoredAlienVariant variant) {
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
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pSpawnType, @Nullable SpawnGroupData pSpawnGroupData) {

        ArmoredAlienVariant variant = ArmoredAlienVariant.BLUE; // Default variant

        if (this.random.nextInt(2) == 1) {
            variant = ArmoredAlienVariant.GREEN; // Other variant
        }

        this.setVariant(variant);

        return super.finalizeSpawn(pLevel, pDifficulty, pSpawnType, pSpawnGroupData);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    @Override
    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return ModSounds.ALIEN_AMBIENT.get();
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.ARMOR_ALIEN_HURT.get();
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return ModSounds.ARMOR_ALIEN_DEATH.get();
    }
}
