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
                .define('A', ModItems.NIGHTMARITE.get())
                .unlockedBy(getHasName(ModItems.NIGHTMARITE.get()), has(ModItems.NIGHTMARITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PURE_NIGHTMARITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.PURE_NIGHTMARITE.get())
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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK.get())
                .pattern("#A#")
                .pattern("DFD")
                .pattern("GGG")
                .define('#', Items.GOLD_BLOCK)
                .define('A', Items.AMETHYST_SHARD)
                .define('D', Items.DIAMOND_BLOCK)
                .define('F', Items.FIRE_CHARGE)
                .define('G', Items.AMETHYST_BLOCK)
                .unlockedBy(getHasName(ModItems.PURE_NIGHTMARITE.get()), has(ModItems.PURE_NIGHTMARITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NIGHTMARE_LAMP.get())
                .pattern("#t#")
                .pattern("tRt")
                .pattern("#t#")
                .define('#', ModItems.PURE_NIGHTMARITE.get())
                .define('t', ModItems.NIGHTMARE_INGOT.get())
                .define('R', Items.REDSTONE)
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHTMARE_SWORD.get())
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" S ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHTMARE_PICKAXE.get())
                .pattern("###")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHTMARE_SHOVEL.get())
                .pattern(" # ")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHTMARE_AXE.get())
                .pattern("## ")
                .pattern("#S ")
                .pattern(" S ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":left_nightmare_axe_craft_method");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHTMARE_AXE.get())
                .pattern(" ##")
                .pattern(" S#")
                .pattern(" S ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":right_nightmare_axe_craft_method");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHTMARE_HOE.get())
                .pattern("## ")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":left_nightmare_hoe_craft_method");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHTMARE_HOE.get())
                .pattern(" ##")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.NIGHTMARE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get()))
                .save(pRecipeOutput, TesterMod.MOD_ID + ":right_nightmare_hoe_craft_method");




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



        stairBuilder(ModBlocks.NIGHTMARE_STAIRS.get(), Ingredient.of(ModItems.NIGHTMARE_INGOT.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.NIGHTMARE_SlAB.get(), ModItems.NIGHTMARE_INGOT.get());

        buttonBuilder(ModBlocks.NIGHTMARE_BUTTON.get(), Ingredient.of(ModItems.NIGHTMARE_INGOT.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.NIGHTMARE_PRESSURE_PLATE.get(), ModItems.NIGHTMARE_INGOT.get());

        fenceBuilder(ModBlocks.NIGHTMARE_FENCE.get(), Ingredient.of(ModItems.NIGHTMARE_INGOT.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.NIGHTMARE_FENCE_GATE.get(), Ingredient.of(ModItems.NIGHTMARE_INGOT.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.NIGHTMARE_WALL.get(), ModBlocks.NIGHTMARE_BLOCK.get());

        doorBuilder(ModBlocks.NIGHTMARE_DOOR.get(), Ingredient.of(ModItems.NIGHTMARE_INGOT.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.NIGHTMARE_TRAPDOOR.get(), Ingredient.of(ModItems.NIGHTMARE_INGOT.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.NIGHTMARE_INGOT.get()), has(ModItems.NIGHTMARE_INGOT.get())).save(pRecipeOutput);

        oreSmelting(pRecipeOutput, NIGHTMARITE_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_NIGHTMARITE.get(), 0.25f, 200, "alexandrite");
        oreBlasting(pRecipeOutput, NIGHTMARITE_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_NIGHTMARITE.get(), 0.25f, 100, "alexandrite");

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