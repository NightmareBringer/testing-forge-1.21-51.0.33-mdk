package net.nbc.thetestermod.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.nbc.thetestermod.util.ModTags;

public class ModToolTiers {
    public static final Tier NIGHTMARE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_NIGHTMARE_TOOL,
            2150, 15f, 7f, 10, () -> Ingredient.of(ModItems.NIGHTMARE_INGOT));

    public static final Tier STORM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_STORM_TOOL,
            3215, 40f, 9f, 15, () -> Ingredient.of(ModItems.STORM_INGOT));

    public static final Tier DEVILSKNIFE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_DEVILSKNIFE_TOOL,
            1366, 25f, 5f, 22, () -> Ingredient.of(ModItems.IMPURE_STICK));

    public static final Tier KNIFE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_DEVILSKNIFE_TOOL,
            200, 15f, 3f, 22, () -> Ingredient.of(Items.STICK));

}
