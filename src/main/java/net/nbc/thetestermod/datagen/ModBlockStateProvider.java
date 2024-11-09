package net.nbc.thetestermod.datagen;

import net.minecraft.resources.ResourceLocation;
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
import net.nbc.thetestermod.block.custom.NightmareLampBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TesterMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.NIGHTMARITE_BLOCK);
        blockWithItem(ModBlocks.PURE_NIGHTMARITE_BLOCK);
        blockWithItem(ModBlocks.NIGHTMARE_BLOCK);

        blockWithItem(ModBlocks.NIGHTMARITE_ORE);
        blockWithItem(ModBlocks.NIGHTMARITE_DEEPSLATE_ORE);

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
