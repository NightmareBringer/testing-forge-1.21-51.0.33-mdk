package net.nbc.thetestermod.entity.goals.custom;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.nbc.thetestermod.entity.custom.TesterEntity;

public class RetreatGoal extends Goal {
    private final TesterEntity mob;
    private Player target;
    private final double retreatDistance;
    private final double speed;
    private boolean shouldRetreat = false; // Controls forced retreat

    public RetreatGoal(TesterEntity mob, double retreatDistance, double speed) {
        this.mob = mob;
        this.retreatDistance = retreatDistance;
        this.speed = speed;
    }

    @Override
    public boolean canUse() {
        this.target = this.mob.level().getNearestPlayer(this.mob, 96.0D);
        return shouldRetreat || (target != null && this.mob.getLastHurtByMob() instanceof Player);
    }

    @Override
    public void start() {
        if (this.target != null) {
            shouldRetreat = false; // Reset forced retreat after it starts
        }
    }

    public void forceRetreat() {
        if (mob.swinging) {
            mob.swinging = false;
        }
        this.mob.setSprinting(true);
        this.shouldRetreat = true;
        this.mob.getNavigation().stop(); // Stop any other movement immediately

        moveAwayFromPlayer();
    }

    private void moveAwayFromPlayer() {
        //Player target = mob.level().getNearestPlayer(mob, 128.0D);
        if (target == null) {
            return;  // No player to retreat from
        }

        Vec3 retreatVec = this.mob.position().subtract(this.target.position()).normalize().scale(20.5f);
        Vec3 moveTo = this.mob.position().add(retreatVec);
        this.mob.getNavigation().moveTo(moveTo.x, moveTo.y, moveTo.z, speed);
    }

    @Override
    public void tick() {
        if (this.target == null) return;

        double distance = this.mob.distanceTo(this.target);

        // Stop retreating when far enough
        if (distance > retreatDistance * 1.5) {
            this.mob.setSprinting(false);
            shouldRetreat = false;
            this.mob.getNavigation().stop();
            return;
        }

        // Move away from the player
        Vec3 retreatVec = this.mob.position().subtract(this.target.position()).normalize().scale(this.retreatDistance);
        Vec3 moveTo = this.mob.position().add(retreatVec);
        this.mob.getNavigation().moveTo(moveTo.x, moveTo.y, moveTo.z, speed);
    }
}
