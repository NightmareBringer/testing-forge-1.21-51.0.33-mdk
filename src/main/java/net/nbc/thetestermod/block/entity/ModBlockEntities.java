package net.nbc.thetestermod.block.entity;

import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.nbc.thetestermod.block.entity.custom.ImpurifierBlockEntity;
import net.nbc.thetestermod.block.entity.custom.PedestalBlockEntity;
import net.nbc.thetestermod.block.entity.custom.PurifierBlockEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, TesterMod.MOD_ID);

    public static final Supplier<BlockEntityType<PedestalBlockEntity>> PEDESTAL_BE =
            BLOCK_ENTITIES.register("pedestal_be", () -> BlockEntityType.Builder.of(
                    PedestalBlockEntity::new, ModBlocks.PEDESTAL_BLOCK.get()).build(null));

    public static final Supplier<BlockEntityType<PurifierBlockEntity>> PURIFIER_BLOCK_BE =
            BLOCK_ENTITIES.register("purifier_block_be", () -> BlockEntityType.Builder.of(
                    PurifierBlockEntity::new, ModBlocks.PURIFIER_BLOCK.get()).build(null));

    public static final Supplier<BlockEntityType<ImpurifierBlockEntity>> IMPURIFIER_BLOCK_BE =
            BLOCK_ENTITIES.register("impurifier_block_be", () -> BlockEntityType.Builder.of(
                    ImpurifierBlockEntity::new, ModBlocks.IMPURIFIER_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
