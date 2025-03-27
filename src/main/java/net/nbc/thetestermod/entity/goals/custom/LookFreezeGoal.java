package net.nbc.thetestermod.entity.goals.custom;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.nbc.thetestermod.entity.custom.TesterEntity;

import java.util.EnumSet;

public class LookFreezeGoal extends Goal {
    private final TesterEntity mob; // Use TesterEntity instead of Mob
    private Player target;
    private final double maxDistance; // Max distance to detect player's gaze

    public LookFreezeGoal(TesterEntity mob, double maxDistance) {
        this.mob = mob;
        this.maxDistance = maxDistance;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK)); // Affects movement and looking
    }

    @Override
    public boolean canUse() {
        // Find the nearest player
        this.target = this.mob.level().getNearestPlayer(this.mob, maxDistance);
        if (target == null) return false;

        // Check if the player is looking at the mob
        return isPlayerLookingAtMob(target, mob);
    }

    @Override
    public void start() {
        // Stop movement
        this.mob.getNavigation().stop();
        System.out.println("TesterEntity is frozen due to player's stare!");
    }

    @Override
    public boolean canContinueToUse() {
        // Continue freezing if the player is still looking at the mob
        return target != null && isPlayerLookingAtMob(target, mob);
    }

    @Override
    public void stop() {
        System.out.println("TesterEntity resumes movement!");
    }

    // Helper function to check if the player is looking at the mob
    private boolean isPlayerLookingAtMob(Player player, TesterEntity mob) {
        Vec3 playerView = player.getViewVector(1.0F).normalize();
        Vec3 mobDirection = new Vec3(
                mob.getX() - player.getX(),
                mob.getEyeY() - player.getEyeY(),
                mob.getZ() - player.getZ()
        ).normalize();

        // Compare the dot product of the two vectors to check alignment
        double dotProduct = playerView.dot(mobDirection);
        return dotProduct > 0.95D; // Adjust this value to tweak sensitivity
    }
}
