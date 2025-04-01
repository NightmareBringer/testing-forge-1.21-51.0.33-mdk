package net.nbc.thetestermod.entity.goals.custom;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.nbc.thetestermod.entity.custom.TesterEntity;

public class ChaseAndPauseGoal extends Goal {
    private final TesterEntity mob;
    private final RetreatGoal retreatGoal;
    private Player target;
    private int moveTicks;  // How long the mob moves
    private final double speed;
    private int cooldown = 0;

    public ChaseAndPauseGoal(TesterEntity mob, double speed, RetreatGoal retreatGoal) {
        this.mob = mob;
        this.speed = speed;
        this.retreatGoal = retreatGoal;
    }

    @Override
    public boolean canUse() {
        if (cooldown > 0) {
            cooldown--;
            return false;
        }
        this.target = this.mob.level().getNearestPlayer(this.mob, 96.0D);

        if (this.target != null) {
            //System.out.println("ChaseAndPauseGoal activated! Target: " + this.target.getName().getString());
        }

        return this.target != null;
    }

    @Override
    public void start() {
        this.moveTicks = 0; // Reset movement timer
    }

    @Override
    public void tick() {
        if (this.target == null) return;

        double distance = this.mob.distanceToSqr(this.target);

        // If player is too close, retreat
        if (mob.swinging) {
            retreatGoal.forceRetreat();
            //System.out.println("Force Retreat!!");
            return;
        }

        // If the mob is moving, decrease moveTicks and move
        if (moveTicks > 0) {
            moveTicks--;
            this.mob.setSprinting(true);
            this.mob.getNavigation().moveTo(this.target, this.speed);
            //System.out.println("Moving for " + moveTicks + " more ticks");

            // When movement finishes, set cooldown
            if (moveTicks == 0) {
                this.mob.getLookControl().setLookAt(this.target, 30.0F, 30.0F);
                this.mob.setSprinting(false);
                cooldown = 120 + this.mob.getRandom().nextInt(120);  // Increased cooldown
                //System.out.println("Cooldown activated: " + cooldown + " ticks");
                this.mob.getNavigation().stop();
            }
        } else {
            // Decrease cooldown, ensuring the mob pauses
            if (cooldown > 0) {
                this.mob.setSprinting(false);
                this.mob.getLookControl().setLookAt(this.target, 30.0F, 30.0F);
                cooldown--;
                //System.out.println("Cooldown ticking down: " + cooldown);
                return;
            }

            // Stare at the player when paused
            this.mob.getLookControl().setLookAt(this.target, 30.0F, 30.0F);

            // 10% chance per second to start moving
            if (this.mob.getRandom().nextFloat() < 0.1F) {
                moveTicks = 8 + this.mob.getRandom().nextInt(8);  // Random movement duration
                //System.out.println("Starting movement for " + moveTicks + " ticks");
            }
        }
    }

    public int getMoveTicks() {
        return this.moveTicks;
    }

    public int getCooldown() {
        return this.cooldown;
    }
}
