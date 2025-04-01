package net.nbc.thetestermod.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.entity.ModEntities;

import java.util.List;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_NIGHTMARITE_ORE = registerKey("add_nightmarite_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_NIGHTMARITE_ORE = registerKey("add_nightmarite_nether_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_NIGHTMARITE_ORE = registerKey("add_nightmarite_end_ore");

    public static final ResourceKey<BiomeModifier> ADD_STORMITE_ORE = registerKey("add_stormite_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_STORMITE_ORE = registerKey("add_stormite_nether_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_STORMITE_ORE = registerKey("add_stormite_end_ore");

    public static final ResourceKey<BiomeModifier> ADD_CORRUPTED_OAK_TREE = registerKey("add_corrupted_oak_tree");

    public static final ResourceKey<BiomeModifier> ADD_CRIMSON_BLUE_BERRY_BUSH_OVERWORLD = registerKey("add_crimson_blue_berry_bush_overworld");
    public static final ResourceKey<BiomeModifier> ADD_CRIMSON_BLUE_BERRY_BUSH_NETHER = registerKey("add_crimson_blue_berry_bush_nether");

    public static final ResourceKey<BiomeModifier> SPAWN_TESTER = registerKey("spawn_tester");

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

        context.register(ADD_CORRUPTED_OAK_TREE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.FOREST), biomes.getOrThrow(Biomes.DARK_FOREST),
                        biomes.getOrThrow(Biomes.TAIGA), biomes.getOrThrow(Biomes.WINDSWEPT_FOREST)),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.CORRUPTED_OAK_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_CRIMSON_BLUE_BERRY_BUSH_OVERWORLD, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.FOREST), biomes.getOrThrow(Biomes.DARK_FOREST),
                        biomes.getOrThrow(Biomes.TAIGA), biomes.getOrThrow(Biomes.WINDSWEPT_FOREST)),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.CRIMSON_BLUE_BERRY_BUSH_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_CRIMSON_BLUE_BERRY_BUSH_NETHER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.NETHER_CRIMSON_BLUE_BERRY_BUSH_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(SPAWN_TESTER, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.TAIGA), biomes.getOrThrow(Biomes.FOREST),
                        biomes.getOrThrow(Biomes.CRIMSON_FOREST), biomes.getOrThrow(Biomes.SMALL_END_ISLANDS)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.TESTER_MOB.get(), 5,1, 1)))); // Never make pWeight too high!

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, name));
    }
}
