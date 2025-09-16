package net.nbc.thetestermod.datagen;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.nbc.thetestermod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TesterMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.CORRUPTED_OAK_PLANKS.get())
                .add(ModBlocks.CORRUPTED_OAK_STAIRS.get())
                .add(ModBlocks.CORRUPTED_OAK_SLAB.get())
                .add(ModBlocks.CORRUPTED_OAK_PRESSURE_PLATE.get())
                .add(ModBlocks.CORRUPTED_OAK_BUTTON.get())
                .add(ModBlocks.CORRUPTED_OAK_DOOR.get())
                .add(ModBlocks.CORRUPTED_OAK_TRAPDOOR.get())
                .add(ModBlocks.CORRUPTED_OAK_FENCE.get())
                .add(ModBlocks.CORRUPTED_OAK_FENCE_GATE.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Blocks.REINFORCED_DEEPSLATE)
                .add(ModBlocks.NIGHTMARITE_BLOCK.get())
                .add(ModBlocks.PURE_NIGHTMARITE_BLOCK.get())
                .add(ModBlocks.NIGHTMARE_BLOCK.get())
                .add(ModBlocks.NIGHTMARITE_ORE.get())
                .add(ModBlocks.NIGHTMARITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.NIGHTMARITE_END_ORE.get())
                .add(ModBlocks.NIGHTMARITE_NETHER_ORE.get())
                .add(ModBlocks.STORMITE_ORE.get())
                .add(ModBlocks.STORMITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.STORM_END_ORE.get())
                .add(ModBlocks.STORM_NETHER_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.ANTI_MAGIC_BLOCK.get())
                .add(ModBlocks.PURIFIER_BLOCK.get())
                .add(ModBlocks.IMPURIFIER_BLOCK.get())
                .add(ModBlocks.PEDESTAL_BLOCK.get())

                .add(ModBlocks.NIGHTMARE_STAIRS.get())
                .add(ModBlocks.NIGHTMARE_SlAB.get())
                .add(ModBlocks.NIGHTMARE_WALL.get())
                .add(ModBlocks.NIGHTMARE_FENCE.get())
                .add(ModBlocks.NIGHTMARE_FENCE_GATE.get())
                .add(ModBlocks.NIGHTMARE_DOOR.get())
                .add(ModBlocks.NIGHTMARE_TRAPDOOR.get())
                .add(ModBlocks.NIGHTMARE_BUTTON.get())
                .add(ModBlocks.NIGHTMARE_PRESSURE_PLATE.get())

                .add(ModBlocks.REFINED_NIGHTMARE_STAIRS.get())
                .add(ModBlocks.REFINED_NIGHTMARE_SlAB.get())
                .add(ModBlocks.REFINED_NIGHTMARE_WALL.get())
                .add(ModBlocks.REFINED_NIGHTMARE_FENCE.get())
                .add(ModBlocks.REFINED_NIGHTMARE_FENCE_GATE.get())
                .add(ModBlocks.REFINED_NIGHTMARE_BUTTON.get())
                .add(ModBlocks.REFINED_NIGHTMARE_PRESSURE_PLATE.get())

                .add(ModBlocks.NIGHTMARE_LAMP.get())

                .add(ModBlocks.STORM_BLOCK.get())
                .add(ModBlocks.STORM_STAIRS.get())
                .add(ModBlocks.STORM_SlAB.get())
                .add(ModBlocks.STORM_WALL.get())
                .add(ModBlocks.STORM_FENCE.get())
                .add(ModBlocks.STORM_FENCE_GATE.get())
                .add(ModBlocks.STORM_DOOR.get())
                .add(ModBlocks.STORM_TRAPDOOR.get())
                .add(ModBlocks.STORM_BUTTON.get())
                .add(ModBlocks.STORM_PRESSURE_PLATE.get())
                .add(ModBlocks.STORM_LAMP.get())

                .add(ModBlocks.INDIGO_BRICKS.get())
                .add(ModBlocks.INDIGO_BRICK_WALL.get())
                .add(ModBlocks.INDIGO_BRICK_SlAB.get())
                .add(ModBlocks.INDIGO_BRICK_STAIRS.get())

                .add(ModBlocks.STEELIUM_BLOCK.get())
                .add(ModBlocks.STEELIUM_BARS.get())
                .add(ModBlocks.STEELIUM_STAIRS.get())
                .add(ModBlocks.STEELIUM_SlAB.get())
                .add(ModBlocks.STEELIUM_WALL.get())
                .add(ModBlocks.STEELIUM_DOOR.get())
                .add(ModBlocks.STEELIUM_TRAPDOOR.get())
                .add(ModBlocks.STEELIUM_BUTTON.get())
                .add(ModBlocks.STEELIUM_PRESSURE_PLATE.get())
                .add(ModBlocks.STEELIUM_CONSOLE.get())
                .add(ModBlocks.STEELIUM_CORE.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_VERT.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_HORI.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BL.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BR.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TR.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TL.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_L.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_B.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_R.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_T.get())

                .add(ModBlocks.FALSE_NIGHTMARITE_BLOCK.get())
                .add(ModBlocks.FALSE_STORMITE_BLOCK.get())

                .add(ModBlocks.REFINED_NIGHTMARE_BLOCK.get());

        tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .add(ModBlocks.STEELIUM_BLOCK.get())
                .add(ModBlocks.STEELIUM_BARS.get())
                .add(ModBlocks.STEELIUM_STAIRS.get())
                .add(ModBlocks.STEELIUM_SlAB.get())
                .add(ModBlocks.STEELIUM_WALL.get())
                .add(ModBlocks.STEELIUM_DOOR.get())
                .add(ModBlocks.STEELIUM_TRAPDOOR.get())
                .add(ModBlocks.STEELIUM_BUTTON.get())
                .add(ModBlocks.STEELIUM_PRESSURE_PLATE.get())
                .add(ModBlocks.STEELIUM_CONSOLE.get())
                .add(ModBlocks.STEELIUM_CORE.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BL.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BR.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TR.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TL.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_L.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_B.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_R.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_T.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_VERT.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_HORI.get())
                .add(ModBlocks.NIGHTMARITE_ORE.get())
                .add(ModBlocks.NIGHTMARITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.NIGHTMARITE_END_ORE.get())
                .add(ModBlocks.NIGHTMARITE_NETHER_ORE.get())

                .add(ModBlocks.STORMITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.STORMITE_ORE.get())
                .add(ModBlocks.STORM_END_ORE.get())
                .add(ModBlocks.STORM_NETHER_ORE.get());

        tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .add(ModBlocks.STEELIUM_BLOCK.get())
                .add(ModBlocks.STEELIUM_BARS.get())
                .add(ModBlocks.STEELIUM_STAIRS.get())
                .add(ModBlocks.STEELIUM_SlAB.get())
                .add(ModBlocks.STEELIUM_WALL.get())
                .add(ModBlocks.STEELIUM_DOOR.get())
                .add(ModBlocks.STEELIUM_TRAPDOOR.get())
                .add(ModBlocks.STEELIUM_BUTTON.get())
                .add(ModBlocks.STEELIUM_PRESSURE_PLATE.get())
                .add(ModBlocks.STEELIUM_CONSOLE.get())
                .add(ModBlocks.STEELIUM_CORE.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BL.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BR.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TR.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TL.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_L.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_B.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_R.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_T.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_VERT.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_HORI.get())
                .add(ModBlocks.NIGHTMARITE_ORE.get())
                .add(ModBlocks.NIGHTMARITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.NIGHTMARITE_END_ORE.get())
                .add(ModBlocks.NIGHTMARITE_NETHER_ORE.get())

                .add(ModBlocks.STORMITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.STORMITE_ORE.get())
                .add(ModBlocks.STORM_END_ORE.get())
                .add(ModBlocks.STORM_NETHER_ORE.get());

        tag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .add(ModBlocks.STEELIUM_BLOCK.get())
                .add(ModBlocks.STEELIUM_BARS.get())
                .add(ModBlocks.STEELIUM_STAIRS.get())
                .add(ModBlocks.STEELIUM_SlAB.get())
                .add(ModBlocks.STEELIUM_WALL.get())
                .add(ModBlocks.STEELIUM_DOOR.get())
                .add(ModBlocks.STEELIUM_TRAPDOOR.get())
                .add(ModBlocks.STEELIUM_BUTTON.get())
                .add(ModBlocks.STEELIUM_PRESSURE_PLATE.get())
                .add(ModBlocks.STEELIUM_CONSOLE.get())
                .add(ModBlocks.STEELIUM_CORE.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BL.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BR.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TR.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TL.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_L.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_B.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_R.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_T.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_VERT.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_HORI.get())
                .add(ModBlocks.NIGHTMARITE_ORE.get())
                .add(ModBlocks.NIGHTMARITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.NIGHTMARITE_END_ORE.get())
                .add(ModBlocks.NIGHTMARITE_NETHER_ORE.get())

                .add(ModBlocks.STORMITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.STORMITE_ORE.get())
                .add(ModBlocks.STORM_END_ORE.get())
                .add(ModBlocks.STORM_NETHER_ORE.get());

        tag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .add(ModBlocks.STEELIUM_BLOCK.get())
                .add(ModBlocks.STEELIUM_BARS.get())
                .add(ModBlocks.STEELIUM_STAIRS.get())
                .add(ModBlocks.STEELIUM_SlAB.get())
                .add(ModBlocks.STEELIUM_WALL.get())
                .add(ModBlocks.STEELIUM_DOOR.get())
                .add(ModBlocks.STEELIUM_TRAPDOOR.get())
                .add(ModBlocks.STEELIUM_BUTTON.get())
                .add(ModBlocks.STEELIUM_PRESSURE_PLATE.get())
                .add(ModBlocks.STEELIUM_CONSOLE.get())
                .add(ModBlocks.STEELIUM_CORE.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BL.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BR.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TR.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TL.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_L.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_B.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_R.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_T.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_VERT.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_HORI.get())
                .add(ModBlocks.NIGHTMARITE_ORE.get())
                .add(ModBlocks.NIGHTMARITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.NIGHTMARITE_END_ORE.get())
                .add(ModBlocks.NIGHTMARITE_NETHER_ORE.get())

                .add(ModBlocks.STORMITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.STORMITE_ORE.get())
                .add(ModBlocks.STORM_END_ORE.get())
                .add(ModBlocks.STORM_NETHER_ORE.get());

        tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .add(ModBlocks.STEELIUM_BLOCK.get())
                .add(ModBlocks.STEELIUM_BARS.get())
                .add(ModBlocks.STEELIUM_STAIRS.get())
                .add(ModBlocks.STEELIUM_SlAB.get())
                .add(ModBlocks.STEELIUM_WALL.get())
                .add(ModBlocks.STEELIUM_DOOR.get())
                .add(ModBlocks.STEELIUM_TRAPDOOR.get())
                .add(ModBlocks.STEELIUM_BUTTON.get())
                .add(ModBlocks.STEELIUM_PRESSURE_PLATE.get())
                .add(ModBlocks.STEELIUM_CONSOLE.get())
                .add(ModBlocks.STEELIUM_CORE.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BL.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BR.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TR.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TL.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_L.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_B.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_R.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_T.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_VERT.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_HORI.get())
                .add(ModBlocks.STORMITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.STORMITE_ORE.get())
                .add(ModBlocks.STORM_END_ORE.get())
                .add(ModBlocks.STORM_NETHER_ORE.get());

        tag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .add(ModBlocks.STORMITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.STORMITE_ORE.get())
                .add(ModBlocks.STORM_END_ORE.get())
                .add(ModBlocks.STORM_NETHER_ORE.get())
                .add(ModBlocks.STEELIUM_BLOCK.get())
                .add(ModBlocks.STEELIUM_BARS.get())
                .add(ModBlocks.STEELIUM_STAIRS.get())
                .add(ModBlocks.STEELIUM_SlAB.get())
                .add(ModBlocks.STEELIUM_WALL.get())
                .add(ModBlocks.STEELIUM_DOOR.get())
                .add(ModBlocks.STEELIUM_TRAPDOOR.get())
                .add(ModBlocks.STEELIUM_BUTTON.get())
                .add(ModBlocks.STEELIUM_PRESSURE_PLATE.get())
                .add(ModBlocks.STEELIUM_CONSOLE.get())
                .add(ModBlocks.STEELIUM_CORE.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BL.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BR.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TR.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TL.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_L.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_B.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_R.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_T.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_VERT.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_HORI.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.MAGIC_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.NIGHTMARE_BLOCK.get())
                .add(ModBlocks.NIGHTMARITE_BLOCK.get())
                .add(ModBlocks.PURE_NIGHTMARITE_BLOCK.get())
                .add(ModBlocks.NIGHTMARE_STAIRS.get())
                .add(ModBlocks.NIGHTMARE_SlAB.get())
                .add(ModBlocks.NIGHTMARE_WALL.get())
                .add(ModBlocks.NIGHTMARE_FENCE.get())
                .add(ModBlocks.NIGHTMARE_FENCE_GATE.get())
                .add(ModBlocks.NIGHTMARE_DOOR.get())
                .add(ModBlocks.NIGHTMARE_TRAPDOOR.get())
                .add(ModBlocks.NIGHTMARE_BUTTON.get())
                .add(ModBlocks.NIGHTMARE_PRESSURE_PLATE.get())
                .add(ModBlocks.NIGHTMARE_LAMP.get())
                .add(ModBlocks.REFINED_NIGHTMARE_STAIRS.get())
                .add(ModBlocks.REFINED_NIGHTMARE_SlAB.get())
                .add(ModBlocks.REFINED_NIGHTMARE_WALL.get())
                .add(ModBlocks.REFINED_NIGHTMARE_FENCE.get())
                .add(ModBlocks.REFINED_NIGHTMARE_FENCE_GATE.get())
                .add(ModBlocks.REFINED_NIGHTMARE_BUTTON.get())
                .add(ModBlocks.REFINED_NIGHTMARE_PRESSURE_PLATE.get())
                .add(ModBlocks.ANTI_MAGIC_BLOCK.get())
                .add(ModBlocks.STORM_BLOCK.get())
                .add(ModBlocks.STORM_STAIRS.get())
                .add(ModBlocks.STORM_SlAB.get())
                .add(ModBlocks.STORM_WALL.get())
                .add(ModBlocks.STORM_FENCE.get())
                .add(ModBlocks.STORM_FENCE_GATE.get())
                .add(ModBlocks.STORM_DOOR.get())
                .add(ModBlocks.STORM_TRAPDOOR.get())
                .add(ModBlocks.STORM_BUTTON.get())
                .add(ModBlocks.STORM_PRESSURE_PLATE.get())
                .add(ModBlocks.STORM_LAMP.get())
                .add(ModBlocks.REFINED_NIGHTMARE_BLOCK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NIGHTMARITE_ORE.get())
                .add(ModBlocks.NIGHTMARITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.NIGHTMARITE_END_ORE.get())
                .add(ModBlocks.NIGHTMARITE_NETHER_ORE.get());

        // FALSE NIGHTMARE behaves like iron
        tag(ModTags.Blocks.NEEDS_FALSE_NIGHTMARE_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_FALSE_NIGHTMARE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);

        // Same for FALSE STORM
        tag(ModTags.Blocks.NEEDS_FALSE_STORM_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_FALSE_STORM_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);

        // NIGHTMARE tool can only break stormite ores
        tag(ModTags.Blocks.NEEDS_NIGHTMARE_TOOL)
                .add(ModBlocks.STORMITE_ORE.get())
                .add(ModBlocks.STORMITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.STORM_END_ORE.get())
                .add(ModBlocks.STORM_NETHER_ORE.get());

// Everything else should be incorrect for NIGHTMARE_TOOL
        tag(ModTags.Blocks.INCORRECT_FOR_NIGHTMARE_TOOL)
                .add(ModBlocks.STORM_WALL.get());

        tag(ModTags.Blocks.NEEDS_STORM_TOOL)
                .add(ModBlocks.STORM_WALL.get())
                .add(Blocks.REINFORCED_DEEPSLATE)
                .add(ModBlocks.STEELIUM_BLOCK.get())
                .add(ModBlocks.STEELIUM_BARS.get())
                .add(ModBlocks.STEELIUM_STAIRS.get())
                .add(ModBlocks.STEELIUM_SlAB.get())
                .add(ModBlocks.STEELIUM_WALL.get())
                .add(ModBlocks.STEELIUM_DOOR.get())
                .add(ModBlocks.STEELIUM_TRAPDOOR.get())
                .add(ModBlocks.STEELIUM_BUTTON.get())
                .add(ModBlocks.STEELIUM_PRESSURE_PLATE.get())
                .add(ModBlocks.STEELIUM_CONSOLE.get())
                .add(ModBlocks.STEELIUM_CORE.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BL.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BR.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TR.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TL.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_L.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_B.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_R.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_T.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_VERT.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_HORI.get());

        tag(ModTags.Blocks.INCORRECT_FOR_STORM_TOOL)
                //.addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
                .add(Blocks.BEDROCK);

        tag(ModTags.Blocks.NEEDS_PURE_NIGHTMARE_TOOL)
                .add(ModBlocks.STEELIUM_BLOCK.get())
                .add(ModBlocks.STEELIUM_BARS.get())
                .add(ModBlocks.STEELIUM_STAIRS.get())
                .add(ModBlocks.STEELIUM_SlAB.get())
                .add(ModBlocks.STEELIUM_WALL.get())
                .add(ModBlocks.STEELIUM_DOOR.get())
                .add(ModBlocks.STEELIUM_TRAPDOOR.get())
                .add(ModBlocks.STEELIUM_BUTTON.get())
                .add(ModBlocks.STEELIUM_PRESSURE_PLATE.get())
                .add(ModBlocks.STEELIUM_CONSOLE.get())
                .add(ModBlocks.STEELIUM_CORE.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BL.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BR.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TR.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TL.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_L.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_B.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_R.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_T.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_VERT.get())
                .add(ModBlocks.STEELIUM_ENERGY_TUBE_HORI.get());

        tag(ModTags.Blocks.NEEDS_DEVILSKNIFE_TOOL)
                .addTag(BlockTags.NEEDS_STONE_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_DEVILSKNIFE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);

        tag(BlockTags.LEAVES)
                .add(ModBlocks.CORRUPTED_OAK_LEAVES.get());

        tag(BlockTags.FENCES).add(ModBlocks.NIGHTMARE_FENCE.get());
        tag(BlockTags.FENCES).add(ModBlocks.REFINED_NIGHTMARE_FENCE.get());
        tag(BlockTags.FENCES).add(ModBlocks.STORM_FENCE.get());
        tag(BlockTags.FENCES).add(ModBlocks.CORRUPTED_OAK_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.NIGHTMARE_FENCE_GATE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.REFINED_NIGHTMARE_FENCE_GATE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.STORM_FENCE_GATE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.CORRUPTED_OAK_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.NIGHTMARE_WALL.get());
        tag(BlockTags.WALLS).add(ModBlocks.REFINED_NIGHTMARE_WALL.get());
        tag(BlockTags.WALLS).add(ModBlocks.STORM_WALL.get());
        tag(BlockTags.WALLS).add(ModBlocks.INDIGO_BRICK_WALL.get());
        tag(BlockTags.WALLS).add(ModBlocks.STEELIUM_WALL.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.CORRUPTED_OAK_LOG.get())
                .add(ModBlocks.CORRUPTED_OAK_WOOD.get())
                .add(ModBlocks.STRIPPED_CORRUPTED_OAK_LOG.get())
                .add(ModBlocks.STRIPPED_CORRUPTED_OAK_WOOD.get());
    }
}
