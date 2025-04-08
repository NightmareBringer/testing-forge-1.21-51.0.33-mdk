package net.nbc.thetestermod.compact;

import mezz.jei.api.IModPlugin;

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
import net.nbc.thetestermod.recipe.ModRecipes;
import net.nbc.thetestermod.recipe.PurifierBlockRecipe;
import net.nbc.thetestermod.screen.custom.PurifierBlockScreen;

import java.util.List;

public class JEITutorialModPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new PurifierBlockRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<PurifierBlockRecipe> growthChamberRecipes = recipeManager
                .getAllRecipesFor(ModRecipes.PURIFIER_BLOCK_TYPE.get()).stream().map(RecipeHolder::value).toList();
        registration.addRecipes(PurifierBlockRecipeCategory.PURIFIER_BLOCK_RECIPE_RECIPE_TYPE, growthChamberRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(PurifierBlockScreen.class, 70, 30, 22, 20,
                PurifierBlockRecipeCategory.PURIFIER_BLOCK_RECIPE_RECIPE_TYPE);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.PURIFIER_BLOCK.get().asItem()),
                PurifierBlockRecipeCategory.PURIFIER_BLOCK_RECIPE_RECIPE_TYPE);
    }
}
