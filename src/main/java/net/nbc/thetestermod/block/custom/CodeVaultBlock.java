package net.nbc.thetestermod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.block.entity.custom.CodeVaultBlockEntity;
import net.nbc.thetestermod.block.entity.custom.ImpurifierBlockEntity;
import net.nbc.thetestermod.block.entity.custom.PurifierBlockEntity;
import net.nbc.thetestermod.screen.custom.VaultScreen;
import org.jetbrains.annotations.Nullable;

public class CodeVaultBlock extends BaseEntityBlock {
    public static final MapCodec<CodeVaultBlock> CODEC = simpleCodec(CodeVaultBlock::new);

    public CodeVaultBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos,
                                              Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof CodeVaultBlockEntity growthChamberBlockEntity) {
                ((ServerPlayer) pPlayer).openMenu(new SimpleMenuProvider(growthChamberBlockEntity, Component.literal("Code Vault")), pPos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }

        return ItemInteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    CodeVaultBlockEntity blockEntity;

    public void removeConnectedWalls(ServerLevel level, int radius) {

    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (blockEntity.isUnlocked()) {
            removeConnectedWalls(level, 10);
        }

        super.tick(state, level, pos, random);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CodeVaultBlockEntity(blockPos, blockState);
    }
}
