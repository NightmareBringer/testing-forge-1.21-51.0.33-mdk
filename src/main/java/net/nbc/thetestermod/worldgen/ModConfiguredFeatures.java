package net.nbc.thetestermod.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_NIGHTMARITE_ORE_KEY = registerKey("nightmarite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_NIGHTMARITE_ORE_KEY = registerKey("nightmarite_nether_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_NIGHTMARITE_ORE_KEY = registerKey("nightmarite_end_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_STORMITE_ORE_KEY = registerKey("stormite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_STORMITE_ORE_KEY = registerKey("stormite_nether_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_STORMITE_ORE_KEY = registerKey("stormite_end_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldNightmariteOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.NIGHTMARITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.NIGHTMARITE_DEEPSLATE_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_NIGHTMARITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldNightmariteOres, 9));
        register(context, NETHER_NIGHTMARITE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.NIGHTMARITE_NETHER_ORE.get().defaultBlockState(), 9));
        register(context, END_NIGHTMARITE_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.NIGHTMARITE_END_ORE.get().defaultBlockState(), 9));


        List<OreConfiguration.TargetBlockState> overworldStormiteOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.STORMITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.STORMITE_DEEPSLATE_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_STORMITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldNightmariteOres, 9));
        register(context, NETHER_STORMITE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.STORM_NETHER_ORE.get().defaultBlockState(), 9));
        register(context, END_STORMITE_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.STORM_END_ORE.get().defaultBlockState(), 9));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
