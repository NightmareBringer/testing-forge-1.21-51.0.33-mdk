package net.nbc.thetestermod.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.nbc.thetestermod.TesterMod;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_NIGHTMARITE_ORE = registerKey("add_nightmarite_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_NIGHTMARITE_ORE = registerKey("add_nightmarite_nether_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_NIGHTMARITE_ORE = registerKey("add_nightmarite_end_ore");

    public static final ResourceKey<BiomeModifier> ADD_STORMITE_ORE = registerKey("add_stormite_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_STORMITE_ORE = registerKey("add_stormite_nether_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_STORMITE_ORE = registerKey("add_stormite_end_ore");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeature = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_NIGHTMARITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.NIGHTMARITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_NETHER_NIGHTMARITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.NETHER_NIGHTMARITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_END_NIGHTMARITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.END_NIGHTMARITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_STORMITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.STORMITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_NETHER_STORMITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.NETHER_STORMITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_END_STORMITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.END_STORMITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));



        // Individual Biomes (example)
        // context.register(ADD_ALEXANDRITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
        //         HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS), biomes.getOrThrow(Biomes.BAMBOO_JUNGLE)),
        //         HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.ALEXANDRITE_ORE_PLACED_KEY)),
        //         GenerationStep.Decoration.UNDERGROUND_ORES));

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, name));
    }
}
