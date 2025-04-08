package net.nbc.thetestermod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.nbc.thetestermod.block.ModBlocks;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {
    public ModFlammableRotatedPillarBlock(Properties p_55926_) {
        super(p_55926_);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return super.isFlammable(state, level, pos, direction);
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context,
                                                     ItemAbility itemAbility, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            Level level = context.getLevel();
            BlockPos pos = context.getClickedPos();
            Player player = context.getPlayer();

            if(state.is(ModBlocks.CORRUPTED_OAK_LOG.get())) {
                playStrippingSound(level, pos, player);
                return ModBlocks.STRIPPED_CORRUPTED_OAK_LOG.get().defaultBlockState().trySetValue(AXIS, state.getValue(AXIS));
            }

            if(state.is(ModBlocks.CORRUPTED_OAK_WOOD.get())) {
                playStrippingSound(level, pos, player);
                return ModBlocks.STRIPPED_CORRUPTED_OAK_WOOD.get().defaultBlockState().trySetValue(AXIS, state.getValue(AXIS));
            }
        }


        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }

    private void playStrippingSound(Level level, BlockPos pos, @Nullable Player player) {
        if (!level.isClientSide) {
            level.playSound(null, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0f, 1.0f);
        }
    }
}
