package net.nbc.thetestermod.screen.custom;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.block.entity.custom.CodeVaultBlockEntity;
import net.nbc.thetestermod.block.entity.custom.ImpurifierBlockEntity;
import net.nbc.thetestermod.screen.ModMenuTypes;
import net.neoforged.neoforge.items.SlotItemHandler;

import javax.annotation.Nullable;

public class VaultMenu extends AbstractContainerMenu {
    private final CodeVaultBlockEntity blockEntity;

    private String currentCode = "";

    public VaultMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(2));
    }

    public VaultMenu(int pContainerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.VAULT_BLOCK_MENU.get(), pContainerId);
        this.blockEntity = ((CodeVaultBlockEntity) entity);
    }

    public CodeVaultBlockEntity getBlockEntity() {
        return blockEntity;
    }

    @Override
    public boolean clickMenuButton(Player player, int number) {
        currentCode += number;
        if (currentCode.length() >= blockEntity.getCodeLength()) {
            if (blockEntity.isCorrectCode(currentCode)) {
                blockEntity.setUnlocked(true);
                if (!player.level().isClientSide()) {
                    blockEntity.removeConnectedWalls(10);
                    blockEntity.setChanged();
                }
            }
            currentCode = "";
        }
        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(blockEntity.getLevel(), blockEntity.getBlockPos()),
                player, ModBlocks.STEELIUM_VAULT.get());
    }
}
