package net.nbc.thetestermod.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.nbc.thetestermod.item.ModItems;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.nbc.thetestermod.block.entity.ModBlockEntities;
import net.nbc.thetestermod.recipe.ImpurifierBlockRecipe;
import net.nbc.thetestermod.recipe.ImpurifierBlockRecipeInput;
import net.nbc.thetestermod.recipe.ModRecipes;
import net.nbc.thetestermod.screen.custom.ImpurifierBlockMenu;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ImpurifierBlockEntity extends BlockEntity implements MenuProvider {

    public final ItemStackHandler itemHandler = new ItemStackHandler(3) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    private static final int INPUT_SLOT  = 0;
    private static final int FUEL_SLOT   = 1;
    private static final int OUTPUT_SLOT = 2;

    protected final ContainerData data;
    private int progress     = 0;
    private int maxProgress  = 225;
    private int burnTime     = 0;
    private int maxBurnTime  = 225;

    public ImpurifierBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.IMPURIFIER_BLOCK_BE.get(), pos, blockState);
        data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i) {
                    case 0 -> ImpurifierBlockEntity.this.progress;
                    case 1 -> ImpurifierBlockEntity.this.maxProgress;
                    case 2 -> ImpurifierBlockEntity.this.burnTime;
                    case 3 -> ImpurifierBlockEntity.this.maxBurnTime;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i) {
                    case 0 -> ImpurifierBlockEntity.this.progress = value;
                    case 1 -> ImpurifierBlockEntity.this.maxProgress = value;
                    case 2 -> ImpurifierBlockEntity.this.burnTime = value;
                    case 3 -> ImpurifierBlockEntity.this.maxBurnTime = value;
                }
            }

            @Override
            public int getCount() {
                return 4;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.testermod.impurifier_block");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new ImpurifierBlockMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        pTag.put("inventory", itemHandler.serializeNBT(pRegistries));
        pTag.putInt("impurifier_block.progress", progress);
        pTag.putInt("impurifier_block.max_progress", maxProgress);
        pTag.putInt("impurifier_block.burn_time", burnTime);
        pTag.putInt("impurifier_block.man_burn_time", maxBurnTime);
        super.saveAdditional(pTag, pRegistries);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);

        itemHandler.deserializeNBT(pRegistries, pTag.getCompound("inventory"));
        progress = pTag.getInt("impurifier_block.progress");
        maxProgress = pTag.getInt("impurifier_block.max_progress");
        burnTime = pTag.getInt("impurifier_block.burn_time");
        maxBurnTime = pTag.getInt("impurifier_block.man_burn_time");
    }

    public void tick(Level level, BlockPos blockPos, BlockState blockState) {
        boolean isBurning = burnTime > 0;
        boolean stateChanged = false;

        if (burnTime > 0) {
            burnTime--;
        }

        ItemStack fuelStack = itemHandler.getStackInSlot(FUEL_SLOT);

        // Start burning if needed
        if (burnTime == 0 && hasRecipe() && !fuelStack.isEmpty()) {
            int fuelBurn = getFuelTime(fuelStack);
            if (fuelBurn > 0) {
                burnTime = fuelBurn;
                maxBurnTime = fuelBurn;
                fuelStack.shrink(1);
                stateChanged = true;
            }
        }

        if (isBurning && hasRecipe()) {
            increaseCraftingProgress();
            if (hasCraftingFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }

        if (stateChanged) {
            setChanged(level, blockPos, blockState);
        }
    }

    private int getFuelTime(ItemStack stack) {
        if (stack.is(ModItems.WOVEN_INDIGO_BRICK.get())) {
            return 33; // (coal = 1600)
        }
        return 0;
    }

    private void craftItem() {
        Optional<RecipeHolder<ImpurifierBlockRecipe>> recipe = getCurrentRecipe();
        ItemStack output = recipe.get().value().output();

        itemHandler.extractItem(INPUT_SLOT, 1, false);
        itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(output.getItem(),
                itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + output.getCount()));
    }

    private void resetProgress() {
        progress = 0;
        maxProgress = 350;
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        Optional<RecipeHolder<ImpurifierBlockRecipe>> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) {
            return false;
        }

        ItemStack output = recipe.get().value().output();
        return canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
    }

    private Optional<RecipeHolder<ImpurifierBlockRecipe>> getCurrentRecipe() {
        return this.level.getRecipeManager()
                .getRecipeFor(ModRecipes.IMPURIFIER_BLOCK_TYPE.get(), new ImpurifierBlockRecipeInput(itemHandler.getStackInSlot(INPUT_SLOT)), level);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() ||
                itemHandler.getStackInSlot(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() ? 64 : itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
        int currentCount = itemHandler.getStackInSlot(OUTPUT_SLOT).getCount();

        return maxCount >= currentCount + count;
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
