package net.nbc.thetestermod.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> NIGHTMARITE_ORE_PLACED_KEY = registerKey("nightmarite_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_NIGHTMARITE_ORE_PLACED_KEY = registerKey("nightmarite_nether_ore_placed");
    public static final ResourceKey<PlacedFeature> END_NIGHTMARITE_ORE_PLACED_KEY = registerKey("nightmarite_end_ore_placed");

    public static final ResourceKey<PlacedFeature> STORMITE_ORE_PLACED_KEY = registerKey("stormite_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_STORMITE_ORE_PLACED_KEY = registerKey("stormite_nether_ore_placed");
    public static final ResourceKey<PlacedFeature> END_STORMITE_ORE_PLACED_KEY = registerKey("stormite_end_ore_placed");

    public static final ResourceKey<PlacedFeature> CORRUPTED_OAK_PLACED_KEY = registerKey("corrupted_oak_placed");

    public static final ResourceKey<PlacedFeature> CRIMSON_BLUE_BERRY_BUSH_PLACED_KEY = registerKey("crimson_blue_berry_bush_placed");
    public static final ResourceKey<PlacedFeature> NETHER_CRIMSON_BLUE_BERRY_BUSH_PLACED_KEY = registerKey("nether_crimson_blue_berry_bush_placed");


    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, NIGHTMARITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_NIGHTMARITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_NIGHTMARITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_NIGHTMARITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, END_NIGHTMARITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_NIGHTMARITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, STORMITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_STORMITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_STORMITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_STORMITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, END_STORMITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_STORMITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, CORRUPTED_OAK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CORRUPTED_OAK_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.05f, 1),
                        ModBlocks.CORRUPTED_OAK_SAPLING.get()));

        register(context, CRIMSON_BLUE_BERRY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_CRIMSON_BLUE_BERRY_BUSH_KEY),
                List.of(RarityFilter.onAverageOnceEvery(256), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

        register(context, NETHER_CRIMSON_BLUE_BERRY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_CRIMSON_BLUE_BERRY_BUSH_KEY),
                List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome()));

    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
