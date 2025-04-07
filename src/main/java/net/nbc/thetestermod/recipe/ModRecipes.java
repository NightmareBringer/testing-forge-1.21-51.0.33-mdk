package net.nbc.thetestermod.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nbc.thetestermod.TesterMod;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, TesterMod.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, TesterMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<PurifierBlockRecipe>> PURIFIER_BLOCK_SERIALIZER =
            SERIALIZERS.register("purifier_block", PurifierBlockRecipe.Serializer::new);
    public static final RegistryObject<RecipeType<PurifierBlockRecipe>> PURIFIER_BLOCK_TYPE =
            TYPES.register("purifier_block", () -> new RecipeType<PurifierBlockRecipe>() {
                @Override
                public String toString() {
                    return "purifier_block";
                }
            });

    public static final RegistryObject<RecipeSerializer<ImpurifierBlockRecipe>> IMPURIFIER_BLOCK_SERIALIZER =
            SERIALIZERS.register("impurifier_block", ImpurifierBlockRecipe.Serializer::new);
    public static final RegistryObject<RecipeType<ImpurifierBlockRecipe>> IMPURIFIER_BLOCK_TYPE =
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
