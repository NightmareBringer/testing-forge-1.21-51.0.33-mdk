package net.nbc.thetestermod.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_OAK_KEY = registerKey("corrupted_oak");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_CRIMSON_BLUE_BERRY_BUSH_KEY = registerKey("overworld_crimson_blue_berry_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_CRIMSON_BLUE_BERRY_BUSH_KEY = registerKey("nether_crimson_blue_berry_bush");

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

        register(context, OVERWORLD_STORMITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldStormiteOres, 9));
        register(context, NETHER_STORMITE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.STORM_NETHER_ORE.get().defaultBlockState(), 9));
        register(context, END_STORMITE_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.STORM_END_ORE.get().defaultBlockState(), 9));

        register(context, CORRUPTED_OAK_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.CORRUPTED_OAK_LOG.get()),
                new ForkingTrunkPlacer(4, 4, 3),

                BlockStateProvider.simple(ModBlocks.CORRUPTED_OAK_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(3), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

                // FOR TREE THAT DOESN'T GROW ON GRASS/DIRT
                // new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(Blocks.GRAVEL)).build());

        register(context, OVERWORLD_CRIMSON_BLUE_BERRY_BUSH_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(
                                BlockStateProvider.simple(ModBlocks.CRIMSON_BLUE_BERRY_BUSH.get()
                                        .defaultBlockState().setValue(SweetBerryBushBlock.AGE, Integer.valueOf(0)))),
                        List.of(Blocks.GRASS_BLOCK, Blocks.DIRT)
                )
        );

        register(context, NETHER_CRIMSON_BLUE_BERRY_BUSH_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(
                                BlockStateProvider.simple(ModBlocks.CRIMSON_BLUE_BERRY_BUSH.get()
                                        .defaultBlockState().setValue(SweetBerryBushBlock.AGE, Integer.valueOf(3)))),
                        List.of(Blocks.CRIMSON_NYLIUM)
                )
        );

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
