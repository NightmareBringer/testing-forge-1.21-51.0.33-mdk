package net.nbc.thetestermod.loot;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.loot.custom.ChargedCreeperCondition;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModLootConditions {
    public static final DeferredRegister<LootItemConditionType> LOOT_CONDITIONS =
            DeferredRegister.create(Registries.LOOT_CONDITION_TYPE, TesterMod.MOD_ID);

    // register the condition type using the MapCodec from ChargedCreeperCondition
    public static final Supplier<LootItemConditionType> CHARGED_CREEPER =
            LOOT_CONDITIONS.register("charged_creeper",
                    () -> new LootItemConditionType(ChargedCreeperCondition.CODEC));

    public static void register(IEventBus eventBus) {
        LOOT_CONDITIONS.register(eventBus);
    }
}
