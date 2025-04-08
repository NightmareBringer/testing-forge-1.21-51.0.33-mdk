package net.nbc.thetestermod.potion;

import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.BuiltInRegistries;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, TesterMod.MOD_ID);

    public static final Holder<Potion> PURIFICATION_POTION = POTIONS.register("purification_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.PURIFICATION_EFFECT, 600, 0)));

    public static final Holder<Potion> IMPURIFICATION_POTION = POTIONS.register("impurification_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.IMPURIFICATION_EFFECT, 600, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}