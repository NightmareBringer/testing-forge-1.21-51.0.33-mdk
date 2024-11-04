package net.nbc.thetestermod.datagen;

import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.registries.ForgeRegistries;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

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
