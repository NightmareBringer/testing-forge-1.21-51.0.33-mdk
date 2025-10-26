package net.nbc.thetestermod.compact;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.recipe.ImpurifierBlockRecipe;
import org.jetbrains.annotations.Nullable;

public class ImpurifierBlockRecipeCategory implements IRecipeCategory<ImpurifierBlockRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "impurifier_block");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID,
            "textures/gui/purifier_block/impurifier_block_gui_jei.png");
    public static final ResourceLocation ARROW = ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID,
            "textures/gui/arrow_progress_jei.png");

    public static final RecipeType<ImpurifierBlockRecipe> IMPURIFIER_BLOCK_RECIPE_RECIPE_TYPE =
            RecipeType.create(TesterMod.MOD_ID, "impurifier_block", ImpurifierBlockRecipe.class);

    private final IDrawable background;
    private final IDrawable arrow_overlay;
    private final IDrawable icon;

    public ImpurifierBlockRecipeCategory(IGuiHelper helper) {
        IDrawableStatic arrowStatic = helper.createDrawable(ARROW, 41, 34, 22, 16);

        this.background = helper.createDrawable(TEXTURE, 0, 0, 104, 81);
        this.arrow_overlay = helper.createAnimatedDrawable(arrowStatic, 350, IDrawableAnimated.StartDirection.LEFT, false);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.IMPURIFIER_BLOCK.get()));
    }

    @Override
    public RecipeType<ImpurifierBlockRecipe> getRecipeType() {
        return IMPURIFIER_BLOCK_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.testermod.impurifier_block");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public int getWidth()
    {
        return 104;
    }

    @Override
    public int getHeight()
    {
        return 81;
    }

    @Override
    public void draw(ImpurifierBlockRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        IRecipeCategory.super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
        background.draw(guiGraphics);
        arrow_overlay.draw(guiGraphics, 41, 34);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, ImpurifierBlockRecipe impurifierBlockRecipe, IFocusGroup iFocusGroup) {
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 21, 19).addIngredients(impurifierBlockRecipe.getIngredients().get(0));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 71, 33).addItemStack(impurifierBlockRecipe.getResultItem(null));
    }
}
