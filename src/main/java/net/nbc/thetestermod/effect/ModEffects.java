package net.nbc.thetestermod.effect;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nbc.thetestermod.TesterMod;

public class ModEffects
{
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TesterMod.MOD_ID);

    public static final RegistryObject<MobEffect> PURIFICATION_EFFECT = MOB_EFFECTS.register("purification",
            () -> new PurificationEffect(MobEffectCategory.BENEFICIAL, 0x00ffb3));

    public static final RegistryObject<MobEffect> IMPURIFICATION_EFFECT = MOB_EFFECTS.register("impurification",
            () -> new ImpurificationEffect(MobEffectCategory.NEUTRAL, 0x3c017a));


    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
