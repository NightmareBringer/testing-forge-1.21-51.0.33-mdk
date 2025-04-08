package net.nbc.thetestermod.datagen;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.item.ModItems;
import net.nbc.thetestermod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                              CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, TesterMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.NIGHTMARE_INGOT.get())
                .add(ModItems.NIGHTMARE_NUGGET.get())
                .add(ModItems.STORMITE.get())
                .add(ModItems.IMPURE_STORMITE.get())
                .add(ModItems.MYSTERIOUS_DUST.get())
                .add(Items.DIRT)
                .add(Items.ENDER_EYE)
                .add(Items.ENDER_PEARL)
                .add(Items.NETHER_STAR)
                .add(Items.BLAZE_POWDER)
                .add(Items.BLAZE_ROD);

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.NIGHTMARE_HELMET.get())
                .add(ModItems.NIGHTMARE_CHESTPLATE.get())
                .add(ModItems.NIGHTMARE_LEGGINGS.get())
                .add(ModItems.NIGHTMARE_BOOTS.get())
                .add(ModItems.STORM_HELMET.get())
                .add(ModItems.STORM_CHESTPLATE.get())
                .add(ModItems.STORM_LEGGINGS.get())
                .add(ModItems.STORM_BOOTS.get());


        tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.NIGHTMARE_INGOT.get())
                .add(ModItems.STORM_INGOT.get());

        tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.NIGHTEN_SMITHING_TEMPLATE.get())
                .add(ModItems.STORMEN_SMITHING_TEMPLATE.get());

        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.CORRUPTED_OAK_LOG.get().asItem())
                .add(ModBlocks.CORRUPTED_OAK_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_CORRUPTED_OAK_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_CORRUPTED_OAK_WOOD.get().asItem());

        tag(ItemTags.PLANKS)
                .add(ModBlocks.CORRUPTED_OAK_PLANKS.get().asItem());

    }
}
