package net.nbc.thetestermod.block.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.phys.BlockHitResult;
import net.nbc.thetestermod.item.ModItems;
import net.nbc.thetestermod.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

public class SpecialDoorBlock extends DoorBlock {
    public SpecialDoorBlock(BlockSetType type, Properties properties) {
        super(type, properties);
    }

    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, @Nullable Direction direction) {
        return false;
    }

    @Override
    public boolean isSignalSource(BlockState state) {
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
            if (!level.isClientSide()) {
                if (!player.isCreative()) {
                    player.getMainHandItem().shrink(1);
                }
                this.setOpen(null, level, state, pos, !this.isOpen(state));
            }
            level.playSound(
                    //breeze land, breeze deflect, breeze slide
                    player,
                    pos,
                    SoundEvents.BREEZE_DEFLECT,
                    SoundSource.BLOCKS,
                    0.5f,
                    0.9f
            );
        }

        return ItemInteractionResult.sidedSuccess(hasOrb);
    }
}
