package net.nbc.thetestermod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.nbc.thetestermod.entity.ModEntities;
import net.nbc.thetestermod.entity.custom.ChairEntity;
import net.nbc.thetestermod.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ConsoleBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<ConsoleBlock> CODEC = simpleCodec(ConsoleBlock::new);

    public static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);

    public ConsoleBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide) {
            player.displayClientMessage(Component.literal("The console seems to be frozen..."), true);
        }
        level.playSound(
                null,
                pos,
                ModSounds.CONSOLE_CLICK.get(),
                SoundSource.BLOCKS,
                1.0f,
                1.0f
        );

        return InteractionResult.SUCCESS;
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    /*
    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("tooltip.testermod.blue_gc1.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.testermod.blue_gc2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.testermod.blue_gc3.tooltip"));
        //for a new line in the tooltip, copy the same line as above and just replace the pKey
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    } */
}
