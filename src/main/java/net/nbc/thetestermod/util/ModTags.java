package net.nbc.thetestermod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.nbc.thetestermod.TesterMod;

public class ModTags
{
    public static class Blocks
    {
        // ===== REG NIGHTMARE =====
        public static final TagKey<Block> NEEDS_NIGHTMARE_TOOL = createTag("needs_nightmare_tool");
        public static final TagKey<Block> INCORRECT_FOR_NIGHTMARE_TOOL = createTag("incorrect_for_nightmare_tool");

        // ===== FALSE NIGHTMARE =====
        public static final TagKey<Block> NEEDS_FALSE_NIGHTMARE_TOOL = createTag("needs_false_nightmare_tool");
        public static final TagKey<Block> INCORRECT_FOR_FALSE_NIGHTMARE_TOOL = createTag("incorrect_for_false_nightmare_tool");

        // ===== PURE NIGHTMARE =====
        public static final TagKey<Block> NEEDS_PURE_NIGHTMARE_TOOL = createTag("needs_pure_nightmare_tool");
        public static final TagKey<Block> INCORRECT_FOR_PURE_NIGHTMARE_TOOL = createTag("incorrect_for_pure_nightmare_tool");

        // ===== IMPURE STORM =====
        public static final TagKey<Block> NEEDS_STORM_TOOL = createTag("needs_storm_tool");
        public static final TagKey<Block> INCORRECT_FOR_STORM_TOOL = createTag("incorrect_for_storm_tool");

        // ===== FALSE STORM =====
        public static final TagKey<Block> NEEDS_FALSE_STORM_TOOL = createTag("needs_false_storm_tool");
        public static final TagKey<Block> INCORRECT_FOR_FALSE_STORM_TOOL = createTag("incorrect_for_false_storm_tool");

        // ===== PURE STORM =====
        public static final TagKey<Block> NEEDS_PURE_STORM_TOOL = createTag("needs_pure_storm_tool");
        public static final TagKey<Block> INCORRECT_FOR_PURE_STORM_TOOL = createTag("incorrect_for_pure_storm_tool");

        public static final TagKey<Block> NEEDS_DEVILSKNIFE_TOOL = createTag("needs_devilsknife_tool");
        public static final TagKey<Block> INCORRECT_FOR_DEVILSKNIFE_TOOL = createTag("incorrect_for_devilsknife_tool");

        public static final TagKey<Block> NEEDS_STEELIUM_TOOL = createTag("needs_steelium_tool");
        public static final TagKey<Block> INCORRECT_FOR_STEELIUM_TOOL = createTag("incorrect_for_steelium_tool");

        public static final TagKey<Block> NEEDS_REFINED_STEELICHROME_TOOL = createTag("needs_refined_steelichrome_tool");
        public static final TagKey<Block> INCORRECT_FOR_REFINED_STEELICHROME_TOOL = createTag("incorrect_for_refined_steelichrome_tool");


        private static TagKey<Block> createTag(String name)
        {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, name));
        }
    }

    public static class Items
    {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name)
        {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, name));
        }
    }
}
