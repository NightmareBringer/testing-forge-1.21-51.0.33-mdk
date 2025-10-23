package net.nbc.thetestermod.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.entity.ModEntities;
import net.nbc.thetestermod.item.ModItems;
import net.neoforged.fml.common.asm.enumextension.ExtensionInfo;
import net.neoforged.fml.common.asm.enumextension.IExtensibleEnum;
import net.neoforged.fml.common.asm.enumextension.ReservedConstructor;

import java.util.function.IntFunction;
import java.util.function.Supplier;

public class ModChestBoatEntity extends ChestBoat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(ModChestBoatEntity.class, EntityDataSerializers.INT);

    public ModChestBoatEntity(EntityType<? extends ChestBoat> entityType, Level level) {
        super(entityType, level);
    }

    public ModChestBoatEntity(Level level, double x, double y, double z) {
        this(ModEntities.MOD_CHEST_BOAT_ENT.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    public Item getDropItem() {
        switch (getModVariant()) {
            case CORRUPTED_OAK -> {
                return ModItems.CORRUPTED_OAK_CHEST_BOAT.get();
            }
        }
        return super.getDropItem();
    }

    public void setVariant(ModBoatEntity.Type variant) {
        this.entityData.set(DATA_ID_TYPE, variant.ordinal());
    }

    public ModBoatEntity.Type getModVariant() {
        return ModBoatEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_TYPE, ModBoatEntity.Type.CORRUPTED_OAK.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putString("Type", this.getModVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag compound) {
        if (compound.contains("Type", 8)) {
            this.setVariant(ModBoatEntity.Type.byName(compound.getString("Type")));
        }
    }
}
