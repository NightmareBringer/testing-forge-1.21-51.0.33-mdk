package net.nbc.thetestermod.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.block.entity.custom.ImpurifierBlockEntity;
import net.nbc.thetestermod.block.entity.custom.PurifierBlockEntity;
import net.nbc.thetestermod.block.entity.custom.PedestalBlockEntity;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TesterMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<PedestalBlockEntity>> PEDESTAL_BE =
            BLOCK_ENTITIES.register("pedestal_be", () -> BlockEntityType.Builder.of(
                    PedestalBlockEntity::new, ModBlocks.PEDESTAL_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<PurifierBlockEntity>> PURIFIER_BLOCK_BE =
            BLOCK_ENTITIES.register("purifier_block_be", () -> BlockEntityType.Builder.of(
                    PurifierBlockEntity::new, ModBlocks.PURIFIER_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<ImpurifierBlockEntity>> IMPURIFIER_BLOCK_BE =
            BLOCK_ENTITIES.register("impurifier_block_be", () -> BlockEntityType.Builder.of(
                    ImpurifierBlockEntity::new, ModBlocks.IMPURIFIER_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
