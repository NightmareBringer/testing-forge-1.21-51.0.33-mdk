package net.nbc.thetestermod.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.block.entity.ModBlockEntities;
import net.nbc.thetestermod.screen.custom.VaultMenu;
import net.nbc.thetestermod.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

public class CodeVaultBlockEntity extends BlockEntity implements MenuProvider {
    private String currentCode = "10039";
    private boolean pendingSetMode = false;

    public CodeVaultBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.VAULT_BLOCK_BE.get(), pos, state);
    }

    public String getCurrentCode() {
        return currentCode;
    }

    public void setCurrentCode(String newCode) {
        this.currentCode = newCode;
        setChanged();
    }

    public void setPendingSetMode(boolean value) {
        this.pendingSetMode = value;
        setChanged();
    }

    private boolean consumePendingSetMode() {
        boolean v = this.pendingSetMode;
        this.pendingSetMode = false;
        setChanged();
        return v;
    }

    public void removeConnectedWalls(int radius) {
        if (level == null) return;

        BlockPos center = getBlockPos();
        BlockPos.MutableBlockPos m = new BlockPos.MutableBlockPos();

        for (int dx = -radius; dx <= radius; dx++) {
            for (int dy = -radius; dy <= radius; dy++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    m.set(center.getX() + dx, center.getY() + dy, center.getZ() + dz);
                    BlockState state = level.getBlockState(m);
                    if (state.is(ModBlocks.STEELIUM_VAULT_WALL.get())) {
                        Block.dropResources(state, level, m, level.getBlockEntity(m));

                        level.playSound(null, m, ModSounds.STEEL_BREAK.get(),
                                SoundSource.BLOCKS, 0.5f, 1.0f);

                        level.setBlock(m, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                    }
                }
            }
        }
        setChanged();
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Code Vault");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        boolean setMode = consumePendingSetMode();
        return new VaultMenu(id, inv, this, setMode);
    }
}
