package net.nbc.thetestermod.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record PurifierBlockRecipe(Ingredient inputItem, ItemStack output) implements Recipe<PurifierBlockRecipeInput> {
    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    // read in JSON File --> turns into new GrowthChamberRecipe

    @Override
    public boolean matches(PurifierBlockRecipeInput pInput, Level pLevel) {
        if(pLevel.isClientSide()) {
            return false;
        }

        return inputItem.test(pInput.getItem(0));
    }

    @Override
    public ItemStack assemble(PurifierBlockRecipeInput pInput, HolderLookup.Provider pRegistries) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider pRegistries) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.PURIFIER_BLOCK_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.PURIFIER_BLOCK_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<PurifierBlockRecipe> {
        public static final MapCodec<PurifierBlockRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(PurifierBlockRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(PurifierBlockRecipe::output)
        ).apply(inst, PurifierBlockRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, PurifierBlockRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, PurifierBlockRecipe::inputItem,
                        ItemStack.STREAM_CODEC, PurifierBlockRecipe::output,
                        PurifierBlockRecipe::new);

        @Override
        public MapCodec<PurifierBlockRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, PurifierBlockRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
