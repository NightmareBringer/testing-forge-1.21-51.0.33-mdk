package net.nbc.thetestermod.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
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

public class ModBoatEntity extends Boat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(ModBoatEntity.class, EntityDataSerializers.INT);

    public ModBoatEntity(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level);
    }

    public ModBoatEntity(Level level, double x, double y, double z) {
        this(ModEntities.MOD_BOAT_ENT.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    public Item getDropItem() {
        return switch (getModVariant()) {
            case CORRUPTED_OAK -> ModItems.CORRUPTED_OAK_BOAT.get();
        };
    }

    public void setVariant(Type variant) {
        this.entityData.set(DATA_ID_TYPE, variant.ordinal());
    }

    public Type getModVariant() {
        return Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_TYPE, Type.CORRUPTED_OAK.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putString("Type", this.getModVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag compound) {
        if (compound.contains("Type", 8)) {
            this.setVariant(Type.byName(compound.getString("Type")));
        }
    }

    public static enum Type implements StringRepresentable, IExtensibleEnum {
        CORRUPTED_OAK(ModBlocks.CORRUPTED_OAK_PLANKS.get(), "corrupted_oak");

        private final String name;
        private final Block planks;
        private final Supplier<Block> planksSupplier;
        final Supplier<Item> boatItem;
        final Supplier<Item> chestBoatItem;
        private final Supplier<Item> stickItem;
        private final boolean raft;
        public static final StringRepresentable.EnumCodec<ModBoatEntity.Type> CODEC = StringRepresentable.fromEnum(ModBoatEntity.Type::values);
        private static final IntFunction<ModBoatEntity.Type> BY_ID = ByIdMap.continuous(Enum::ordinal, values(), ByIdMap.OutOfBoundsStrategy.ZERO);

        @ReservedConstructor
        private Type(Block planks, String name) {
            this(planks, name, false);
        }

        @ReservedConstructor
        private Type(Block planks, String name, boolean raft) {
            this.name = name;
            this.planks = planks;
            this.planksSupplier = () -> {
                return planks;
            };
            this.boatItem = () -> {
                return Items.AIR;
            };
            this.chestBoatItem = () -> {
                return Items.AIR;
            };
            this.stickItem = () -> {
                return Items.STICK;
            };
            this.raft = raft;
        }

        private Type(Supplier planks, String name, Supplier boatItem, Supplier chestBoatItem, Supplier stickItem, boolean raft) {
            this.name = name;
            this.planks = Blocks.AIR;
            this.planksSupplier = planks;
            this.boatItem = boatItem;
            this.chestBoatItem = chestBoatItem;
            this.stickItem = stickItem;
            this.raft = raft;
        }

        public String getSerializedName() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }

        public Block getPlanks() {
            return (Block)this.planksSupplier.get();
        }

        public Item getSticks() {
            return (Item)this.stickItem.get();
        }

        public boolean isRaft() {
            return this.raft;
        }

        public String toString() {
            return this.name;
        }

        public static ModBoatEntity.Type byId(int id) {
            return (ModBoatEntity.Type)BY_ID.apply(id);
        }

        public static ModBoatEntity.Type byName(String name) {
            return (ModBoatEntity.Type)CODEC.byName(name, CORRUPTED_OAK);
        }

        public static ExtensionInfo getExtensionInfo() {
            return ExtensionInfo.nonExtended(ModBoatEntity.Type.class);
        }
    }

}
