package net.nbc.thetestermod.datagen;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.block.custom.CrimsonBlueBerryBushBlock;
import net.nbc.thetestermod.block.custom.NightmareLampBlock;
import net.nbc.thetestermod.block.custom.WhiteCarrotCropBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TesterMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Blocks with item form models
        blockWithItem(ModBlocks.NIGHTMARITE_BLOCK);
        blockWithItem(ModBlocks.PURE_NIGHTMARITE_BLOCK);
        blockWithItem(ModBlocks.NIGHTMARE_BLOCK);
        blockWithItem(ModBlocks.REFINED_NIGHTMARE_BLOCK);

        blockWithItem(ModBlocks.NIGHTMARITE_ORE);
        blockWithItem(ModBlocks.NIGHTMARITE_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.NIGHTMARITE_NETHER_ORE);
        blockWithItem(ModBlocks.NIGHTMARITE_END_ORE);

        blockWithItem(ModBlocks.STORMITE_ORE);
        blockWithItem(ModBlocks.STORMITE_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.STORM_NETHER_ORE);
        blockWithItem(ModBlocks.STORM_END_ORE);

        blockWithItem(ModBlocks.MAGIC_BLOCK);
        blockWithItem(ModBlocks.ANTI_MAGIC_BLOCK);

        blockWithItem(ModBlocks.MYSTERIOUS_DUST_BLOCK);

        blockWithTopBottom(ModBlocks.PURIFIER_BLOCK,
                modLoc("block/magic_block_side"),
                modLoc("block/magic_block_top"),
                modLoc("block/magic_block_bottom"));

        blockWithTopBottom(ModBlocks.IMPURIFIER_BLOCK,
                modLoc("block/anti_magic_block_side"),
                modLoc("block/anti_magic_block_top"),
                modLoc("block/anti_magic_block_bottom"));

        stairsBlock(ModBlocks.NIGHTMARE_STAIRS.get(), blockTexture(ModBlocks.NIGHTMARE_BLOCK.get()));
        slabBlock(ModBlocks.NIGHTMARE_SlAB.get(), blockTexture(ModBlocks.NIGHTMARE_BLOCK.get()), blockTexture(ModBlocks.NIGHTMARE_BLOCK.get()));

        buttonBlock(ModBlocks.NIGHTMARE_BUTTON.get(), blockTexture(ModBlocks.NIGHTMARE_BLOCK.get()));
        pressurePlateBlock(ModBlocks.NIGHTMARE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.NIGHTMARE_BLOCK.get()));

        fenceBlock(ModBlocks.NIGHTMARE_FENCE.get(), blockTexture(ModBlocks.NIGHTMARE_BLOCK.get()));
        fenceGateBlock(ModBlocks.NIGHTMARE_FENCE_GATE.get(), blockTexture(ModBlocks.NIGHTMARE_BLOCK.get()));
        wallBlock(ModBlocks.NIGHTMARE_WALL.get(), blockTexture(ModBlocks.NIGHTMARE_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.NIGHTMARE_DOOR.get(), modLoc("block/nightmare_door_bottom"), modLoc("block/nightmare_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.NIGHTMARE_TRAPDOOR.get(), modLoc("block/nightmare_trapdoor"), true, "cutout");

        blockItem(ModBlocks.NIGHTMARE_STAIRS);
        blockItem(ModBlocks.NIGHTMARE_SlAB);
        blockItem(ModBlocks.NIGHTMARE_PRESSURE_PLATE);
        blockItem(ModBlocks.NIGHTMARE_FENCE_GATE);
        blockItem(ModBlocks.NIGHTMARE_TRAPDOOR, "_bottom");

        // Refined variant of NIGHTMARE blocks
        stairsBlock(ModBlocks.REFINED_NIGHTMARE_STAIRS.get(), blockTexture(ModBlocks.REFINED_NIGHTMARE_BLOCK.get()));
        slabBlock(ModBlocks.REFINED_NIGHTMARE_SlAB.get(), blockTexture(ModBlocks.REFINED_NIGHTMARE_BLOCK.get()), blockTexture(ModBlocks.REFINED_NIGHTMARE_BLOCK.get()));

        buttonBlock(ModBlocks.REFINED_NIGHTMARE_BUTTON.get(), blockTexture(ModBlocks.REFINED_NIGHTMARE_BLOCK.get()));
        pressurePlateBlock(ModBlocks.REFINED_NIGHTMARE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.REFINED_NIGHTMARE_BLOCK.get()));

        fenceBlock(ModBlocks.REFINED_NIGHTMARE_FENCE.get(), blockTexture(ModBlocks.REFINED_NIGHTMARE_BLOCK.get()));
        fenceGateBlock(ModBlocks.REFINED_NIGHTMARE_FENCE_GATE.get(), blockTexture(ModBlocks.REFINED_NIGHTMARE_BLOCK.get()));
        wallBlock(ModBlocks.REFINED_NIGHTMARE_WALL.get(), blockTexture(ModBlocks.REFINED_NIGHTMARE_BLOCK.get()));

        blockItem(ModBlocks.REFINED_NIGHTMARE_STAIRS);
        blockItem(ModBlocks.REFINED_NIGHTMARE_SlAB);
        blockItem(ModBlocks.REFINED_NIGHTMARE_PRESSURE_PLATE);
        blockItem(ModBlocks.REFINED_NIGHTMARE_FENCE_GATE);

        blockWithItem(ModBlocks.STORM_BLOCK);

        stairsBlock(ModBlocks.STORM_STAIRS.get(), blockTexture(ModBlocks.STORM_BLOCK.get()));
        slabBlock(ModBlocks.STORM_SlAB.get(), blockTexture(ModBlocks.STORM_BLOCK.get()), blockTexture(ModBlocks.STORM_BLOCK.get()));

        buttonBlock(ModBlocks.STORM_BUTTON.get(), blockTexture(ModBlocks.STORM_BLOCK.get()));
        pressurePlateBlock(ModBlocks.STORM_PRESSURE_PLATE.get(), blockTexture(ModBlocks.STORM_BLOCK.get()));

        fenceBlock(ModBlocks.STORM_FENCE.get(), blockTexture(ModBlocks.STORM_BLOCK.get()));
        fenceGateBlock(ModBlocks.STORM_FENCE_GATE.get(), blockTexture(ModBlocks.STORM_BLOCK.get()));
        wallBlock(ModBlocks.STORM_WALL.get(), blockTexture(ModBlocks.STORM_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.STORM_DOOR.get(), modLoc("block/storm_door_bottom"), modLoc("block/storm_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.STORM_TRAPDOOR.get(), modLoc("block/storm_trapdoor"), true, "cutout");

        blockItem(ModBlocks.STORM_STAIRS);
        blockItem(ModBlocks.STORM_SlAB);
        blockItem(ModBlocks.STORM_PRESSURE_PLATE);
        blockItem(ModBlocks.STORM_FENCE_GATE);
        blockItem(ModBlocks.STORM_TRAPDOOR, "_bottom");

        customNightmareLamp();
        customStormLamp();

        makeCrop((CropBlock) ModBlocks.WHITE_CARROT_CROP.get(), "white_carrot_crop_stage", "white_carrot_crop_stage");
        makeBush((SweetBerryBushBlock) ModBlocks.CRIMSON_BLUE_BERRY_BUSH.get(), "crimson_blue_berry_bush_stage", "crimson_blue_berry_bush_stage");

        logBlock(ModBlocks.CORRUPTED_OAK_LOG.get());
        axisBlock(ModBlocks.CORRUPTED_OAK_WOOD.get(), blockTexture(ModBlocks.CORRUPTED_OAK_LOG.get()), blockTexture(ModBlocks.CORRUPTED_OAK_LOG.get()));
        logBlock(ModBlocks.STRIPPED_CORRUPTED_OAK_LOG.get());
        axisBlock(ModBlocks.STRIPPED_CORRUPTED_OAK_WOOD.get(), blockTexture(ModBlocks.STRIPPED_CORRUPTED_OAK_LOG.get()), blockTexture(ModBlocks.STRIPPED_CORRUPTED_OAK_LOG.get()));

        blockItem(ModBlocks.CORRUPTED_OAK_LOG);
        blockItem(ModBlocks.CORRUPTED_OAK_WOOD);
        blockItem(ModBlocks.STRIPPED_CORRUPTED_OAK_LOG);
        blockItem(ModBlocks.STRIPPED_CORRUPTED_OAK_WOOD);
        blockWithItem(ModBlocks.CORRUPTED_OAK_PLANKS);

        leavesBlock(ModBlocks.CORRUPTED_OAK_LEAVES);
        saplingBlock(ModBlocks.CORRUPTED_OAK_SAPLING);

        stairsBlock(ModBlocks.CORRUPTED_OAK_STAIRS.get(), blockTexture(ModBlocks.CORRUPTED_OAK_PLANKS.get()));
        slabBlock(ModBlocks.CORRUPTED_OAK_SLAB.get(), blockTexture(ModBlocks.CORRUPTED_OAK_PLANKS.get()), blockTexture(ModBlocks.CORRUPTED_OAK_PLANKS.get()));

        buttonBlock(ModBlocks.CORRUPTED_OAK_BUTTON.get(), blockTexture(ModBlocks.CORRUPTED_OAK_PLANKS.get()));
        pressurePlateBlock(ModBlocks.CORRUPTED_OAK_PRESSURE_PLATE.get(), blockTexture(ModBlocks.CORRUPTED_OAK_PLANKS.get()));

        fenceBlock(ModBlocks.CORRUPTED_OAK_FENCE.get(), blockTexture(ModBlocks.CORRUPTED_OAK_PLANKS.get()));
        fenceGateBlock(ModBlocks.CORRUPTED_OAK_FENCE_GATE.get(), blockTexture(ModBlocks.CORRUPTED_OAK_PLANKS.get()));

        doorBlockWithRenderType(ModBlocks.CORRUPTED_OAK_DOOR.get(), modLoc("block/corrupted_oak_door_bottom"), modLoc("block/corrupted_oak_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.CORRUPTED_OAK_TRAPDOOR.get(), modLoc("block/corrupted_oak_trapdoor"), true, "cutout");

        blockItem(ModBlocks.CORRUPTED_OAK_STAIRS);
        blockItem(ModBlocks.CORRUPTED_OAK_SLAB);
        blockItem(ModBlocks.CORRUPTED_OAK_PRESSURE_PLATE);
        blockItem(ModBlocks.CORRUPTED_OAK_FENCE_GATE);
        blockItem(ModBlocks.CORRUPTED_OAK_TRAPDOOR, "_bottom");

        blockWithItem(ModBlocks.INDIGO_BRICKS);

        slabBlock(ModBlocks.MYSTERIOUS_DUST_SLAB.get(), blockTexture(ModBlocks.MYSTERIOUS_DUST_BLOCK.get()), blockTexture(ModBlocks.MYSTERIOUS_DUST_BLOCK.get()));
        blockItem(ModBlocks.MYSTERIOUS_DUST_SLAB);


        stairsBlock(ModBlocks.INDIGO_BRICK_STAIRS.get(), blockTexture(ModBlocks.INDIGO_BRICKS.get()));
        slabBlock(ModBlocks.INDIGO_BRICK_SlAB.get(), blockTexture(ModBlocks.INDIGO_BRICKS.get()), blockTexture(ModBlocks.INDIGO_BRICKS.get()));

        wallBlock(ModBlocks.INDIGO_BRICK_WALL.get(), blockTexture(ModBlocks.INDIGO_BRICKS.get()));

        blockItem(ModBlocks.INDIGO_BRICK_STAIRS);
        blockItem(ModBlocks.INDIGO_BRICK_SlAB);

        blockWithItem(ModBlocks.STEELIUM_BLOCK);
        blockWithItem(ModBlocks.STEELIUM_CORE);
        blockWithItem(ModBlocks.STEELIUM_ENERGY_TUBE_VERT);
        blockWithItem(ModBlocks.STEELIUM_ENERGY_TUBE_HORI);
        blockWithItem(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BL);
        blockWithItem(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BR);
        blockWithItem(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TR);
        blockWithItem(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TL);
        blockWithItem(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_L);
        blockWithItem(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_B);
        blockWithItem(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_R);
        blockWithItem(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_T);

        blockWithItem(ModBlocks.FALSE_STORMITE_BLOCK);
        blockWithItem(ModBlocks.FALSE_NIGHTMARITE_BLOCK);

        paneBlockWithRenderType(
                ModBlocks.STEELIUM_BARS.get(),
                modLoc("block/steelium_bars"),
                modLoc("block/steelium_bars"),
                "cutout"
        );

        stairsBlock(ModBlocks.STEELIUM_STAIRS.get(), blockTexture(ModBlocks.STEELIUM_BLOCK.get()));
        slabBlock(ModBlocks.STEELIUM_SlAB.get(), blockTexture(ModBlocks.STEELIUM_BLOCK.get()), blockTexture(ModBlocks.STEELIUM_BLOCK.get()));

        buttonBlock(ModBlocks.STEELIUM_BUTTON.get(), blockTexture(ModBlocks.STEELIUM_BLOCK.get()));
        pressurePlateBlock(ModBlocks.STEELIUM_PRESSURE_PLATE.get(), blockTexture(ModBlocks.STEELIUM_BLOCK.get()));

        wallBlock(ModBlocks.STEELIUM_WALL.get(), blockTexture(ModBlocks.STEELIUM_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.STEELIUM_DOOR.get(), modLoc("block/steelium_door_bottom"), modLoc("block/steelium_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.STEELIUM_TRAPDOOR.get(), modLoc("block/steelium_trapdoor"), true, "cutout");

        blockItem(ModBlocks.STEELIUM_STAIRS);
        blockItem(ModBlocks.STEELIUM_SlAB);
        blockItem(ModBlocks.STEELIUM_PRESSURE_PLATE);
        blockItem(ModBlocks.STEELIUM_TRAPDOOR, "_bottom");

    }

    private void blockWithTopBottom(DeferredBlock<?> deferredBlock, ResourceLocation side, ResourceLocation top, ResourceLocation bottom) {
        simpleBlockWithItem(deferredBlock.get(),
                models().cubeBottomTop(
                        deferredBlock.getId().getPath(),
                        side,
                        bottom,
                        top
                )
        );
    }

    private void blockWithAllSides(DeferredBlock<?> deferredBlock,
                                   ResourceLocation north, ResourceLocation south,
                                   ResourceLocation east, ResourceLocation west,
                                   ResourceLocation up, ResourceLocation down) {
        simpleBlockWithItem(deferredBlock.get(),
                models().cube(
                        deferredBlock.getId().getPath(),
                        down, up, north, south, east, west
                )
        );
    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get()))
                        .renderType("cutout"));
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(
                                BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(),
                                ResourceLocation.parse("minecraft:block/leaves"),
                                "all",
                                blockTexture(blockRegistryObject.get()))
                        .renderType("cutout"));
    }

    public void makeBush(SweetBerryBushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(
                models().cross(
                        modelName + state.getValue(CrimsonBlueBerryBushBlock.AGE),
                        ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "block/" + textureName + state.getValue(CrimsonBlueBerryBushBlock.AGE))
                ).renderType("cutout")
        );
        return models;
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(
                models().crop(
                        modelName + state.getValue(((WhiteCarrotCropBlock) block).getAgeProperty()),
                        ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "block/" + textureName + state.getValue(((WhiteCarrotCropBlock) block).getAgeProperty()))
                ).renderType("cutout")
        );
        return models;
    }

    private void customNightmareLamp() {
        getVariantBuilder(ModBlocks.NIGHTMARE_LAMP.get()).forAllStates(state -> {
            if (state.getValue(NightmareLampBlock.CLICKED)) {
                return new ConfiguredModel[]{
                        new ConfiguredModel(
                                models().cubeAll(
                                        "nightmare_lamp_on",
                                        ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "block/nightmare_lamp_on")
                                )
                        )
                };
            } else {
                return new ConfiguredModel[]{
                        new ConfiguredModel(
                                models().cubeAll(
                                        "nightmare_lamp_off",
                                        ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "block/nightmare_lamp_off")
                                )
                        )
                };
            }
        });
        simpleBlockItem(ModBlocks.NIGHTMARE_LAMP.get(),
                models().cubeAll("nightmare_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "block/nightmare_lamp_on")));
    }

    private void customStormLamp() {
        getVariantBuilder(ModBlocks.STORM_LAMP.get()).forAllStates(state -> {
            if (state.getValue(NightmareLampBlock.CLICKED)) {
                return new ConfiguredModel[]{
                        new ConfiguredModel(
                                models().cubeAll(
                                        "storm_lamp_on",
                                        ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "block/storm_lamp_on")
                                )
                        )
                };
            } else {
                return new ConfiguredModel[]{
                        new ConfiguredModel(
                                models().cubeAll(
                                        "storm_lamp_off",
                                        ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "block/storm_lamp_off")
                                )
                        )
                };
            }
        });
        simpleBlockItem(ModBlocks.STORM_LAMP.get(),
                models().cubeAll("storm_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "block/storm_lamp_on")));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("testermod:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("testermod:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
