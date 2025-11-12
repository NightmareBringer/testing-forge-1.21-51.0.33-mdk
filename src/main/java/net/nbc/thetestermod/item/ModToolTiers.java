package net.nbc.thetestermod.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.nbc.thetestermod.block.ModBlocks;
import net.neoforged.neoforge.common.SimpleTier;
import net.nbc.thetestermod.util.ModTags;

public class ModToolTiers {

    public static final Tier FALSE_NIGHTMARE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_FALSE_NIGHTMARE_TOOL,
            676, 9f, 5f, 5, () -> Ingredient.of(ModItems.FALSE_NIGHTMARITE_INGOT));

    public static final Tier FALSE_STORM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_FALSE_STORM_TOOL,
            823, 12f, 4f, 8, () -> Ingredient.of(ModItems.FALSE_STORMITE_INGOT));

    public static final Tier NIGHTMARE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_NIGHTMARE_TOOL,
            2150, 17f, 7f, 10, () -> Ingredient.of(ModItems.NIGHTMARE_INGOT));

    public static final Tier PURE_STORM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_PURE_STORM_TOOL,
            2932, 21f, 6f, 10, () -> Ingredient.of(ModItems.STORM_INGOT));

    public static final Tier STORM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_STORM_TOOL,
            3215, 27f, 8f, 15, () -> Ingredient.of(ModItems.STORM_INGOT));

    public static final Tier PURE_NIGHTMARE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_PURE_NIGHTMARE_TOOL,
            3896, 23f, 9f, 15, () -> Ingredient.of(ModItems.NIGHTMARE_INGOT));

    public static final Tier DEVILSKNIFE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_DEVILSKNIFE_TOOL,
            1366, 33f, 5f, 33, () -> Ingredient.of(ModItems.IMPURE_STICK));

    public static final Tier KNIFE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_DEVILSKNIFE_TOOL,
            200, 15f, 3f, 22, () -> Ingredient.of(Items.IRON_INGOT));

    public static final Tier STEELIUM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_STEELIUM_TOOL,
            72, 50f, 6f, 0, () -> Ingredient.of(ModItems.STEELICHROME_PICKAXE));

    public static final Tier REFINED_STEELICHROME = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_REFINED_STEELICHROME_TOOL,
            1425, 21f, 7.5f, 15, () -> Ingredient.of(ModItems.REFINED_STEELICHROME_INGOT));
}
