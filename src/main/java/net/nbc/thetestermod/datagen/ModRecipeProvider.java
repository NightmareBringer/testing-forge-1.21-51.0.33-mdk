package net.nbc.thetestermod.datagen;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> NIGHTMARITE_SMELTABLES = List.of(ModBlocks.NIGHTMARITE_ORE.get(), ModBlocks.NIGHTMARITE_DEEPSLATE_ORE.get());

        List<ItemLike> STORMITE_SMELTABLES = List.of(ModBlocks.STORMITE_ORE.get(), ModBlocks.STORMITE_DEEPSLATE_ORE.get());

        List<ItemLike> INDIGO_SMELTABLES = List.of(ModItems.INDIGO_DUST.get());

        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(ModItems.PURE_NIGHTMARITE.get()),  // Template (first slot) - Try using Items.AIR instead of Ingredient.EMPTY for empty slots
                Ingredient.of(Items.FIRE_CHARGE),                // Addition (second slot)
                Ingredient.of(Items.IRON_INGOT),                 // Ingot (third slot)
                RecipeCategory.MISC,                             // Recipe Class
                ModItems.NIGHTMARE_INGOT.get())                  // Result
                .unlocks("has_pure_nightmarite", has(ModItems.PURE_NIGHTMARITE.get())) // Unlock condition
                .save(pRecipeOutput, "nightmare_ingot_from_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.IMPURE_STORMITE.get()),
                        Ingredient.of(Items.BLAZE_POWDER),
                        Ingredient.of(Items.COPPER_INGOT),
                        RecipeCategory.MISC,
                        ModItems.STORM_INGOT.get())
                .unlocks("has_impure_stormite", has(ModItems.IMPURE_STORMITE.get())) // Unlock condition
                .save(pRecipeOutput, "storm_ingot_from_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.IMPURE_NIGHTMARITE.get()),  // Template (first slot) - Try using Items.AIR instead of Ingredient.EMPTY for empty slots
                        Ingredient.of(Items.FIRE_CHARGE),                // Addition (second slot)
                        Ingredient.of(Items.IRON_INGOT),                 // Ingot (third slot)
                        RecipeCategory.MISC,                             // Recipe Class
                        ModItems.FALSE_NIGHTMARITE_INGOT.get())                  // Result
                .unlocks("has_impure_nightmarite", has(ModItems.IMPURE_NIGHTMARITE.get())) // Unlock condition
                .save(pRecipeOutput, "false_nightmare_ingot_from_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.PURE_STORMITE.get()),
                        Ingredient.of(Items.BLAZE_POWDER),
                        Ingredient.of(Items.COPPER_INGOT),
                        RecipeCategory.MISC,
                        ModItems.FALSE_STORMITE_INGOT.get())
                .unlocks("has_pure_stormite", has(ModItems.PURE_STORMITE.get())) // Unlock condition
                .save(pRecipeOutput, "false_storm_ingot_from_smithing");


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHISEL.get())
                .pattern("NAS")
                .pattern(" I ")
                .pattern(" I ")
                .define('A', ModItems.MYSTERIOUS_DUST.get())
                .define('N', ModItems.NIGHTMARE_NUGGET.get())
                .define('S', ModItems.STORM_NUGGET.get())
                .define('I', ModItems.IMPURE_STICK.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NIGHTMARE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.NIGHTMARE_INGOT.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHTMARE_INGOT.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.NIGHTMARE_NUGGET.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_NUGGET.get()), has(ModItems.NIGHTMARE_NUGGET.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STORM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.STORM_INGOT.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STORM_INGOT.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.STORM_NUGGET.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IMPURE_EYE.get())
                .pattern("#F#")
                .pattern("BEB")
                .pattern("FBF")
                .define('#', Items.MAGMA_CREAM)
                .define('F', Items.FERMENTED_SPIDER_EYE)
                .define('B', Items.BLAZE_POWDER)
                .define('E', Items.ENDER_PEARL)
                .unlockedBy(getHasName(Items.ENDER_PEARL), has(Items.ENDER_PEARL)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_EYE.get())
                .pattern("#F#")
                .pattern("BEB")
                .pattern("F#F")
                .define('#', Items.DIAMOND)
                .define('F', Items.GLOWSTONE_DUST)
                .define('B', Items.AMETHYST_SHARD)
                .define('E', Items.ENDER_EYE)
                .unlockedBy(getHasName(Items.ENDER_EYE), has(Items.ENDER_EYE)).save(pRecipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.IMPURIFIER_BLOCK.get())
                .pattern("#E#")
                .pattern("SUS")
                .pattern("CLC")
                .define('#', Items.WARPED_WART_BLOCK)
                .define('E', ModItems.INDIGO_BRICK)
                .define('S', Blocks.WAXED_OXIDIZED_CUT_COPPER)
                .define('U', ModItems.IMPURE_EYE.get())
                .define('C', Items.CRYING_OBSIDIAN)
                .define('L', Items.LAPIS_BLOCK)
                .unlockedBy(getHasName(ModItems.IMPURE_EYE.get()), has(ModItems.IMPURE_EYE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PURIFIER_BLOCK.get())
                .pattern("GAG")
                .pattern("DUD")
                .pattern("GLG")
                .define('A', Items.AMETHYST_SHARD)
                .define('D', Items.DIAMOND)
                .define('U', ModItems.PURE_EYE.get())
                .define('G', Items.AMETHYST_BLOCK)
                .define('L', Items.LAPIS_BLOCK)
                .unlockedBy(getHasName(ModItems.PURE_EYE.get()), has(ModItems.PURE_EYE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NIGHTMARE_LAMP.get())
                .pattern("#t#")
                .pattern("tRt")
                .pattern("#t#")
                .define('t', Items.GLASS)
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('R', ModItems.PURE_NIGHTMARITE.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STORM_LAMP.get())
                .pattern("#t#")
                .pattern("tRt")
                .pattern("#t#")
                .define('#', Items.GLASS)
                .define('t', ModItems.STORM_INGOT.get())
                .define('R', ModItems.IMPURE_STORMITE.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHTMARE_SWORD.get())
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" S ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('S', ModItems.IMPURE_STICK.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHTMARE_PICKAXE.get())
                .pattern("###")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('S', ModItems.IMPURE_STICK.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHTMARE_SHOVEL.get())
                .pattern(" # ")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('S', ModItems.IMPURE_STICK.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHTMARE_AXE.get())
                .pattern("## ")
                .pattern("#S ")
                .pattern(" S ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('S', ModItems.IMPURE_STICK.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":left_nightmare_axe_craft_method");
        /*ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHTMARE_AXE.get())
                .pattern(" ##")
                .pattern(" S#")
                .pattern(" S ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":right_nightmare_axe_craft_method");*/

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHTMARE_HOE.get())
                .pattern("## ")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('S', ModItems.IMPURE_STICK.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":left_nightmare_hoe_craft_method");
        /*ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHTMARE_HOE.get())
                .pattern(" ##")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":right_nightmare_hoe_craft_method");*/

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHTMARE_HAMMER.get())
                .pattern("###")
                .pattern("#S#")
                .pattern(" S ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('S', ModItems.IMPURE_STICK.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHTMARE_HELMET.get())
                .pattern("###")
                .pattern("# #")
                .pattern("   ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHTMARE_CHESTPLATE.get())
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHTMARE_BOOTS.get())
                .pattern("# #")
                .pattern("# #")
                .pattern("   ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHTMARE_LEGGINGS.get())
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STORM_SWORD.get())
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" S ")
                .define('#', ModItems.STORM_INGOT.get())
                .define('S', ModItems.IMPURE_STICK.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STORM_PICKAXE.get())
                .pattern("###")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.STORM_INGOT.get())
                .define('S', ModItems.IMPURE_STICK.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STORM_SHOVEL.get())
                .pattern(" # ")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.STORM_INGOT.get())
                .define('S', ModItems.IMPURE_STICK.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STORM_AXE.get())
                .pattern("## ")
                .pattern("#S ")
                .pattern(" S ")
                .define('#', ModItems.STORM_INGOT.get())
                .define('S', ModItems.IMPURE_STICK.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":left_storm_axe_craft_method");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STORM_HOE.get())
                .pattern("## ")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.STORM_INGOT.get())
                .define('S', ModItems.IMPURE_STICK.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":left_storm_hoe_craft_method");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STORM_HAMMER.get())
                .pattern("###")
                .pattern("#S#")
                .pattern(" S ")
                .define('#', ModItems.STORM_INGOT.get())
                .define('S', ModItems.IMPURE_STICK.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STORM_HELMET.get())
                .pattern("###")
                .pattern("# #")
                .pattern("   ")
                .define('#', ModItems.STORM_INGOT.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STORM_CHESTPLATE.get())
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.STORM_INGOT.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STORM_BOOTS.get())
                .pattern("# #")
                .pattern("# #")
                .pattern("   ")
                .define('#', ModItems.STORM_INGOT.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STORM_LEGGINGS.get())
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.STORM_INGOT.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DEVILS_BLADE.get())
                .pattern("  N")
                .pattern("###")
                .pattern("N  ")
                .define('#', Items.IRON_INGOT)
                .define('N', Items.GOLD_NUGGET)
                .unlockedBy(getHasName(ModItems.IMPURE_STICK.get()), has(ModItems.IMPURE_STICK.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DEVILS_SNATH.get())
                .pattern(" LI")
                .pattern("PIP")
                .pattern("IL ")
                .define('I', ModItems.IMPURE_STICK.get())
                .define('L', Items.LIME_DYE)
                .define('P', Items.PURPLE_DYE)
                .unlockedBy(getHasName(ModItems.IMPURE_STICK.get()), has(ModItems.IMPURE_STICK.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DEVILSKNIFE.get())
                .pattern(" T ")
                .pattern(" / ")
                .pattern("   ")
                .define('T', ModItems.DEVILS_BLADE.get())
                .define('/', ModItems.DEVILS_SNATH.get())
                .unlockedBy(getHasName(ModItems.IMPURE_STICK.get()), has(ModItems.IMPURE_STICK.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHTMARE_HORSE_ARMOR.get())
                .pattern("  #")
                .pattern("###")
                .pattern("# #")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STORM_HORSE_ARMOR.get())
                .pattern("  #")
                .pattern("###")
                .pattern("# #")
                .define('#', ModItems.STORM_INGOT.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.REFINED_NIGHTMARE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.NIGHTMARE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NIGHTMARE_BLOCK.get()), has(ModBlocks.NIGHTMARE_BLOCK.get())).save(pRecipeOutput);

        /*
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHTMARE_BOW.get())
                .pattern(" TS")
                .pattern("# S")
                .pattern(" TS")
                .define('T', ModItems.IMPURE_STICK.get())
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('S', ModItems.MYSTERIOUS_STRING.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STORM_BOW.get())
                .pattern(" TS")
                .pattern("# S")
                .pattern(" TS")
                .define('T', ModItems.IMPURE_STICK.get())
                .define('#', ModItems.STORM_INGOT.get())
                .define('S', ModItems.MYSTERIOUS_STRING.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput); */

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GLISTERING_CARROT.get())
                .pattern("D#D")
                .pattern("#T#")
                .pattern("D#D")
                .define('T', ModItems.WHITE_CARROT.get())
                .define('D', ModItems.MYSTERIOUS_DUST.get())
                .define('#', ModItems.NIGHTMARE_NUGGET.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_NUGGET.get()), has(ModItems.NIGHTMARE_NUGGET.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WHITE_CARROT.get())
                .pattern("###")
                .pattern("#T#")
                .pattern("###")
                .define('T', Items.CARROT)
                .define('#', Items.SUGAR)
                .unlockedBy(getHasName(ModItems.NIGHTMARE_NUGGET.get()), has(ModItems.NIGHTMARE_NUGGET.get())).save(pRecipeOutput);

        /*
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STRANGE_STICK.get())
                .pattern(" T ")
                .pattern(" T ")
                .pattern("   ")
                .define('T', ModBlocks.CORRUPTED_OAK_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.CORRUPTED_OAK_PLANKS.get()), has(ModBlocks.CORRUPTED_OAK_PLANKS.get())).save(pRecipeOutput);
         */

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK, 4)
                .pattern("   ")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', ModBlocks.CORRUPTED_OAK_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.CORRUPTED_OAK_PLANKS.get()), has(ModBlocks.CORRUPTED_OAK_PLANKS.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":sticks_from_corrupted_oak_planks");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CORRUPTED_OAK_BOAT)
                .pattern("   ")
                .pattern("S S")
                .pattern("SSS")
                .define('S', ModBlocks.CORRUPTED_OAK_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.CORRUPTED_OAK_PLANKS.get()), has(ModBlocks.CORRUPTED_OAK_PLANKS.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CORRUPTED_OAK_CHEST_BOAT)
                .pattern("   ")
                .pattern("SCS")
                .pattern("SSS")
                .define('S', ModBlocks.CORRUPTED_OAK_PLANKS.get())
                .define('C', Blocks.CHEST)
                .unlockedBy(getHasName(ModBlocks.CORRUPTED_OAK_PLANKS.get()), has(ModBlocks.CORRUPTED_OAK_PLANKS.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":corrupted_oak_chest_boat_the_right_way");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CORRUPTED_OAK_SIGN, 6)
                .pattern("SSS")
                .pattern("SSS")
                .pattern(" L ")
                .define('S', ModBlocks.CORRUPTED_OAK_PLANKS.get())
                .define('L', ModItems.STRANGE_STICK.get())
                .unlockedBy(getHasName(ModBlocks.CORRUPTED_OAK_PLANKS.get()), has(ModBlocks.CORRUPTED_OAK_PLANKS.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CORRUPTED_OAK_HANGING_SIGN, 6)
                .pattern("L L")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModBlocks.STRIPPED_CORRUPTED_OAK_LOG.get())
                .define('L', Items.CHAIN)
                .unlockedBy(getHasName(ModBlocks.CORRUPTED_OAK_PLANKS.get()), has(ModBlocks.CORRUPTED_OAK_PLANKS.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STRANGE_STICK.get())
                .pattern(" / ")
                .pattern("/M/")
                .pattern(" / ")
                .define('/', ModItems.MYSTERIOUS_DUST.get())
                .define('M', Items.STICK)
                .unlockedBy(getHasName(ModItems.MYSTERIOUS_DUST.get()), has(ModItems.MYSTERIOUS_DUST.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.INDIGO_DUST.get(), 2)
                .pattern("DD ")
                .pattern("DD ")
                .pattern("   ")
                .define('D', ModItems.MYSTERIOUS_DUST.get())
                .unlockedBy(getHasName(ModItems.MYSTERIOUS_DUST.get()), has(ModItems.MYSTERIOUS_DUST.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MYSTERIOUS_STRING.get(), 4)
                .pattern(" / ")
                .pattern("/M/")
                .pattern(" / ")
                .define('M', ModItems.MYSTERIOUS_DUST.get())
                .define('/', Items.STRING)
                .unlockedBy(getHasName(ModItems.MYSTERIOUS_DUST.get()), has(ModItems.MYSTERIOUS_DUST.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WOVEN_INDIGO_BRICK.get())
                .pattern(" / ")
                .pattern("/M/")
                .pattern(" / ")
                .define('/', ModItems.MYSTERIOUS_STRING.get())
                .define('M', ModItems.INDIGO_BRICK.get())
                .unlockedBy(getHasName(ModItems.INDIGO_BRICK.get()), has(ModItems.INDIGO_BRICK.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":woven_indigo_brick_from_indigo_brick_item");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WOVEN_INDIGO_BRICK.get(), 4)
                .pattern("///")
                .pattern("/M/")
                .pattern("///")
                .define('/', ModItems.MYSTERIOUS_STRING.get())
                .define('M', ModBlocks.INDIGO_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.INDIGO_BRICKS.get()), has(ModBlocks.INDIGO_BRICKS.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":woven_indigo_bricks_from_indigo_brick_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.INDIGO_BRICKS.get())
                .pattern("DD ")
                .pattern("DD ")
                .pattern("   ")
                .define('D', ModItems.INDIGO_BRICK.get())
                .unlockedBy(getHasName(ModItems.INDIGO_BRICK.get()), has(ModItems.INDIGO_BRICK.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RED_GAMING_CHAIR.get())
                .pattern("#L#")
                .pattern("LPL")
                .pattern("iIi")
                .define('#', Items.RED_DYE)
                .define('L', Items.LEATHER)
                .define('P', Items.POLISHED_BLACKSTONE_STAIRS)
                .define('i', Items.IRON_INGOT)
                .define('I', Items.IRON_BARS)
                .unlockedBy(getHasName(Items.RED_DYE), has(Items.RED_DYE))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":rgc_from_full_craft");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLUE_GAMING_CHAIR.get())
                .pattern("#L#")
                .pattern("LPL")
                .pattern("iIi")
                .define('#', Items.BLUE_DYE)
                .define('L', Items.LEATHER)
                .define('P', Items.POLISHED_BLACKSTONE_STAIRS)
                .define('i', Items.IRON_INGOT)
                .define('I', Items.IRON_BARS)
                .unlockedBy(getHasName(Items.BLUE_DYE), has(Items.BLUE_DYE))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":bgc_from_full_craft");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RED_GAMING_CHAIR.get())
                .pattern(" L ")
                .pattern("LPL")
                .pattern(" L ")
                .define('L', Items.RED_DYE)
                .define('P', ModBlocks.BLUE_GAMING_CHAIR.get())
                .unlockedBy(getHasName(Items.RED_DYE), has(Items.RED_DYE))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":rgc_from_bgc");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLUE_GAMING_CHAIR.get())
                .pattern(" L ")
                .pattern("LPL")
                .pattern(" L ")
                .define('L', Items.BLUE_DYE)
                .define('P', ModBlocks.RED_GAMING_CHAIR.get())
                .unlockedBy(getHasName(Items.BLUE_DYE), has(Items.BLUE_DYE))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":bgc_from_rgc");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.THROWING_KNIFE.get())
                .pattern(" I ")
                .pattern(" / ")
                .pattern("   ")
                .define('I', Items.IRON_INGOT)
                .define('/', Items.STICK)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":throwing_knife_from_iron_ingot_and_stick");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MYSTERIOUS_DUST_BLOCK.get())
                .pattern(" I ")
                .pattern(" I ")
                .pattern("   ")
                .define('I', ModBlocks.MYSTERIOUS_DUST_SLAB.get())
                .unlockedBy(getHasName(ModItems.MYSTERIOUS_DUST.get()), has(ModItems.MYSTERIOUS_DUST.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":mysterious_dust_block_from_mysterious_slab");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PEDESTAL_BLOCK.get())
                .pattern("/M/")
                .pattern("MMM")
                .pattern("   ")
                .define('/', ModItems.STORM_INGOT.get())
                .define('M', ModBlocks.REFINED_NIGHTMARE_BLOCK.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MYSTERIOUS_DUST_BLOCK.get())
                .pattern("DD ")
                .pattern("DD ")
                .pattern("   ")
                .define('D', ModBlocks.CORRUPTED_OAK_LEAVES.get())
                .unlockedBy(getHasName(ModBlocks.CORRUPTED_OAK_LEAVES.get()), has(ModBlocks.CORRUPTED_OAK_LEAVES.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":mysterious_dust_block_from_corrupted_leaves");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STEELIUM_BARS.get(), 8)
                .pattern(" / ")
                .pattern(" / ")
                .pattern(" / ")
                .define('/', ModBlocks.STEELIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.STEELIUM_BLOCK.get()), has(ModBlocks.STEELIUM_BLOCK.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NEPTOCHROME_BARS.get(), 8)
                .pattern(" / ")
                .pattern(" / ")
                .pattern(" / ")
                .define('/', ModBlocks.NEPTOCHROME_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NEPTOCHROME_BLOCK.get()), has(ModBlocks.NEPTOCHROME_BLOCK.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STEELICHROME_PICKAXE.get())
                .pattern("SSS")
                .pattern(" / ")
                .pattern(" / ")
                .define('/', ModBlocks.NEPTOCHROME_BLOCK.get())
                .define('S', ModBlocks.STEELIUM_BLOCK.get())
                .unlockedBy(getHasName(ModItems.STEELICHROME_PICKAXE.get()), has(ModItems.STEELICHROME_PICKAXE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STEELICHROME_KEYS.get())
                .pattern("N/")
                .pattern(" S")
                .define('/', Blocks.CHAIN)
                .define('S', ModBlocks.STEELIUM_BLOCK.get())
                .define('N', ModBlocks.NEPTOCHROME_BLOCK.get())
                .unlockedBy(getHasName(ModItems.STEELICHROME_PICKAXE.get()), has(ModItems.STEELICHROME_PICKAXE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STEELIUM_VAULT_WALL.get())
                .pattern("///")
                .pattern("///")
                .pattern("///")
                .define('/', ModBlocks.STEELIUM_BLOCK.get())
                .unlockedBy(getHasName(ModItems.STEELICHROME_PICKAXE.get()), has(ModItems.STEELICHROME_PICKAXE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NEPTOCHROME_VAULT_WALL.get())
                .pattern("///")
                .pattern("///")
                .pattern("///")
                .define('/', ModBlocks.NEPTOCHROME_BLOCK.get())
                .unlockedBy(getHasName(ModItems.STEELICHROME_PICKAXE.get()), has(ModItems.STEELICHROME_PICKAXE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STEELIUM_VAULT_BLOCK.get())
                .pattern("rrr")
                .pattern("r/r")
                .pattern("rrr")
                .define('/', Blocks.IRON_BLOCK)
                .define('r', ModBlocks.STEELIUM_VAULT_WALL.get())
                .unlockedBy(getHasName(ModItems.STEELICHROME_PICKAXE.get()), has(ModItems.STEELICHROME_PICKAXE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NEPTOCHROME_VAULT_BLOCK.get())
                .pattern("rrr")
                .pattern("r/r")
                .pattern("rrr")
                .define('/', Blocks.IRON_BLOCK)
                .define('r', ModBlocks.NEPTOCHROME_VAULT_WALL.get())
                .unlockedBy(getHasName(ModItems.STEELICHROME_PICKAXE.get()), has(ModItems.STEELICHROME_PICKAXE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FALSE_STORMITE_BLOCK.get())
                .pattern("///")
                .pattern("///")
                .pattern("///")
                .define('/', ModItems.FALSE_STORMITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.FALSE_STORMITE_INGOT.get()), has(ModItems.FALSE_STORMITE_INGOT.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FALSE_NIGHTMARITE_BLOCK.get())
                .pattern("///")
                .pattern("///")
                .pattern("///")
                .define('/', ModItems.FALSE_NIGHTMARITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.FALSE_NIGHTMARITE_INGOT.get()), has(ModItems.FALSE_NIGHTMARITE_INGOT.get())).save(pRecipeOutput);

        // PURE NIGHTMARE TOOLS (same ingot, pure stick)
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_NIGHTMARE_SWORD.get())
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" S ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('S', ModItems.PURE_STICK.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_NIGHTMARE_PICKAXE.get())
                .pattern("###")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('S', ModItems.PURE_STICK.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_NIGHTMARE_SHOVEL.get())
                .pattern(" # ")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('S', ModItems.PURE_STICK.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_NIGHTMARE_AXE.get())
                .pattern("## ")
                .pattern("#S ")
                .pattern(" S ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('S', ModItems.PURE_STICK.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_NIGHTMARE_HOE.get())
                .pattern("## ")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('S', ModItems.PURE_STICK.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_NIGHTMARE_HAMMER.get())
                .pattern("###")
                .pattern("#S#")
                .pattern(" S ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('S', ModItems.PURE_STICK.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);

        // FALSE NIGHTMARE TOOLS (vanilla stick + FALSE_NIGHTMARE_INGOT)
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FALSE_NIGHTMARE_SWORD.get())
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" S ")
                .define('#', ModItems.FALSE_NIGHTMARITE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.FALSE_NIGHTMARITE_INGOT.get()), has(ModItems.FALSE_NIGHTMARITE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FALSE_NIGHTMARE_PICKAXE.get())
                .pattern("###")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.FALSE_NIGHTMARITE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.FALSE_NIGHTMARITE_INGOT.get()), has(ModItems.FALSE_NIGHTMARITE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FALSE_NIGHTMARE_SHOVEL.get())
                .pattern(" # ")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.FALSE_NIGHTMARITE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.FALSE_NIGHTMARITE_INGOT.get()), has(ModItems.FALSE_NIGHTMARITE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FALSE_NIGHTMARE_AXE.get())
                .pattern("## ")
                .pattern("#S ")
                .pattern(" S ")
                .define('#', ModItems.FALSE_NIGHTMARITE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.FALSE_NIGHTMARITE_INGOT.get()), has(ModItems.FALSE_NIGHTMARITE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FALSE_NIGHTMARE_HOE.get())
                .pattern("## ")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.FALSE_NIGHTMARITE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.FALSE_NIGHTMARITE_INGOT.get()), has(ModItems.FALSE_NIGHTMARITE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FALSE_NIGHTMARE_HELMET.get())
                .pattern("###")
                .pattern("# #")
                .pattern("   ")
                .define('#', ModItems.FALSE_NIGHTMARITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.FALSE_NIGHTMARITE_INGOT.get()), has(ModItems.FALSE_NIGHTMARITE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FALSE_NIGHTMARE_CHESTPLATE.get())
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.FALSE_NIGHTMARITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.FALSE_NIGHTMARITE_INGOT.get()), has(ModItems.FALSE_NIGHTMARITE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FALSE_NIGHTMARE_LEGGINGS.get())
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.FALSE_NIGHTMARITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.FALSE_NIGHTMARITE_INGOT.get()), has(ModItems.FALSE_NIGHTMARITE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FALSE_NIGHTMARE_BOOTS.get())
                .pattern("   ")
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.FALSE_NIGHTMARITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.FALSE_NIGHTMARITE_INGOT.get()), has(ModItems.FALSE_NIGHTMARITE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_STORM_SWORD.get())
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" S ")
                .define('#', ModItems.STORM_INGOT.get())
                .define('S', ModItems.PURE_STICK.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_STORM_PICKAXE.get())
                .pattern("###")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.STORM_INGOT.get())
                .define('S', ModItems.PURE_STICK.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_STORM_SHOVEL.get())
                .pattern(" # ")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.STORM_INGOT.get())
                .define('S', ModItems.PURE_STICK.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_STORM_AXE.get())
                .pattern("## ")
                .pattern("#S ")
                .pattern(" S ")
                .define('#', ModItems.STORM_INGOT.get())
                .define('S', ModItems.PURE_STICK.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_STORM_HOE.get())
                .pattern("## ")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.STORM_INGOT.get())
                .define('S', ModItems.PURE_STICK.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_STORM_HAMMER.get())
                .pattern("###")
                .pattern("#S#")
                .pattern(" S ")
                .define('#', ModItems.STORM_INGOT.get())
                .define('S', ModItems.PURE_STICK.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FALSE_STORM_SWORD.get())
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" S ")
                .define('#', ModItems.FALSE_STORMITE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.FALSE_STORMITE_INGOT.get()), has(ModItems.FALSE_STORMITE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FALSE_STORM_PICKAXE.get())
                .pattern("###")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.FALSE_STORMITE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.FALSE_STORMITE_INGOT.get()), has(ModItems.FALSE_STORMITE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FALSE_STORM_SHOVEL.get())
                .pattern(" # ")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.FALSE_STORMITE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.FALSE_STORMITE_INGOT.get()), has(ModItems.FALSE_STORMITE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FALSE_STORM_AXE.get())
                .pattern("## ")
                .pattern("#S ")
                .pattern(" S ")
                .define('#', ModItems.FALSE_STORMITE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.FALSE_STORMITE_INGOT.get()), has(ModItems.FALSE_STORMITE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FALSE_STORM_HOE.get())
                .pattern("## ")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.FALSE_STORMITE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.FALSE_STORMITE_INGOT.get()), has(ModItems.FALSE_STORMITE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FALSE_STORM_HELMET.get())
                .pattern("###")
                .pattern("# #")
                .pattern("   ")
                .define('#', ModItems.FALSE_STORMITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.FALSE_STORMITE_INGOT.get()), has(ModItems.FALSE_STORMITE_INGOT.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FALSE_STORM_CHESTPLATE.get())
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.FALSE_STORMITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.FALSE_STORMITE_INGOT.get()), has(ModItems.FALSE_STORMITE_INGOT.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FALSE_STORM_LEGGINGS.get())
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.FALSE_STORMITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.FALSE_STORMITE_INGOT.get()), has(ModItems.FALSE_STORMITE_INGOT.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FALSE_STORM_BOOTS.get())
                .pattern("# #")
                .pattern("# #")
                .pattern("   ")
                .define('#', ModItems.FALSE_STORMITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.FALSE_STORMITE_INGOT.get()), has(ModItems.FALSE_STORMITE_INGOT.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STEELIUM_LAMP.get())
                .pattern("MGM")
                .pattern("GCG")
                .pattern("MRM")
                .define('C', ModBlocks.STEELIUM_CORE.get())
                .define('G', Blocks.GLASS)
                .define('M', ModBlocks.STEELIUM_BLOCK.get())
                .define('R', Items.REDSTONE)
                .unlockedBy(getHasName(ModBlocks.STEELIUM_CORE.get()), has(ModBlocks.STEELIUM_CORE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NEPTOCHROME_LAMP.get())
                .pattern("MGM")
                .pattern("GCG")
                .pattern("MRM")
                .define('C', ModBlocks.NEPTOCHROME_CORE.get())
                .define('G', Blocks.GLASS)
                .define('M', ModBlocks.NEPTOCHROME_BLOCK.get())
                .define('R', Items.REDSTONE)
                .unlockedBy(getHasName(ModBlocks.NEPTOCHROME_CORE.get()), has(ModBlocks.NEPTOCHROME_CORE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GOLDEN_MELON_BLOCK.get())
                .pattern("MMM")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', ModItems.GOLDEN_MELON_SLICE.get())
                .unlockedBy(getHasName(Items.MELON_SLICE), has(Items.MELON_SLICE)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GOLDEN_MELON_SLICE.get())
                .pattern(" M ")
                .pattern("M/M")
                .pattern(" M ")
                .define('/', Items.MELON_SLICE)
                .define('M', Items.GOLD_NUGGET)
                .unlockedBy(getHasName(Items.MELON_SLICE), has(Items.MELON_SLICE)).save(pRecipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GOLDEN_MELON_SLICE.get(), 9)
                .requires(ModBlocks.GOLDEN_MELON_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.GOLDEN_MELON_BLOCK.get()), has(ModBlocks.GOLDEN_MELON_BLOCK.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":golden_melon_slice_from_golden_melon_block");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NIGHTMARE_INGOT.get(), 9)
                .requires(ModBlocks.NIGHTMARE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NIGHTMARE_BLOCK.get()), has(ModBlocks.NIGHTMARE_BLOCK.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":nightmare_ingot_from_nightmare_block");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NIGHTMARE_NUGGET.get(), 9)
                .requires(ModItems.NIGHTMARE_INGOT.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FALSE_NIGHTMARITE_INGOT.get(), 9)
                .requires(ModBlocks.FALSE_NIGHTMARITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.FALSE_NIGHTMARITE_BLOCK.get()), has(ModBlocks.FALSE_NIGHTMARITE_BLOCK.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":false_nightmare_ingot_from_false_nightmare_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STORM_INGOT.get(), 9)
                .requires(ModBlocks.STORM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.STORM_BLOCK.get()), has(ModBlocks.STORM_BLOCK.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":storm_ingot_from_storm_block");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STORM_NUGGET.get(), 9)
                .requires(ModItems.STORM_INGOT.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FALSE_STORMITE_INGOT.get(), 9)
                .requires(ModBlocks.FALSE_STORMITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.FALSE_STORMITE_BLOCK.get()), has(ModBlocks.FALSE_STORMITE_BLOCK.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":false_storm_ingot_from_false_storm_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MYSTERIOUS_DUST.get(), 1)
                .requires(ModBlocks.MYSTERIOUS_DUST_SLAB.get())
                .unlockedBy(getHasName(ModBlocks.MYSTERIOUS_DUST_SLAB.get()), has(ModBlocks.MYSTERIOUS_DUST_SLAB.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":mysterious_dust_from_dust_slab");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MYSTERIOUS_DUST.get(), 2)
                .requires(ModBlocks.MYSTERIOUS_DUST_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.MYSTERIOUS_DUST_SLAB.get()), has(ModBlocks.MYSTERIOUS_DUST_SLAB.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":mysterious_dust_from_dust_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CORRUPTED_OAK_PLANKS.get(), 4)
                .requires(ModBlocks.CORRUPTED_OAK_WOOD.get())
                .unlockedBy(getHasName(ModBlocks.CORRUPTED_OAK_LOG.get()), has(ModBlocks.CORRUPTED_OAK_LOG.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":corrupted_oak_planks_from_corrupted_wood");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CORRUPTED_OAK_PLANKS.get(), 4)
                .requires(ModBlocks.CORRUPTED_OAK_LOG.get())
                .unlockedBy(getHasName(ModBlocks.CORRUPTED_OAK_LOG.get()), has(ModBlocks.CORRUPTED_OAK_LOG.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":corrupted_oak_planks_from_corrupted_log");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CORRUPTED_OAK_PLANKS.get(), 4)
                .requires(ModBlocks.STRIPPED_CORRUPTED_OAK_WOOD.get())
                .unlockedBy(getHasName(ModBlocks.CORRUPTED_OAK_LOG.get()), has(ModBlocks.CORRUPTED_OAK_LOG.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":corrupted_oak_planks_from_stripped_corrupted_wood");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CORRUPTED_OAK_PLANKS.get(), 4)
                .requires(ModBlocks.STRIPPED_CORRUPTED_OAK_LOG.get())
                .unlockedBy(getHasName(ModBlocks.CORRUPTED_OAK_LOG.get()), has(ModBlocks.CORRUPTED_OAK_LOG.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":corrupted_oak_planks_from_stripped_corrupted_log");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CORRUPTED_OAK_CHEST_BOAT.get())
                .requires(Blocks.CHEST)
                .requires(ModItems.CORRUPTED_OAK_BOAT.get())
                .unlockedBy(getHasName(ModBlocks.CORRUPTED_OAK_PLANKS.get()), has(ModBlocks.CORRUPTED_OAK_PLANKS.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":corrupted_oak_chest_boat_the_boring_way");



        stairBuilder(ModBlocks.NIGHTMARE_STAIRS.get(), Ingredient.of(ModItems.NIGHTMARE_INGOT.get())).group("nightmare_ingot")
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.NIGHTMARE_SlAB.get(), ModItems.NIGHTMARE_INGOT.get());

        buttonBuilder(ModBlocks.NIGHTMARE_BUTTON.get(), Ingredient.of(ModItems.NIGHTMARE_INGOT.get())).group("nightmare_ingot")
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.NIGHTMARE_PRESSURE_PLATE.get(), ModItems.NIGHTMARE_INGOT.get());

        fenceBuilder(ModBlocks.NIGHTMARE_FENCE.get(), Ingredient.of(ModItems.NIGHTMARE_INGOT.get())).group("nightmare_ingot")
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.NIGHTMARE_FENCE_GATE.get(), Ingredient.of(ModItems.NIGHTMARE_INGOT.get())).group("nightmare_ingot")
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.NIGHTMARE_WALL.get(), ModBlocks.NIGHTMARE_BLOCK.get());

        doorBuilder(ModBlocks.NIGHTMARE_DOOR.get(), Ingredient.of(ModItems.NIGHTMARE_INGOT.get())).group("nightmare_ingot")
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.NIGHTMARE_TRAPDOOR.get(), Ingredient.of(ModItems.NIGHTMARE_INGOT.get())).group("nightmare_ingot")
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);


        stairBuilder(ModBlocks.REFINED_NIGHTMARE_STAIRS.get(), Ingredient.of(ModBlocks.REFINED_NIGHTMARE_BLOCK.get())).group("refined_nightmare_block")
                .unlockedBy(getHasName(ModBlocks.REFINED_NIGHTMARE_BLOCK.get()), has(ModBlocks.REFINED_NIGHTMARE_BLOCK.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.REFINED_NIGHTMARE_SlAB.get(), ModBlocks.REFINED_NIGHTMARE_BLOCK.get());

        buttonBuilder(ModBlocks.REFINED_NIGHTMARE_BUTTON.get(), Ingredient.of(ModBlocks.REFINED_NIGHTMARE_BLOCK.get())).group("refined_nightmare_block")
                .unlockedBy(getHasName(ModBlocks.REFINED_NIGHTMARE_BLOCK.get()), has(ModBlocks.REFINED_NIGHTMARE_BLOCK.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.REFINED_NIGHTMARE_PRESSURE_PLATE.get(), ModBlocks.REFINED_NIGHTMARE_BLOCK.get());

        fenceBuilder(ModBlocks.REFINED_NIGHTMARE_FENCE.get(), Ingredient.of(ModBlocks.REFINED_NIGHTMARE_BLOCK.get())).group("refined_nightmare_block")
                .unlockedBy(getHasName(ModBlocks.REFINED_NIGHTMARE_BLOCK.get()), has(ModBlocks.REFINED_NIGHTMARE_BLOCK.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.REFINED_NIGHTMARE_FENCE_GATE.get(), Ingredient.of(ModBlocks.REFINED_NIGHTMARE_BLOCK.get())).group("refined_nightmare_block")
                .unlockedBy(getHasName(ModBlocks.REFINED_NIGHTMARE_BLOCK.get()), has(ModBlocks.REFINED_NIGHTMARE_BLOCK.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.REFINED_NIGHTMARE_WALL.get(), ModBlocks.REFINED_NIGHTMARE_BLOCK.get());



        stairBuilder(ModBlocks.STORM_STAIRS.get(), Ingredient.of(ModItems.STORM_INGOT.get())).group("storm_ingot")
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STORM_SlAB.get(), ModItems.STORM_INGOT.get());

        buttonBuilder(ModBlocks.STORM_BUTTON.get(), Ingredient.of(ModItems.STORM_INGOT.get())).group("storm_ingot")
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.STORM_PRESSURE_PLATE.get(), ModItems.STORM_INGOT.get());

        fenceBuilder(ModBlocks.STORM_FENCE.get(), Ingredient.of(ModItems.STORM_INGOT.get())).group("storm_ingot")
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.STORM_FENCE_GATE.get(), Ingredient.of(ModItems.STORM_INGOT.get())).group("storm_ingot")
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STORM_WALL.get(), ModBlocks.STORM_BLOCK.get());

        doorBuilder(ModBlocks.STORM_DOOR.get(), Ingredient.of(ModItems.STORM_INGOT.get())).group("storm_ingot")
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.STORM_TRAPDOOR.get(), Ingredient.of(ModItems.STORM_INGOT.get())).group("storm_ingot")
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);



        stairBuilder(ModBlocks.CORRUPTED_OAK_STAIRS.get(), Ingredient.of(ModBlocks.CORRUPTED_OAK_PLANKS.get())).group("corrupted_oak_planks")
                .unlockedBy(getHasName(ModBlocks.CORRUPTED_OAK_PLANKS.get()), has(ModBlocks.CORRUPTED_OAK_PLANKS.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORRUPTED_OAK_SLAB.get(), ModBlocks.CORRUPTED_OAK_PLANKS.get());

        buttonBuilder(ModBlocks.CORRUPTED_OAK_BUTTON.get(), Ingredient.of(ModBlocks.CORRUPTED_OAK_PLANKS.get())).group("corrupted_oak_planks")
                .unlockedBy(getHasName(ModBlocks.CORRUPTED_OAK_PLANKS.get()), has(ModBlocks.CORRUPTED_OAK_PLANKS.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.CORRUPTED_OAK_PRESSURE_PLATE.get(), ModBlocks.CORRUPTED_OAK_PLANKS.get());

        fenceBuilder(ModBlocks.CORRUPTED_OAK_FENCE.get(), Ingredient.of(ModBlocks.CORRUPTED_OAK_PLANKS.get())).group("corrupted_oak_planks")
                .unlockedBy(getHasName(ModBlocks.CORRUPTED_OAK_PLANKS.get()), has(ModBlocks.CORRUPTED_OAK_PLANKS.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.CORRUPTED_OAK_FENCE_GATE.get(), Ingredient.of(ModBlocks.CORRUPTED_OAK_PLANKS.get())).group("corrupted_oak_planks")
                .unlockedBy(getHasName(ModBlocks.CORRUPTED_OAK_PLANKS.get()), has(ModBlocks.CORRUPTED_OAK_PLANKS.get())).save(pRecipeOutput);

        doorBuilder(ModBlocks.CORRUPTED_OAK_DOOR.get(), Ingredient.of(ModBlocks.CORRUPTED_OAK_PLANKS.get())).group("corrupted_oak_planks")
                .unlockedBy(getHasName(ModBlocks.CORRUPTED_OAK_PLANKS.get()), has(ModBlocks.CORRUPTED_OAK_PLANKS.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.CORRUPTED_OAK_TRAPDOOR.get(), Ingredient.of(ModBlocks.CORRUPTED_OAK_PLANKS.get())).group("corrupted_oak_planks")
                .unlockedBy(getHasName(ModBlocks.CORRUPTED_OAK_PLANKS.get()), has(ModBlocks.CORRUPTED_OAK_PLANKS.get())).save(pRecipeOutput);

        stairBuilder(ModBlocks.INDIGO_BRICK_STAIRS.get(), Ingredient.of(ModItems.INDIGO_BRICK.get())).group("indigo_brick")
                .unlockedBy(getHasName(ModItems.INDIGO_BRICK.get()), has(ModItems.INDIGO_BRICK.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.INDIGO_BRICK_SlAB.get(), ModItems.INDIGO_BRICK.get());
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.INDIGO_BRICK_WALL.get(), ModItems.INDIGO_BRICK.get());

        stairBuilder(ModBlocks.STEELIUM_STAIRS.get(), Ingredient.of(ModBlocks.STEELIUM_BLOCK.get())).group("steelium_block")
                .unlockedBy(getHasName(ModBlocks.STEELIUM_BLOCK.get()), has(ModBlocks.STEELIUM_BLOCK.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEELIUM_SlAB.get(), ModBlocks.STEELIUM_BLOCK.get());

        buttonBuilder(ModBlocks.STEELIUM_BUTTON.get(), Ingredient.of(ModBlocks.STEELIUM_BLOCK.get())).group("steelium_block")
                .unlockedBy(getHasName(ModBlocks.STEELIUM_BLOCK.get()), has(ModBlocks.STEELIUM_BLOCK.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.STEELIUM_PRESSURE_PLATE.get(), ModBlocks.STEELIUM_BLOCK.get());

        doorBuilder(ModBlocks.STEELIUM_DOOR.get(), Ingredient.of(ModBlocks.STEELIUM_BLOCK.get())).group("steelium_block")
                .unlockedBy(getHasName(ModBlocks.STEELIUM_BLOCK.get()), has(ModBlocks.STEELIUM_BLOCK.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.STEELIUM_TRAPDOOR.get(), Ingredient.of(ModBlocks.STEELIUM_BLOCK.get())).group("steelium_block")
                .unlockedBy(getHasName(ModBlocks.STEELIUM_BLOCK.get()), has(ModBlocks.STEELIUM_BLOCK.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEELIUM_WALL.get(), ModBlocks.STEELIUM_BLOCK.get());

        stairBuilder(ModBlocks.NEPTOCHROME_STAIRS.get(), Ingredient.of(ModBlocks.NEPTOCHROME_BLOCK.get())).group("neptochrome_block")
                .unlockedBy(getHasName(ModBlocks.NEPTOCHROME_BLOCK.get()), has(ModBlocks.NEPTOCHROME_BLOCK.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.NEPTOCHROME_SLAB.get(), ModBlocks.NEPTOCHROME_BLOCK.get());

        buttonBuilder(ModBlocks.NEPTOCHROME_BUTTON.get(), Ingredient.of(ModBlocks.NEPTOCHROME_BLOCK.get())).group("neptochrome_block")
                .unlockedBy(getHasName(ModBlocks.NEPTOCHROME_BLOCK.get()), has(ModBlocks.NEPTOCHROME_BLOCK.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.NEPTOCHROME_PRESSURE_PLATE.get(), ModBlocks.NEPTOCHROME_BLOCK.get());

        doorBuilder(ModBlocks.NEPTOCHROME_DOOR.get(), Ingredient.of(ModBlocks.NEPTOCHROME_BLOCK.get())).group("neptochrome_block")
                .unlockedBy(getHasName(ModBlocks.NEPTOCHROME_BLOCK.get()), has(ModBlocks.NEPTOCHROME_BLOCK.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.NEPTOCHROME_TRAPDOOR.get(), Ingredient.of(ModBlocks.NEPTOCHROME_BLOCK.get())).group("neptochrome_block")
                .unlockedBy(getHasName(ModBlocks.NEPTOCHROME_BLOCK.get()), has(ModBlocks.NEPTOCHROME_BLOCK.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.NEPTOCHROME_WALL.get(), ModBlocks.NEPTOCHROME_BLOCK.get());

        oreSmelting(pRecipeOutput, NIGHTMARITE_SMELTABLES, RecipeCategory.MISC, ModItems.NIGHTMARITE.get(), 0.35f, 200, "nightmarite_smelt");
        oreBlasting(pRecipeOutput, NIGHTMARITE_SMELTABLES, RecipeCategory.MISC, ModItems.NIGHTMARITE.get(), 0.70f, 100, "nightmarite_blast");

        oreSmelting(pRecipeOutput, STORMITE_SMELTABLES, RecipeCategory.MISC, ModItems.STORMITE.get(), 0.40f, 250, "stormite_smelt");
        oreBlasting(pRecipeOutput, STORMITE_SMELTABLES, RecipeCategory.MISC, ModItems.STORMITE.get(), 0.80f, 150, "stormite_blast");

        oreSmelting(pRecipeOutput, INDIGO_SMELTABLES, RecipeCategory.MISC, ModItems.INDIGO_BRICK.get(), 0.25f, 200, "indigo_brick_smelt");
        oreBlasting(pRecipeOutput, INDIGO_SMELTABLES, RecipeCategory.MISC, ModItems.INDIGO_BRICK.get(), 0.25f, 100, "indigo_brick_blast");

        trimSmithing(pRecipeOutput, ModItems.NIGHTEN_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "nighten"));
        trimSmithing(pRecipeOutput, ModItems.STORMEN_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "stormen"));

        chestBoat(Blocks.OAK_PLANKS, Items.OAK_CHEST_BOAT, "oak", pRecipeOutput);
        chestBoat(Blocks.ACACIA_PLANKS, Items.ACACIA_CHEST_BOAT, "acacia", pRecipeOutput);
        chestBoat(Blocks.BAMBOO_PLANKS, Items.BAMBOO_CHEST_RAFT, "bamboo", pRecipeOutput);
        chestBoat(Blocks.BIRCH_PLANKS, Items.BIRCH_CHEST_BOAT, "birch", pRecipeOutput);
        chestBoat(Blocks.CHERRY_PLANKS, Items.CHERRY_CHEST_BOAT, "cherry", pRecipeOutput);
        chestBoat(Blocks.DARK_OAK_PLANKS, Items.DARK_OAK_CHEST_BOAT, "dark_oak", pRecipeOutput);
        chestBoat(Blocks.JUNGLE_PLANKS, Items.JUNGLE_CHEST_BOAT, "jungle", pRecipeOutput);
        chestBoat(Blocks.MANGROVE_PLANKS, Items.MANGROVE_CHEST_BOAT, "mangrove", pRecipeOutput);
        chestBoat(Blocks.SPRUCE_PLANKS, Items.SPRUCE_CHEST_BOAT, "spruce", pRecipeOutput);

    }

    protected static void chestBoat(Block plank, Item boat, String woodName, RecipeOutput pRecipeOutput) {
        // Since there is only 1 raft type, this should be fine
        String boatType = woodName.equals("bamboo") ? "raft" : "boat";
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, boat)
                .pattern("SCS")
                .pattern("SSS")
                .define('S', plank)
                .define('C', Blocks.CHEST)
                .unlockedBy(getHasName(plank), has(plank))
                // I would do block.getName() but then the recipe output wouldn't be the same
                .save(pRecipeOutput, TesterMod.MOD_ID + ":" + woodName + "_chest_" + boatType + "_the_right_way");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, TesterMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}