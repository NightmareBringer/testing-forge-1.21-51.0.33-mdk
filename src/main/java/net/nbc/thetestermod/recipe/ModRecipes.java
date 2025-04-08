package net.nbc.thetestermod.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.nbc.thetestermod.TesterMod;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, TesterMod.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, TesterMod.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<PurifierBlockRecipe>> PURIFIER_BLOCK_SERIALIZER =
            SERIALIZERS.register("purifier_block", PurifierBlockRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<PurifierBlockRecipe>> PURIFIER_BLOCK_TYPE =
            TYPES.register("purifier_block", () -> new RecipeType<PurifierBlockRecipe>() {
                @Override
                public String toString() {
                    return "purifier_block";
                }
            });

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ImpurifierBlockRecipe>> IMPURIFIER_BLOCK_SERIALIZER =
            SERIALIZERS.register("impurifier_block", ImpurifierBlockRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<ImpurifierBlockRecipe>> IMPURIFIER_BLOCK_TYPE =
            TYPES.register("impurifier_block", () -> new RecipeType<ImpurifierBlockRecipe>() {
                @Override
                public String toString() {
                    return "impurifier_block";
                }
            });

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
