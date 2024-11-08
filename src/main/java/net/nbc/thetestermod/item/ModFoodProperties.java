package net.nbc.thetestermod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties
{
    public static final FoodProperties KRABS = new FoodProperties.Builder().nutrition(5).saturationModifier(0.25f)
            .effect(new MobEffectInstance(MobEffects.POISON, 200, 2), 0.85f).alwaysEdible().build();
}
