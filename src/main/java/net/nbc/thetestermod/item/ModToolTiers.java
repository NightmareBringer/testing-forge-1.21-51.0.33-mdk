package net.nbc.thetestermod.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.nbc.thetestermod.util.ModTags;

public class ModToolTiers
{
    public static final Tier NIGHTMARE = new ForgeTier(2000, 12.5f, 5.5f, 30,
            ModTags.Blocks.NEEDS_NIGHTMARE_TOOL, () -> Ingredient.of(ModItems.NIGHTMARE_INGOT.get()),
            ModTags.Blocks.INCORRECT_FOR_NIGHTMARE_TOOL);
}
