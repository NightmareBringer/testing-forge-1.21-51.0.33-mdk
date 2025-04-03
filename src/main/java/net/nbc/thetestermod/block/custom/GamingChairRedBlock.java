package net.nbc.thetestermod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.nbc.thetestermod.entity.ModEntities;
import net.nbc.thetestermod.entity.custom.ChairEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GamingChairRedBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<GamingChairRedBlock> CODEC = simpleCodec(GamingChairRedBlock::new);

    public static final VoxelShape SHAPE = Block.box(2.0, 0.0, 0.0, 14.0, 8.0, 16.0);

    public GamingChairRedBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if(!level.isClientSide()) {
            Entity entity = null;
            List<ChairEntity> entities = level.getEntities(ModEntities.CHAIR_ENT.get(), new AABB(pos), chair -> true);
            if(entities.isEmpty()) {
                entity = ModEntities.CHAIR_ENT.get().spawn((ServerLevel) level, pos, MobSpawnType.TRIGGERED);
            } else {
                entity = entities.get(0);
            }

            player.startRiding(entity);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!level.isClientSide() && !state.is(newState.getBlock())) { // Ensure the block actually changed
            List<ChairEntity> entities = level.getEntities(ModEntities.CHAIR_ENT.get(), new AABB(pos), chair -> true);

            for (ChairEntity entity : entities) {
                entity.remove(Entity.RemovalReason.DISCARDED);
            }
        }

        super.onRemove(state, level, pos, newState, isMoving);
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

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("tooltip.testermod.red_gc1.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.testermod.red_gc2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.testermod.red_gc3.tooltip"));
        //for a new line in the tooltip, copy the same line as above and just replace the pKey
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
