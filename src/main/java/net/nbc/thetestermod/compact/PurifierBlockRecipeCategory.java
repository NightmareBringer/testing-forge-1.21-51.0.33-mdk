package net.nbc.thetestermod.compact;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.recipe.PurifierBlockRecipe;
import org.jetbrains.annotations.Nullable;

public class PurifierBlockRecipeCategory implements IRecipeCategory<PurifierBlockRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "purifier_block");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID,
            "textures/gui/purifier_block/purifier_block_gui.png");

    public static final RecipeType<PurifierBlockRecipe> PURIFIER_BLOCK_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, PurifierBlockRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public PurifierBlockRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.PURIFIER_BLOCK.get()));
    }

    @Override
    public RecipeType<PurifierBlockRecipe> getRecipeType() {
        return PURIFIER_BLOCK_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.testermod.purifier_block");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public int getWidth()
    {
        return 176;
    }

    @Override
    public int getHeight()
    {
        return 85;
    }

/*
    @Override
    public @Nullable IDrawable getBackground() {
        return background;
    }
 */

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, PurifierBlockRecipe purifierBlockRecipe, IFocusGroup iFocusGroup) {
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 54, 34).addIngredients(purifierBlockRecipe.getIngredients().get(0));

        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 104, 34).addItemStack(purifierBlockRecipe.getResultItem(null));
    }
}
