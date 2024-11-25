package net.nbc.thetestermod.potion;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.effect.ModEffects;

public class ModPotions
{
    public  static  final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, TesterMod.MOD_ID);

    public static final RegistryObject<Potion> PURIFICATION_POTION = POTIONS.register("purification_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.PURIFICATION_EFFECT.getHolder().get(), 600, 0)));

    public static final RegistryObject<Potion> IMPURIFICATION_POTION = POTIONS.register("impurification_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.IMPURIFICATION_EFFECT.getHolder().get(), 600, 0)));


    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
