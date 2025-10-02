package net.nbc.thetestermod.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.block.entity.ModBlockEntities;
import net.nbc.thetestermod.component.ModDataComponentTypes;
import net.nbc.thetestermod.screen.custom.VaultMenu;
import net.nbc.thetestermod.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

public class CodeVaultBlockEntity extends BlockEntity implements MenuProvider {
    private String currentCode = "10039";
    private boolean pendingSetMode = false;
    //private CompoundTag custom = new CompoundTag();

    public CodeVaultBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.VAULT_BLOCK_BE.get(), pos, state);
    }

    public String getCurrentCode() {
        return currentCode;
    }

    public void setCurrentCode(String newCode) {
        this.currentCode = newCode;
        setChanged();

        if (this.level != null && !this.level.isClientSide) {
            BlockState state = this.getBlockState();
            this.level.sendBlockUpdated(this.worldPosition, state, state, Block.UPDATE_ALL);
        }
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

        Block wallBlock;
        if (getBlockState().is(ModBlocks.STEELIUM_VAULT_BLOCK.get())) {
            wallBlock = ModBlocks.STEELIUM_VAULT_WALL.get();
        } else if (getBlockState().is(ModBlocks.NEPTOCHROME_VAULT_BLOCK.get())) {
            wallBlock = ModBlocks.NEPTOCHROME_VAULT_WALL.get();
        } else {
            return; // Unknown vault type
        }

        BlockPos.betweenClosedStream(worldPosition.offset(-radius, -radius, -radius),
                        worldPosition.offset(radius, radius, radius))
                .forEach(pos -> {
                    if (level.getBlockState(pos).is(wallBlock)) {
                        level.destroyBlock(pos, true);
                    }
                });
        setChanged();
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.putString("steelium_vault_block.vaultCode", currentCode);
        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        currentCode = tag.getString("steelium_vault_block.vaultCode");
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag = super.getUpdateTag(registries);
        tag.putString("steelium_vault_block.vaultCode", currentCode);
        return tag;
    }

    @Override
    public void handleUpdateTag(CompoundTag tag, HolderLookup.Provider lookupProvider) {
        super.handleUpdateTag(tag, lookupProvider);
        currentCode = tag.getString("steelium_vault_block.vaultCode");
    }

    @Override
    protected void collectImplicitComponents(DataComponentMap.Builder components) {
        super.collectImplicitComponents(components);
        components.set(ModDataComponentTypes.VAULT_CODE.get(), this.currentCode);
    }

    @Override
    protected void applyImplicitComponents(DataComponentInput componentInput) {
        super.applyImplicitComponents(componentInput);
        this.currentCode = componentInput.getOrDefault(ModDataComponentTypes.VAULT_CODE.get(), "10039");
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public Component getDisplayName() {
        return this.getBlockState().getBlock().getName();
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        boolean setMode = consumePendingSetMode();
        return new VaultMenu(id, inv, this, setMode);
    }
}
