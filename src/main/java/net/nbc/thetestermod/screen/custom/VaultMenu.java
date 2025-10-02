package net.nbc.thetestermod.screen.custom;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.block.entity.custom.CodeVaultBlockEntity;
import net.nbc.thetestermod.item.ModItems;
import net.nbc.thetestermod.screen.ModMenuTypes;

public class VaultMenu extends AbstractContainerMenu {
    private final CodeVaultBlockEntity blockEntity;
    private final boolean settingNewCode;

    public VaultMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), false);
    }

    public VaultMenu(int id, Inventory inv, BlockEntity entity, boolean settingNewCode) {
        super(ModMenuTypes.VAULT_BLOCK_MENU.get(), id);
        this.blockEntity = (CodeVaultBlockEntity) entity;
        this.settingNewCode = settingNewCode;
    }

    public CodeVaultBlockEntity getBlockEntity() {
        return blockEntity;
    }

    public boolean isSettingNewCode() {
        return this.settingNewCode;
    }

    public void onCodeEntered(String code, Player player, Level level) {
        boolean hasKey = player.getMainHandItem().is(ModItems.STEELICHROME_KEYS.get())
                || player.getOffhandItem().is(ModItems.STEELICHROME_KEYS.get());

        if (hasKey) {
            if (!code.isEmpty() && code.length() <= 10) {
                blockEntity.setCurrentCode(code);

                if (!level.isClientSide()) {
                    if (player.getMainHandItem().is(ModItems.STEELICHROME_KEYS.get())) {
                        player.getMainHandItem().shrink(1);
                        level.playSound(null, player, SoundEvents.ITEM_BREAK,
                                SoundSource.BLOCKS, 1.0f, 0.86f);
                    } else if (player.getOffhandItem().is(ModItems.STEELICHROME_KEYS.get())) {
                        player.getOffhandItem().shrink(1);
                        level.playSound(null, player, SoundEvents.ITEM_BREAK,
                                SoundSource.BLOCKS, 1.0f, 0.86f);
                    }
                }
            }
        } else {
            if (code.equals(blockEntity.getCurrentCode())) {
                blockEntity.removeConnectedWalls(5);
            }
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(blockEntity.getLevel(), blockEntity.getBlockPos()),
                player, this.blockEntity.getBlockState().getBlock());
    }
}
