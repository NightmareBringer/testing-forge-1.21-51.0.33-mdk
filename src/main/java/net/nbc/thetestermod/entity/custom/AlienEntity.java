package net.nbc.thetestermod.entity.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.warden.SonicBoom;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.nbc.thetestermod.effect.ModEffects;
import net.nbc.thetestermod.entity.ModEntities;
import net.nbc.thetestermod.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

public class AlienEntity extends Animal {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;


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
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Zombie.class, true));
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
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.5D);
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

    /*
    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        // The mob is only vulnerable to specific damage types
        return !source.is(DamageTypes.GENERIC_KILL)
                && !source.is(DamageTypes.IN_WALL)
                && !source.is(DamageTypes.OUTSIDE_BORDER)
                && !source.is(DamageTypes.WITHER_SKULL)
                && !source.is(DamageTypes.WITHER)
                && !source.is(DamageTypes.SONIC_BOOM)
                && !source.is(DamageTypes.FELL_OUT_OF_WORLD);
    } */

    public boolean doHurtTarget(Entity entity) {
        //this.level().broadcastEntityEvent(this, (byte)4);
        this.playSound(SoundEvents.WARDEN_ATTACK_IMPACT, 10.0F, this.getVoicePitch());
        return super.doHurtTarget(entity);
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
