package net.nbc.thetestermod.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.nbc.thetestermod.util.ModTags;

public class ModToolTiers
{
    public static final Tier NIGHTMARE = new ForgeTier(2150, 15f, 7f, 30,
            ModTags.Blocks.NEEDS_NIGHTMARE_TOOL, () -> Ingredient.of(ModItems.NIGHTMARE_INGOT.get()),
            ModTags.Blocks.INCORRECT_FOR_NIGHTMARE_TOOL);

    public static final Tier STORM = new ForgeTier(3215, 40f, 9f, 40,
            ModTags.Blocks.NEEDS_STORM_TOOL, () -> Ingredient.of(ModItems.STORM_INGOT.get()),
            ModTags.Blocks.INCORRECT_FOR_STORM_TOOL);


    public static final Tier DEVILSKNIFE = new ForgeTier(1366, 25f, 5f, 50,
            ModTags.Blocks.NEEDS_DEVILSKNIFE_TOOL, () -> Ingredient.of(ModItems.IMPURE_STICK.get()),
            ModTags.Blocks.INCORRECT_FOR_DEVILSKNIFE_TOOL);
}
