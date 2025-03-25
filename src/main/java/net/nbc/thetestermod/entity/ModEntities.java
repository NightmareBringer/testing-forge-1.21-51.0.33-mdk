package net.nbc.thetestermod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.entity.custom.TesterEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TesterMod.MOD_ID);

    public static final RegistryObject<EntityType<TesterEntity>> TESTER_MOB =
            ENTITY_TYPES.register("tester_mob", () -> EntityType.Builder.of(TesterEntity::new, MobCategory.MONSTER)
                    .sized(0.5f, 2.2f).build("tester_mob"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
