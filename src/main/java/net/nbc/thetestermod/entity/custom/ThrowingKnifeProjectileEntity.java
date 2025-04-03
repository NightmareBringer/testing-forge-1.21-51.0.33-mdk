package net.nbc.thetestermod.entity.custom;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.nbc.thetestermod.entity.ModEntities;
import net.nbc.thetestermod.item.ModItems;

public class ThrowingKnifeProjectileEntity extends AbstractArrow {
    private float rotation;
    public Vec2 groundedOffset;
    private float initialPitch;

    public ThrowingKnifeProjectileEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ThrowingKnifeProjectileEntity(LivingEntity shooter, Level level) {
        super(ModEntities.THROWING_KNIFE.get(), shooter, level, new ItemStack(ModItems.THROWING_KNIFE.get()), null);
        this.initialPitch = shooter.getXRot(); // Capture the throw angle
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.THROWING_KNIFE.get());
    }

    public float getRenderingRotation() {
        Vec3 velocity = this.getDeltaMovement();
        return (float) Math.toDegrees(Math.atan2(velocity.y, velocity.horizontalDistance()));
    }

    public boolean isGrounded() {
        return inGround;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), 5);

        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);

        Direction hitDirection = result.getDirection();

        // Corrected offsets for realistic sticking angles
        switch (hitDirection) {
            case SOUTH -> groundedOffset = new Vec2(90f, 0f);  // Blade sticks into SOUTH wall
            case NORTH -> groundedOffset = new Vec2(90f, 180f);    // Blade sticks into NORTH wall
            case EAST -> groundedOffset = new Vec2(90f, 90f);    // Blade sticks into EAST wall
            case WEST -> groundedOffset = new Vec2(90f, -90f);   // Blade sticks into WEST wall
            case DOWN -> groundedOffset = new Vec2(180f, 0f);    // Blade sticks into the ground
            case UP -> groundedOffset = new Vec2(0f, 0f);        // Blade sticks into ceiling
        }
    }
}
