package net.nbc.thetestermod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.nbc.thetestermod.item.ModItems;
import org.jetbrains.annotations.Nullable;

public class SpecialTrapdoorBlock extends TrapDoorBlock {
    public SpecialTrapdoorBlock(BlockSetType type, Properties properties) {
        super(type, properties);
    }

    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, @Nullable Direction direction) {
        return false;
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {

    }

    @Override
    protected int getSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 0;
    }

    @Override
    protected int getDirectSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 0;
    }

    @Override
    protected boolean hasAnalogOutputSignal(BlockState state) {
        return false;
    }

    @Override
    protected int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return 0;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        boolean hasOrb = player.getMainHandItem().is(ModItems.ENERGY_ORB.get());

        if (hasOrb) {
            level.playSound(
                    //breeze land, breeze deflect, breeze slide
                    player,
                    pos,
                    SoundEvents.BREEZE_DEFLECT,
                    SoundSource.BLOCKS,
                    0.5f,
                    0.9f
            );
            if (!level.isClientSide()) {
                if (!player.isCreative()) {
                    player.getMainHandItem().shrink(1);
                }

                boolean open = state.getValue(TrapDoorBlock.OPEN);
                BlockState newState = state.setValue(TrapDoorBlock.OPEN, !open);

                // 3 = update clients + neighbors (standard vanilla flag)
                level.setBlock(pos, newState, 3);

                // Play vanilla trapdoor open/close sound on server so it gets sent to clients
                SoundEvent sound = open ? SoundEvents.IRON_TRAPDOOR_CLOSE : SoundEvents.IRON_TRAPDOOR_OPEN;
                level.playSound(null, pos, sound, SoundSource.BLOCKS, 1.0f, 1.0f);

                // Emit game event for sculk sensors, etc.
                level.gameEvent(player, open ? GameEvent.BLOCK_CLOSE : GameEvent.BLOCK_OPEN, pos);
            }
        }

        return ItemInteractionResult.sidedSuccess(hasOrb);
    }
}
