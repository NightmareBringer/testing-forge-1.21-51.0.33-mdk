package net.nbc.thetestermod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.nbc.thetestermod.item.ModItems;
import net.neoforged.neoforge.common.CommonHooks;

public class CrimsonBlueBerryBushBlock extends SweetBerryBushBlock {
    public CrimsonBlueBerryBushBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader pLevel, BlockPos pPos, BlockState pState) {
        return new ItemStack(ModItems.CRIMSON_BLUE_BERRIES.get());
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState belowBlock = level.getBlockState(pos.below());

        // Allow placement on Grass, Dirt, Netherrack, or Crimson Nylium
        return belowBlock.is(Blocks.GRASS_BLOCK) ||
                belowBlock.is(Blocks.DIRT) ||
                belowBlock.is(Blocks.NETHERRACK) ||
                belowBlock.is(Blocks.CRIMSON_NYLIUM);
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(Blocks.GRASS_BLOCK) ||
                pState.is(Blocks.DIRT) ||
                pState.is(Blocks.NETHERRACK) ||
                pState.is(Blocks.CRIMSON_NYLIUM);    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int age = (Integer)state.getValue(AGE);
        if (age < 3 && level.getRawBrightness(pos.above(), 0) >= 9) {

            // Get block beneath the bush and determine growth chance
            Block blockBelow = level.getBlockState(pos.below()).getBlock();
            int growthChance = 6;

            if (blockBelow == Blocks.DIRT) {
                growthChance = 200;
            } else if (blockBelow == Blocks.GRASS_BLOCK) {
                growthChance = 100;
            } else if (blockBelow == Blocks.NETHERRACK) {
                growthChance = 10;
            }

            if (level.dimensionType().ultraWarm()) growthChance /= 2;

            // Prevent invalid range
            growthChance = Math.max(growthChance, 1);

            // Apply growth chance
            if (CommonHooks.canCropGrow(level, pos, state, random.nextInt(growthChance) == 0)) {
                BlockState newState = (BlockState)state.setValue(AGE, age + 1);
                level.setBlock(pos, newState, 2);
                CommonHooks.fireCropGrowPost(level, pos, state);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(newState));
            }
        }
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        int i = (Integer)pState.getValue(AGE);
        boolean flag = i == 3;
        if (i > 1) {
            int j = 1 + pLevel.random.nextInt(2);
            popResource(pLevel, pPos, new ItemStack(ModItems.CRIMSON_BLUE_BERRIES.get(), j + (flag ? 1 : 0)));
            pLevel.playSound((Player)null, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + pLevel.random.nextFloat() * 0.4F);
            BlockState blockstate = (BlockState)pState.setValue(AGE, 1);
            pLevel.setBlock(pPos, blockstate, 2);
            pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pPlayer, blockstate));
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        } else {
            return super.useWithoutItem(pState, pLevel, pPos, pPlayer, pHitResult);
        }
    }

}
