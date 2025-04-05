package net.nbc.thetestermod.datagen;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> NIGHTMARITE_SMELTABLES = List.of(ModItems.NIGHTMARITE.get(),
                ModBlocks.NIGHTMARITE_ORE.get(), ModBlocks.NIGHTMARITE_DEEPSLATE_ORE.get());

        List<ItemLike> STORMITE_SMELTABLES = List.of(ModItems.STORMITE.get(),
                ModBlocks.STORMITE_ORE.get(), ModBlocks.STORMITE_DEEPSLATE_ORE.get());

        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(ModItems.PURE_NIGHTMARITE.get()),  //Template (first slot)
                Ingredient.of(Items.FIRE_CHARGE), //Addition (second slot)
                Ingredient.of(Items.GOLD_INGOT),  //Ingot (third slot)
                RecipeCategory.MISC,
                ModItems.NIGHTMARE_INGOT.get()) //Result
                .unlocks("has_pure_nightmarite", has(ModItems.PURE_NIGHTMARITE.get())) // Unlock condition
                .save(pRecipeOutput, "nightmare_ingot_from_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.IMPURE_STORMITE.get()),  // Placeholder, try using Items.AIR instead of Ingredient.EMPTY <- for empty slots I think
                        Ingredient.of(Items.BLAZE_POWDER),
                        Ingredient.of(Items.COPPER_INGOT),
                        RecipeCategory.MISC,
                        ModItems.STORM_INGOT.get())
                .unlocks("has_impure_stormite", has(ModItems.IMPURE_STORMITE.get())) // Unlock condition
                .save(pRecipeOutput, "storm_ingot_from_smithing");


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHISEL.get())
                .pattern("NAS")
                .pattern(" I ")
                .pattern(" I ")
                .define('A', ModItems.MYSTERIOUS_DUST.get())
                .define('N', ModItems.NIGHTMARE_NUGGET.get())
                .define('S', ModItems.STORM_NUGGET.get())
                .define('I', ModItems.IMPURE_STICK.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NIGHTMARITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.NIGHTMARITE_ORE.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARITE.get()), has(ModItems.NIGHTMARITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PURE_NIGHTMARITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.NIGHTMARITE_DEEPSLATE_ORE.get())
                .unlockedBy(getHasName(ModItems.PURE_NIGHTMARITE.get()), has(ModItems.PURE_NIGHTMARITE.get())).save(pRecipeOutput);

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
                .define('#', Items.WITHER_SKELETON_SKULL)
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


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ANTI_MAGIC_BLOCK.get())
                .pattern("#E#")
                .pattern("SUS")
                .pattern("CLC")
                .define('#', Items.WARPED_WART_BLOCK)
                .define('E', Items.ECHO_SHARD)
                .define('S', Items.SCULK)
                .define('U', ModItems.IMPURE_EYE.get())
                .define('C', Items.CRYING_OBSIDIAN)
                .define('L', Items.LAPIS_BLOCK)
                .unlockedBy(getHasName(ModItems.IMPURE_EYE.get()), has(ModItems.IMPURE_EYE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK.get())
                .pattern("#A#")
                .pattern("DUD")
                .pattern("GLG")
                .define('D', Items.GOLD_BLOCK)
                .define('A', Items.AMETHYST_SHARD)
                .define('#', Items.DIAMOND_BLOCK)
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
                .define('t', Items.GLASS)
                .define('#', ModItems.STORM_INGOT.get())
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
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);

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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STRANGE_STICK.get())
                .pattern("///")
                .pattern("/M/")
                .pattern("///")
                .define('/', ModItems.MYSTERIOUS_DUST.get())
                .define('M', Items.STICK)
                .unlockedBy(getHasName(ModItems.MYSTERIOUS_DUST.get()), has(ModItems.MYSTERIOUS_DUST.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MYSTERIOUS_STRING.get())
                .pattern(" / ")
                .pattern("/M/")
                .pattern(" / ")
                .define('/', ModItems.MYSTERIOUS_DUST.get())
                .define('M', Items.STRING)
                .unlockedBy(getHasName(ModItems.MYSTERIOUS_DUST.get()), has(ModItems.MYSTERIOUS_DUST.get())).save(pRecipeOutput);

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



        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PURE_NIGHTMARITE.get(), 9)
                .requires(ModBlocks.PURE_NIGHTMARITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.PURE_NIGHTMARITE_BLOCK.get()), has(ModBlocks.PURE_NIGHTMARITE_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NIGHTMARITE.get(), 9)
                .requires(ModBlocks.NIGHTMARITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NIGHTMARITE_BLOCK.get()), has(ModBlocks.NIGHTMARITE_BLOCK.get())).save(pRecipeOutput);
                //.save(pRecipeOutput, TesterMod.MOD_ID + ":nightmarite_from_nightmarite_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NIGHTMARE_INGOT.get(), 9)
                .requires(ModBlocks.NIGHTMARE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NIGHTMARE_BLOCK.get()), has(ModBlocks.NIGHTMARE_BLOCK.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":nightmare_ingot_from_nightmare_block");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NIGHTMARE_NUGGET.get(), 9)
                .requires(ModItems.NIGHTMARE_INGOT.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STORM_INGOT.get(), 9)
                .requires(ModBlocks.STORM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.STORM_BLOCK.get()), has(ModBlocks.STORM_BLOCK.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":storm_ingot_from_storm_block");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STORM_NUGGET.get(), 9)
                .requires(ModItems.STORM_INGOT.get())
                .unlockedBy(getHasName(ModItems.STORM_INGOT.get()), has(ModItems.STORM_INGOT.get())).save(pRecipeOutput);

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
                .requires(ModBlocks.CORRUPTED_OAK_LOG.get())
                .requires(ModBlocks.STRIPPED_CORRUPTED_OAK_WOOD.get())
                .requires(ModBlocks.STRIPPED_CORRUPTED_OAK_LOG.get())
                .unlockedBy(getHasName(ModBlocks.CORRUPTED_OAK_LOG.get()), has(ModBlocks.CORRUPTED_OAK_LOG.get())).save(pRecipeOutput);



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

        oreSmelting(pRecipeOutput, NIGHTMARITE_SMELTABLES, RecipeCategory.MISC, ModItems.NIGHTMARITE.get(), 0.25f, 200, "nightmarite");
        oreBlasting(pRecipeOutput, NIGHTMARITE_SMELTABLES, RecipeCategory.MISC, ModItems.NIGHTMARITE.get(), 0.50f, 100, "nightmarite");

        oreSmelting(pRecipeOutput, STORMITE_SMELTABLES, RecipeCategory.MISC, ModItems.STORMITE.get(), 0.20f, 250, "stormite");
        oreBlasting(pRecipeOutput, STORMITE_SMELTABLES, RecipeCategory.MISC, ModItems.STORMITE.get(), 0.40f, 150, "stormite");

        trimSmithing(pRecipeOutput, ModItems.NIGHTEN_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "nighten"));
        trimSmithing(pRecipeOutput, ModItems.STORMEN_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "stormen"));

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