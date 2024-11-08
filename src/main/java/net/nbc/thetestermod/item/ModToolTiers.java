package net.nbc.thetestermod.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.nbc.thetestermod.util.ModTags;

public class ModToolTiers
{
    public static final Tier NIGHTMARE = new ForgeTier(2150, 14f, 7f, 30,
            ModTags.Blocks.NEEDS_NIGHTMARE_TOOL, () -> Ingredient.of(ModItems.NIGHTMARE_INGOT.get()),
            ModTags.Blocks.INCORRECT_FOR_NIGHTMARE_TOOL);

    public static final Tier DEVILSKNIFE = new ForgeTier(1300, 20f, 5f, 50,
            ModTags.Blocks.NEEDS_DEVILSKNIFE_TOOL, () -> Ingredient.of(ModItems.IMPURE_STICK.get()),
            ModTags.Blocks.INCORRECT_FOR_DEVILSKNIFE_TOOL);
}
