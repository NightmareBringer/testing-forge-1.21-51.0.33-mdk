package net.nbc.thetestermod.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.entity.custom.AlienEntity;
import net.nbc.thetestermod.entity.custom.ChairEntity;
import net.nbc.thetestermod.entity.custom.TesterEntity;
import net.nbc.thetestermod.entity.custom.ThrowingKnifeProjectileEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, TesterMod.MOD_ID);

    public static final Supplier<EntityType<TesterEntity>> TESTER_MOB =
            ENTITY_TYPES.register("tester_mob", () -> EntityType.Builder.of(TesterEntity::new, MobCategory.MONSTER)
                    .sized(0.25f, 1.9f).build("tester_mob"));

    public static final Supplier<EntityType<AlienEntity>> ALIEN_MOB =
            ENTITY_TYPES.register("alien_mob", () -> EntityType.Builder.of(AlienEntity::new, MobCategory.MONSTER)
                    .sized(1.0f, 3.6f).build("alien_mob"));

    public static final Supplier<EntityType<ThrowingKnifeProjectileEntity>> THROWING_KNIFE =
            ENTITY_TYPES.register("throwing_knife", () -> EntityType.Builder.<ThrowingKnifeProjectileEntity>of(ThrowingKnifeProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("throwing_knife"));

    public static final Supplier<EntityType<ChairEntity>> CHAIR_ENT =
            ENTITY_TYPES.register("chair_entity", () -> EntityType.Builder.of(ChairEntity::new, MobCategory.MISC)
                    .sized(0.75f, 0.5f).build("chair_entity"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
