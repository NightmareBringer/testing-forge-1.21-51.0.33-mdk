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
        public static final TagKey<Block> NEEDS_NIGHTMARE_TOOL = createTag("needs_nightmare_tool");
        public static final TagKey<Block> INCORRECT_FOR_NIGHTMARE_TOOL = createTag("incorrect_for_nightmare_tool");

        public static final TagKey<Block> NEEDS_STORM_TOOL = createTag("needs_storm_tool");
        public static final TagKey<Block> INCORRECT_FOR_STORM_TOOL = createTag("incorrect_for_storm_tool");

        public static final TagKey<Block> NEEDS_DEVILSKNIFE_TOOL = createTag("needs_devilsknife_tool");
        public static final TagKey<Block> INCORRECT_FOR_DEVILSKNIFE_TOOL = createTag("incorrect_for_devilsknife_tool");


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
