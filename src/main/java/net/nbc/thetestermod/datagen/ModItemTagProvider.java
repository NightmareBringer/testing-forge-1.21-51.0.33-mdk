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
import net.neoforged.fml.common.Mod;
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
                .add(ModItems.IMPURE_NIGHTMARITE.get())
                .add(ModItems.NIGHTMARITE.get())
                .add(ModItems.STORMITE.get())
                .add(ModItems.PURE_STORMITE.get())
                .add(ModItems.STRANGE_STICK.get())
                .add(Items.LEATHER)
                .add(Items.ROTTEN_FLESH)
                .add(Items.ENDER_PEARL);

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.NIGHTMARE_HELMET.get())
                .add(ModItems.NIGHTMARE_CHESTPLATE.get())
                .add(ModItems.NIGHTMARE_LEGGINGS.get())
                .add(ModItems.NIGHTMARE_BOOTS.get())
                .add(ModItems.STORM_HELMET.get())
                .add(ModItems.STORM_CHESTPLATE.get())
                .add(ModItems.STORM_LEGGINGS.get())
                .add(ModItems.STORM_BOOTS.get())
                .add(ModItems.FALSE_NIGHTMARE_HELMET.get())
                .add(ModItems.FALSE_NIGHTMARE_CHESTPLATE.get())
                .add(ModItems.FALSE_NIGHTMARE_LEGGINGS.get())
                .add(ModItems.FALSE_NIGHTMARE_BOOTS.get())
                .add(ModItems.FALSE_STORM_HELMET.get())
                .add(ModItems.FALSE_STORM_CHESTPLATE.get())
                .add(ModItems.FALSE_STORM_LEGGINGS.get())
                .add(ModItems.FALSE_STORM_BOOTS.get());

        tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(
                        ModItems.NIGHTMARE_SWORD.get(),
                        ModItems.NIGHTMARE_PICKAXE.get(),
                        ModItems.NIGHTMARE_AXE.get(),
                        ModItems.NIGHTMARE_SHOVEL.get(),
                        ModItems.NIGHTMARE_HOE.get(),
                        ModItems.NIGHTMARE_HAMMER.get(),
                        ModItems.STORM_SWORD.get(),
                        ModItems.STORM_PICKAXE.get(),
                        ModItems.STORM_AXE.get(),
                        ModItems.STORM_SHOVEL.get(),
                        ModItems.STORM_HOE.get(),
                        ModItems.STORM_HAMMER.get(),

                        // Pure variants
                        ModItems.PURE_NIGHTMARE_SWORD.get(),
                        ModItems.PURE_NIGHTMARE_PICKAXE.get(),
                        ModItems.PURE_NIGHTMARE_AXE.get(),
                        ModItems.PURE_NIGHTMARE_SHOVEL.get(),
                        ModItems.PURE_NIGHTMARE_HOE.get(),
                        ModItems.PURE_NIGHTMARE_HAMMER.get(),
                        ModItems.PURE_STORM_SWORD.get(),
                        ModItems.PURE_STORM_PICKAXE.get(),
                        ModItems.PURE_STORM_AXE.get(),
                        ModItems.PURE_STORM_SHOVEL.get(),
                        ModItems.PURE_STORM_HOE.get(),
                        ModItems.PURE_STORM_HAMMER.get(),

                        // Armors
                        ModItems.NIGHTMARE_HELMET.get(),
                        ModItems.NIGHTMARE_CHESTPLATE.get(),
                        ModItems.NIGHTMARE_LEGGINGS.get(),
                        ModItems.NIGHTMARE_BOOTS.get(),
                        ModItems.STORM_HELMET.get(),
                        ModItems.STORM_CHESTPLATE.get(),
                        ModItems.STORM_LEGGINGS.get(),
                        ModItems.STORM_BOOTS.get()

                        /* False variants
                        ModItems.FALSE_NIGHTMARE_SWORD.get(),
                        ModItems.FALSE_NIGHTMARE_PICKAXE.get(),
                        ModItems.FALSE_NIGHTMARE_AXE.get(),
                        ModItems.FALSE_NIGHTMARE_SHOVEL.get(),
                        ModItems.FALSE_NIGHTMARE_HOE.get(),
                        ModItems.FALSE_STORM_SWORD.get(),
                        ModItems.FALSE_STORM_PICKAXE.get(),
                        ModItems.FALSE_STORM_AXE.get(),
                        ModItems.FALSE_STORM_SHOVEL.get(),
                        ModItems.FALSE_STORM_HOE.get() */
                );

        // ========= SWORDS =========
        tag(ItemTags.SWORD_ENCHANTABLE)
                .add(
                        ModItems.NIGHTMARE_SWORD.get(),
                        ModItems.STORM_SWORD.get(),
                        ModItems.PURE_NIGHTMARE_SWORD.get(),
                        ModItems.PURE_STORM_SWORD.get()
                );

        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(
                        ModItems.NIGHTMARE_SWORD.get(),
                        ModItems.STORM_SWORD.get(),
                        ModItems.PURE_NIGHTMARE_SWORD.get(),
                        ModItems.PURE_STORM_SWORD.get(),
                        ModItems.NIGHTMARE_AXE.get(),
                        ModItems.STORM_AXE.get(),
                        ModItems.PURE_NIGHTMARE_AXE.get(),
                        ModItems.PURE_STORM_AXE.get(),
                        ModItems.NIGHTMARE_HAMMER.get(),
                        ModItems.STORM_HAMMER.get(),
                        ModItems.PURE_NIGHTMARE_HAMMER.get(),
                        ModItems.PURE_STORM_HAMMER.get()
                );

        tag(ItemTags.WEAPON_ENCHANTABLE)
                .add(
                        ModItems.NIGHTMARE_SWORD.get(),
                        ModItems.STORM_SWORD.get(),
                        ModItems.PURE_NIGHTMARE_SWORD.get(),
                        ModItems.PURE_STORM_SWORD.get(),
                        ModItems.NIGHTMARE_AXE.get(),
                        ModItems.STORM_AXE.get(),
                        ModItems.PURE_NIGHTMARE_AXE.get(),
                        ModItems.PURE_STORM_AXE.get(),
                        ModItems.NIGHTMARE_HAMMER.get(),
                        ModItems.STORM_HAMMER.get(),
                        ModItems.PURE_NIGHTMARE_HAMMER.get(),
                        ModItems.PURE_STORM_HAMMER.get()
                );

        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE)
                .add(
                        ModItems.NIGHTMARE_SWORD.get(),
                        ModItems.STORM_SWORD.get(),
                        ModItems.PURE_NIGHTMARE_SWORD.get(),
                        ModItems.PURE_STORM_SWORD.get()
                );

        tag(ItemTags.MINING_ENCHANTABLE)
                .add(
                        ModItems.NIGHTMARE_PICKAXE.get(),
                        ModItems.STORM_PICKAXE.get(),
                        ModItems.PURE_NIGHTMARE_PICKAXE.get(),
                        ModItems.PURE_STORM_PICKAXE.get(),
                        ModItems.NIGHTMARE_AXE.get(),
                        ModItems.STORM_AXE.get(),
                        ModItems.PURE_NIGHTMARE_AXE.get(),
                        ModItems.PURE_STORM_AXE.get(),
                        ModItems.NIGHTMARE_SHOVEL.get(),
                        ModItems.STORM_SHOVEL.get(),
                        ModItems.PURE_NIGHTMARE_SHOVEL.get(),
                        ModItems.PURE_STORM_SHOVEL.get(),
                        ModItems.NIGHTMARE_HOE.get(),
                        ModItems.STORM_HOE.get(),
                        ModItems.PURE_NIGHTMARE_HOE.get(),
                        ModItems.PURE_STORM_HOE.get(),
                        ModItems.NIGHTMARE_HAMMER.get(),
                        ModItems.STORM_HAMMER.get(),
                        ModItems.PURE_NIGHTMARE_HAMMER.get(),
                        ModItems.PURE_STORM_HAMMER.get()
                );

        tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(
                        ModItems.NIGHTMARE_PICKAXE.get(),
                        ModItems.STORM_PICKAXE.get(),
                        ModItems.PURE_NIGHTMARE_PICKAXE.get(),
                        ModItems.PURE_STORM_PICKAXE.get(),
                        ModItems.NIGHTMARE_AXE.get(),
                        ModItems.STORM_AXE.get(),
                        ModItems.PURE_NIGHTMARE_AXE.get(),
                        ModItems.PURE_STORM_AXE.get(),
                        ModItems.NIGHTMARE_SHOVEL.get(),
                        ModItems.STORM_SHOVEL.get(),
                        ModItems.PURE_NIGHTMARE_SHOVEL.get(),
                        ModItems.PURE_STORM_SHOVEL.get(),
                        ModItems.NIGHTMARE_HOE.get(),
                        ModItems.STORM_HOE.get(),
                        ModItems.PURE_NIGHTMARE_HOE.get(),
                        ModItems.PURE_STORM_HOE.get()
                );

        // ========= SWORDS =========
        tag(ItemTags.SWORDS)
                .add(
                        ModItems.NIGHTMARE_SWORD.get(),
                        ModItems.STORM_SWORD.get(),
                        ModItems.PURE_NIGHTMARE_SWORD.get(),
                        ModItems.PURE_STORM_SWORD.get(),
                        ModItems.FALSE_NIGHTMARE_SWORD.get(),
                        ModItems.FALSE_STORM_SWORD.get()
                );

        // ========= PICKAXES =========
        tag(ItemTags.PICKAXES)
                .add(
                        ModItems.NIGHTMARE_PICKAXE.get(),
                        ModItems.STORM_PICKAXE.get(),
                        ModItems.PURE_NIGHTMARE_PICKAXE.get(),
                        ModItems.PURE_STORM_PICKAXE.get(),
                        ModItems.FALSE_NIGHTMARE_PICKAXE.get(),
                        ModItems.FALSE_STORM_PICKAXE.get()
                );

        // ========= AXES =========
        tag(ItemTags.AXES)
                .add(
                        ModItems.NIGHTMARE_AXE.get(),
                        ModItems.STORM_AXE.get(),
                        ModItems.PURE_NIGHTMARE_AXE.get(),
                        ModItems.PURE_STORM_AXE.get(),
                        ModItems.FALSE_NIGHTMARE_AXE.get(),
                        ModItems.FALSE_STORM_AXE.get()
                );

        // ========= SHOVELS =========
        tag(ItemTags.SHOVELS)
                .add(
                        ModItems.NIGHTMARE_SHOVEL.get(),
                        ModItems.STORM_SHOVEL.get(),
                        ModItems.PURE_NIGHTMARE_SHOVEL.get(),
                        ModItems.PURE_STORM_SHOVEL.get(),
                        ModItems.FALSE_NIGHTMARE_SHOVEL.get(),
                        ModItems.FALSE_STORM_SHOVEL.get()
                );

        // ========= HOES =========
        tag(ItemTags.HOES)
                .add(
                        ModItems.NIGHTMARE_HOE.get(),
                        ModItems.STORM_HOE.get(),
                        ModItems.PURE_NIGHTMARE_HOE.get(),
                        ModItems.PURE_STORM_HOE.get(),
                        ModItems.FALSE_NIGHTMARE_HOE.get(),
                        ModItems.FALSE_STORM_HOE.get()
                );

        // ========= ARMOR (EQUIPPABLE + SLOT-SPECIFIC) =========
        tag(ItemTags.EQUIPPABLE_ENCHANTABLE)
                .add(
                        ModItems.NIGHTMARE_HELMET.get(),
                        ModItems.NIGHTMARE_CHESTPLATE.get(),
                        ModItems.NIGHTMARE_LEGGINGS.get(),
                        ModItems.NIGHTMARE_BOOTS.get(),

                        ModItems.STORM_HELMET.get(),
                        ModItems.STORM_CHESTPLATE.get(),
                        ModItems.STORM_LEGGINGS.get(),
                        ModItems.STORM_BOOTS.get()

                        /*
                        ModItems.FALSE_NIGHTMARE_HELMET.get(),
                        ModItems.FALSE_NIGHTMARE_CHESTPLATE.get(),
                        ModItems.FALSE_NIGHTMARE_LEGGINGS.get(),
                        ModItems.FALSE_NIGHTMARE_BOOTS.get(),

                        ModItems.FALSE_STORM_HELMET.get(),
                        ModItems.FALSE_STORM_CHESTPLATE.get(),
                        ModItems.FALSE_STORM_LEGGINGS.get(),
                        ModItems.FALSE_STORM_BOOTS.get() */
                );

        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ModItems.NIGHTMARE_HELMET.get(),
                        ModItems.STORM_HELMET.get()
                        //ModItems.FALSE_NIGHTMARE_HELMET.get(),
                        //ModItems.FALSE_STORM_HELMET.get()
                );

        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ModItems.NIGHTMARE_CHESTPLATE.get(),
                        ModItems.STORM_CHESTPLATE.get()
                        //ModItems.FALSE_NIGHTMARE_CHESTPLATE.get(),
                        //ModItems.FALSE_STORM_CHESTPLATE.get()
                );

        tag(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(ModItems.NIGHTMARE_LEGGINGS.get(),
                        ModItems.STORM_LEGGINGS.get()
                        //ModItems.FALSE_NIGHTMARE_LEGGINGS.get(),
                        //ModItems.FALSE_STORM_LEGGINGS.get()
                );

        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ModItems.NIGHTMARE_BOOTS.get(),
                        ModItems.STORM_BOOTS.get()
                        //ModItems.FALSE_NIGHTMARE_BOOTS.get(),
                        //ModItems.FALSE_STORM_BOOTS.get()
                );

        tag(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(ModItems.NIGHTMARE_INGOT.get(),
                     ModItems.STORM_INGOT.get()
                );

        tag(ItemTags.PIGLIN_LOVED)
                .add(ModItems.GOLDEN_MELON_SLICE.get(),
                     ModBlocks.GOLDEN_MELON_BLOCK.get().asItem()
                );

        tag(ItemTags.PIGLIN_FOOD)
                .add(ModItems.GOLDEN_MELON_SLICE.get(),
                        ModBlocks.GOLDEN_MELON_BLOCK.get().asItem()
                );

        tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.NIGHTMARE_INGOT.get())
                .add(ModItems.STORM_INGOT.get())
                .add(ModItems.FALSE_NIGHTMARITE_INGOT.get())
                .add(ModItems.FALSE_STORMITE_INGOT.get());

        tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.NIGHTEN_SMITHING_TEMPLATE.get())
                .add(ModItems.STORMEN_SMITHING_TEMPLATE.get());

        tag(ItemTags.PLANKS)
                .add(ModBlocks.CORRUPTED_OAK_PLANKS.get().asItem());

        tag(ItemTags.SIGNS)
                .add(ModItems.CORRUPTED_OAK_SIGN.get());

        tag(ItemTags.HANGING_SIGNS)
                .add(ModItems.CORRUPTED_OAK_HANGING_SIGN.get());

    }
}
