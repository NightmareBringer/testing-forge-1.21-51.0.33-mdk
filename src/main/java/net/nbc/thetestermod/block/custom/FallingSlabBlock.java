package net.nbc.thetestermod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.nbc.thetestermod.item.ModItems;

public class FallingSlabBlock extends SlabBlock {

    // A half-block VoxelShape (slab shape)
    private static final net.minecraft.world.phys.shapes.VoxelShape SLAB_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);

    public FallingSlabBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    // Override onPlace to trigger the falling behavior when placed in mid-air
    @Override
    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, world, pos, oldState, isMoving);

        if (state.getValue(TYPE) == SlabType.TOP) {
            world.setBlockAndUpdate(pos, state.setValue(TYPE, SlabType.BOTTOM));
        }

        // Schedule the tick to check if it needs to land
        world.scheduleTick(pos, this, 2);
    }

    // Custom method to trigger falling behavior
    public void tickFalling(BlockState state, Level world, BlockPos pos) {
        // Check if the block below is either a full block or an air block
        if (world.isEmptyBlock(pos.below()) || isHalfBlock(world, pos.below())) {
            FallingBlockEntity.fall(world, pos, state); // Trigger the falling block behavior
        }
    }

    // Helper method to check if the block below is a slab (half block)
    private boolean isHalfBlock(Level world, BlockPos pos) {
        BlockState blockBelow = world.getBlockState(pos);
        return blockBelow.getBlock() instanceof SlabBlock;
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        checkFall(state, world, pos);
    }

    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (!world.isClientSide) {
            checkFall(state, world, pos);
        }
    }

    // Checks if the slab should fall
    private void checkFall(BlockState state, Level world, BlockPos pos) {
        if (world.isEmptyBlock(pos.below())) {
            FallingBlockEntity.fall(world, pos, state);
        }
    }


}