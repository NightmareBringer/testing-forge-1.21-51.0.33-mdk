package net.nbc.thetestermod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.nbc.thetestermod.block.entity.custom.CodeVaultBlockEntity;
import net.nbc.thetestermod.component.ModDataComponentTypes;
import net.nbc.thetestermod.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
                                              Player player, InteractionHand hand, BlockHitResult hit) {
        boolean hasKey = player.getMainHandItem().is(ModItems.STEELICHROME_KEYS.get())
                || player.getOffhandItem().is(ModItems.STEELICHROME_KEYS.get());

        if (!level.isClientSide()) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof CodeVaultBlockEntity vaultBE && player instanceof ServerPlayer serverPlayer) {
                // record intent for the menu about set-mode
                vaultBE.setPendingSetMode(hasKey);
                serverPlayer.openMenu(vaultBE, pos);
            }
        }

        return ItemInteractionResult.sidedSuccess(level.isClientSide());
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);

        if (level.getBlockEntity(pos) instanceof CodeVaultBlockEntity codeVaultBlockEntity) {
            String savedCode = stack.get(ModDataComponentTypes.VAULT_CODE.get()); // Use your component
            if (savedCode != null) {
                codeVaultBlockEntity.setCurrentCode(savedCode);
            }
        }
    }

    @Override
    public boolean canHarvestBlock(BlockState state, BlockGetter level, BlockPos pos, Player player) {
        ItemStack held = player.getMainHandItem();
        return held.is(ModItems.STEELICHROME_PICKAXE.get());
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.testermod.vault_block1").withStyle(ChatFormatting.GRAY));
        tooltipComponents.add(Component.translatable("tooltip.testermod.vault_block2").withStyle(ChatFormatting.GRAY));

        // Check if VaultCode exists in the item’s components
        if (stack.has(net.nbc.thetestermod.component.ModDataComponentTypes.VAULT_CODE.get())) {
            String code = stack.get(net.nbc.thetestermod.component.ModDataComponentTypes.VAULT_CODE.get());

            // Only show if Shift is held
            if (net.minecraft.client.gui.screens.Screen.hasShiftDown()) {
                tooltipComponents.add(Component.literal("Hold SHIFT for code: " + code).withStyle(ChatFormatting.GREEN));
            } else {
                tooltipComponents.add(Component.literal("Hold SHIFT for code: ").withStyle(ChatFormatting.GRAY));
            }
        }

        //tooltipComponents.add(Component.translatable("tooltip.testermod.vault_block_code"));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CodeVaultBlockEntity(pos, state);
    }
}
