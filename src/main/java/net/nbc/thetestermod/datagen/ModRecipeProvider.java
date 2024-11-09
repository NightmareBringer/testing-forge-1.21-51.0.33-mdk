package net.nbc.thetestermod.datagen;

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

        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(Items.GOLD_INGOT),  // Placeholder, try using Items.AIR instead of Ingredient.EMPTY
                Ingredient.of(Items.FIRE_CHARGE),
                Ingredient.of(ModItems.PURE_NIGHTMARITE.get()),
                RecipeCategory.MISC,
                ModItems.NIGHTMARE_INGOT.get())
                .unlocks("has_pure_nightmarite", has(ModItems.PURE_NIGHTMARITE.get())) // Unlock condition
                .save(pRecipeOutput, "nightmare_ingot_from_smithing");


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
                .pattern("GGG")
                .define('#', Items.GOLD_BLOCK)
                .define('A', Items.AMETHYST_SHARD)
                .define('D', Items.DIAMOND_BLOCK)
                .define('U', ModItems.PURE_EYE.get())
                .define('G', Items.AMETHYST_BLOCK)
                .unlockedBy(getHasName(ModItems.PURE_EYE.get()), has(ModItems.PURE_EYE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NIGHTMARE_LAMP.get())
                .pattern("#t#")
                .pattern("tRt")
                .pattern("#t#")
                .define('#', ModItems.PURE_NIGHTMARITE.get())
                .define('t', ModItems.NIGHTMARE_INGOT.get())
                .define('R', Items.REDSTONE)
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STORM_LAMP.get())
                .pattern("ttt")
                .pattern("tRt")
                .pattern("ttt")
                .define('t', ModBlocks.STORM_BLOCK.get())
                .define('R', Items.REDSTONE)
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
                .pattern("  T")
                .pattern(" / ")
                .pattern("   ")
                .define('T', ModItems.DEVILS_BLADE.get())
                .define('/', ModItems.DEVILS_SNATH.get())
                .unlockedBy(getHasName(ModItems.IMPURE_STICK.get()), has(ModItems.IMPURE_STICK.get())).save(pRecipeOutput);



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

        oreSmelting(pRecipeOutput, NIGHTMARITE_SMELTABLES, RecipeCategory.MISC, ModItems.NIGHTMARITE.get(), 0.25f, 200, "nightmarite");
        oreBlasting(pRecipeOutput, NIGHTMARITE_SMELTABLES, RecipeCategory.MISC, ModItems.NIGHTMARITE.get(), 0.25f, 100, "nightmarite");

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