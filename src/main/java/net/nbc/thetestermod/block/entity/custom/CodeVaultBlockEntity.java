package net.nbc.thetestermod.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.block.entity.ModBlockEntities;
import net.nbc.thetestermod.screen.custom.PurifierBlockMenu;
import net.nbc.thetestermod.screen.custom.VaultMenu;
import org.jetbrains.annotations.Nullable;

public class CodeVaultBlockEntity extends BlockEntity implements MenuProvider {
    private String code = "10039";
    private boolean unlocked = false;

    public CodeVaultBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.VAULT_BLOCK_BE.get(), pos, blockState);
    }

    public boolean isCorrectCode(String code) {
        return code.equals(code);
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
        setChanged(); // sync with clients
    }

    public void removeConnectedWalls(int radius) {
        // destroy wall blocks connected to this vault
        if (level == null) return;
        BlockPos center = this.getBlockPos();
        for (BlockPos pos : BlockPos.betweenClosed(center.offset(-radius, -radius, -radius),
                center.offset(radius, radius, radius))) {
            if (level.getBlockState(pos).is(ModBlocks.STEELIUM_VAULT_WALL.get())) {
                level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
            }
        }
        this.setChanged();
    }

    public int getCodeLength() {
        return code.length();
    }

    public String getCode() {
        return this.code;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void unlock() {
        this.unlocked = true;
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Code Vaulter");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new VaultMenu(i, null, this,null);
    }
}
