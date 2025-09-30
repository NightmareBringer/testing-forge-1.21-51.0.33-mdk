package net.nbc.thetestermod.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.nbc.thetestermod.block.ModBlocks;
import net.neoforged.neoforge.common.SimpleTier;
import net.nbc.thetestermod.util.ModTags;

public class ModToolTiers {
    // ===== IMPURE NIGHTMARE =====
    public static final Tier NIGHTMARE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_NIGHTMARE_TOOL,
            2150, 30f, 7f, 10, () -> Ingredient.of(ModItems.NIGHTMARE_INGOT));

    // ===== FALSE NIGHTMARE =====
    public static final Tier FALSE_NIGHTMARE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_FALSE_NIGHTMARE_TOOL,
            1676, 20f, 4f, 5, () -> Ingredient.of(ModItems.FALSE_NIGHTMARITE_INGOT));

    // ===== PURE NIGHTMARE =====
    public static final Tier PURE_NIGHTMARE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_PURE_NIGHTMARE_TOOL,
            3896, 40f, 9f, 15, () -> Ingredient.of(ModItems.NIGHTMARE_INGOT));

    // ===== FALSE STORM =====
    public static final Tier FALSE_STORM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_FALSE_STORM_TOOL,
            1823, 15f, 5f, 8, () -> Ingredient.of(ModItems.FALSE_STORMITE_INGOT));

    // ===== PURE STORM =====
    public static final Tier PURE_STORM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_PURE_STORM_TOOL,
            2932, 25f, 7f, 10, () -> Ingredient.of(ModItems.STORM_INGOT));

    // ===== IMPURE STORM =====
    public static final Tier STORM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_STORM_TOOL,
            3215, 35f, 8f, 15, () -> Ingredient.of(ModItems.STORM_INGOT));

    public static final Tier DEVILSKNIFE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_DEVILSKNIFE_TOOL,
            1366, 25f, 5f, 22, () -> Ingredient.of(ModItems.IMPURE_STICK));

    public static final Tier KNIFE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_DEVILSKNIFE_TOOL,
            200, 15f, 3f, 22, () -> Ingredient.of(Items.STICK));

    public static final Tier STEELIUM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_STEELIUM_TOOL,
            64, 50f, 5f, 0, () -> Ingredient.of(ModBlocks.STEELIUM_BLOCK));
}
