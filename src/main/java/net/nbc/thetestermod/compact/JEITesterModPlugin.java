package net.nbc.thetestermod.compact;

import mezz.jei.api.IModPlugin;

import mezz.jei.api.JeiPlugin;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.recipe.ImpurifierBlockRecipe;
import net.nbc.thetestermod.recipe.ModRecipes;
import net.nbc.thetestermod.recipe.PurifierBlockRecipe;
import net.nbc.thetestermod.screen.custom.ImpurifierBlockScreen;
import net.nbc.thetestermod.screen.custom.PurifierBlockScreen;

import java.util.List;

@JeiPlugin
public class JEITesterModPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new PurifierBlockRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new ImpurifierBlockRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null) return; // Prevent JEI init crash / empty list

        RecipeManager recipeManager = mc.level.getRecipeManager();

        List<PurifierBlockRecipe> purifierRecipes = recipeManager
                .getAllRecipesFor(ModRecipes.PURIFIER_BLOCK_TYPE.get())
                .stream()
                .map(RecipeHolder::value)
                .toList();
        registration.addRecipes(PurifierBlockRecipeCategory.PURIFIER_BLOCK_RECIPE_RECIPE_TYPE, purifierRecipes);

        List<ImpurifierBlockRecipe> impurifierRecipes = recipeManager
                .getAllRecipesFor(ModRecipes.IMPURIFIER_BLOCK_TYPE.get())
                .stream()
                .map(RecipeHolder::value)
                .toList();
        registration.addRecipes(ImpurifierBlockRecipeCategory.IMPURIFIER_BLOCK_RECIPE_RECIPE_TYPE, impurifierRecipes);
    }


    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(PurifierBlockScreen.class, 73, 35, 24, 16,
                PurifierBlockRecipeCategory.PURIFIER_BLOCK_RECIPE_RECIPE_TYPE);

        registration.addRecipeClickArea(ImpurifierBlockScreen.class, 73, 35, 24, 16,
                ImpurifierBlockRecipeCategory.IMPURIFIER_BLOCK_RECIPE_RECIPE_TYPE);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.PURIFIER_BLOCK.get().asItem()),
                PurifierBlockRecipeCategory.PURIFIER_BLOCK_RECIPE_RECIPE_TYPE);

        registration.addRecipeCatalyst(new ItemStack(ModBlocks.IMPURIFIER_BLOCK.get().asItem()),
                ImpurifierBlockRecipeCategory.IMPURIFIER_BLOCK_RECIPE_RECIPE_TYPE);
    }
}
