package net.nbc.thetestermod.datagen;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.registries.ForgeRegistries;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.nbc.thetestermod.block.custom.CrimsonBlueBerryBushBlock;
import net.nbc.thetestermod.block.custom.NightmareLampBlock;
import net.nbc.thetestermod.block.custom.WhiteCarrotCropBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TesterMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
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

        // Refined Variant of NIGHTMARE BLOCKS
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

        makeCrop(((CropBlock) ModBlocks.WHITE_CARROT_CROP.get()), "white_carrot_crop_stage", "white_carrot_crop_stage");
        makeBush(((SweetBerryBushBlock) ModBlocks.CRIMSON_BLUE_BERRY_BUSH.get()), "crimson_blue_berry_bush_stage", "crimson_blue_berry_bush_stage");


    }

    public void makeBush(SweetBerryBushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(CrimsonBlueBerryBushBlock.AGE),
                ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "block/" + textureName + state.getValue(CrimsonBlueBerryBushBlock.AGE))).renderType("cutout"));

        return models;
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((WhiteCarrotCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "block/" + textureName + state.getValue(((WhiteCarrotCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void customNightmareLamp() {
        getVariantBuilder(ModBlocks.NIGHTMARE_LAMP.get()).forAllStates(state -> {
            if(state.getValue(NightmareLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("nightmare_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "block/" + "nightmare_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("nightmare_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "block/" + "nightmare_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.NIGHTMARE_LAMP.get(), models().cubeAll("nightmare_lamp_on",
                ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "block/" + "nightmare_lamp_on")));
    }
    private void customStormLamp() {
        getVariantBuilder(ModBlocks.STORM_LAMP.get()).forAllStates(state -> {
            if(state.getValue(NightmareLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("storm_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "block/" + "storm_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("storm_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "block/" + "storm_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.STORM_LAMP.get(), models().cubeAll("storm_lamp_on",
                ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "block/" + "storm_lamp_on")));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("testermod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("testermod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}
