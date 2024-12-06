package net.nbc.thetestermod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.nbc.thetestermod.effect.ModEffects;

public class ModFoodProperties
{
    public static final FoodProperties KRABS = new FoodProperties.Builder().nutrition(2).saturationModifier(0.05f)
            .effect(new MobEffectInstance(MobEffects.HARM, 1, 1), 1.0f).alwaysEdible().build();

    public static final FoodProperties CRIMSON_BLUE_BERRIES = new FoodProperties.Builder().nutrition(3).saturationModifier(0.15f).fast().build();

    public static final FoodProperties WHITE_CARROT = new FoodProperties.Builder().nutrition(5).saturationModifier(0.25f).build();

    public static final FoodProperties GLISTERING_CARROT = new FoodProperties.Builder().nutrition(8).saturationModifier(0.65f)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 1800, 1), 1.0f)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1800, 1), 1.0f)
            .effect(new MobEffectInstance(ModEffects.PURIFICATION_EFFECT.getHolder().get(), 800, 0), 0.65f).build();
}
