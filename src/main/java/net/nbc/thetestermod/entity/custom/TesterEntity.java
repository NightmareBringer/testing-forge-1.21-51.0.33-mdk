package net.nbc.thetestermod.entity.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.nbc.thetestermod.entity.ModEntities;
import net.nbc.thetestermod.entity.goals.custom.ChaseAndPauseGoal;
import net.nbc.thetestermod.entity.goals.custom.RetreatGoal;
import net.nbc.thetestermod.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class TesterEntity extends Animal {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public TesterEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(0, new FloatGoal(this));

        // Panic when attacked
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.5));

        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 128.0F));

        // Create RetreatGoal first so we can pass it to ChaseAndPauseGoal
        RetreatGoal retreatGoal = new RetreatGoal(this, 24.0, 2.5);
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
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D)
                .add(Attributes.FOLLOW_RANGE, 128D)
                .add(Attributes.ARMOR, 20D)
                .add(Attributes.ARMOR_TOUGHNESS, 20D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.5D)
                .add(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, 20D)
                .add(Attributes.ATTACK_DAMAGE, 2.5D)
                .add(Attributes.ATTACK_KNOCKBACK, 2D)
                .add(Attributes.ATTACK_SPEED, 4D);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(ModItems.WHITE_CARROT.get());
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntities.TESTER_MOB.get().create(pLevel);
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

        if(this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }
}
