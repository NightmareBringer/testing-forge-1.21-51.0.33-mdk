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
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.entity.ModEntities;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

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
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_NIGHTMARITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NIGHTMARITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_NETHER_NIGHTMARITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_NIGHTMARITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_END_NIGHTMARITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.END_NIGHTMARITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_STORMITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.STORMITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_NETHER_STORMITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_STORMITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_END_STORMITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.END_STORMITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_CORRUPTED_OAK_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(
                        biomes.getOrThrow(Biomes.FOREST),
                        biomes.getOrThrow(Biomes.DARK_FOREST),
                        biomes.getOrThrow(Biomes.TAIGA),
                        biomes.getOrThrow(Biomes.WINDSWEPT_FOREST)
                ),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CORRUPTED_OAK_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_CRIMSON_BLUE_BERRY_BUSH_OVERWORLD, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(
                        biomes.getOrThrow(Biomes.FOREST),
                        biomes.getOrThrow(Biomes.DARK_FOREST),
                        biomes.getOrThrow(Biomes.TAIGA),
                        biomes.getOrThrow(Biomes.WINDSWEPT_FOREST)
                ),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CRIMSON_BLUE_BERRY_BUSH_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_CRIMSON_BLUE_BERRY_BUSH_NETHER, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_CRIMSON_BLUE_BERRY_BUSH_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(SPAWN_TESTER, new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.TESTER_MOB.get(), 10, 1, 1)))); // Keep spawn weights reasonable!
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, name));
    }
}
