package net.nbc.thetestermod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.util.valueproviders.UniformInt;
import com.mojang.serialization.MapCodec;
import net.nbc.thetestermod.item.ModItems;

public class MysteriousDustBlock extends FallingBlock {
    public static final MapCodec<MysteriousDustBlock> CODEC = simpleCodec(MysteriousDustBlock::new);

    public MysteriousDustBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends FallingBlock> codec() {
        return CODEC;
    }

    @Override
    public void onLand(Level world, BlockPos pos, BlockState state, BlockState landedState, FallingBlockEntity entity) {
        // Custom behavior when the block lands
        // Debugging to confirm landing behavior
        //System.out.println("Falling Slab landed at " + pos);

        // Play block break effect (ID 2001)
        world.levelEvent(2001, pos, Block.getId(state));

        // Drop the MYSTERIOUS_DUST item at the position where the block landed
        dropMysteriousDust(world, pos);

        // Destroy the block at the landed position (remove the block)
        world.setBlockAndUpdate(pos, landedState);

        super.onLand(world, pos, state, landedState, entity);
    }

    // Custom method to drop MYSTERIOUS_DUST item when the block lands
    private void dropMysteriousDust(Level world, BlockPos pos) {
        if (!world.isClientSide) {
            // Create an ItemStack of MYSTERIOUS_DUST
            ItemStack dustItem = new ItemStack(ModItems.MYSTERIOUS_DUST.get());

            // Spawn the item at the landing position
            net.minecraft.world.entity.item.ItemEntity itemEntity = new net.minecraft.world.entity.item.ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), dustItem);
            world.addFreshEntity(itemEntity);
        }
    }
}