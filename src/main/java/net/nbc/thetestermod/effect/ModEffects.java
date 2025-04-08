package net.nbc.thetestermod.effect;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.nbc.thetestermod.TesterMod;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, TesterMod.MOD_ID);

    public static final Holder<MobEffect> PURIFICATION_EFFECT = MOB_EFFECTS.register("purification",
            () -> new PurificationEffect(MobEffectCategory.BENEFICIAL, 0x00ffb3));

    public static final Holder<MobEffect> IMPURIFICATION_EFFECT = MOB_EFFECTS.register("impurification",
            () -> new ImpurificationEffect(MobEffectCategory.HARMFUL, 0x3c017a));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}