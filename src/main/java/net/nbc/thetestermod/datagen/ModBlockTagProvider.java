package net.nbc.thetestermod.datagen;

import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TesterMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.NIGHTMARITE_BLOCK.get())
                .add(ModBlocks.PURE_NIGHTMARITE_BLOCK.get())
                .add(ModBlocks.NIGHTMARE_BLOCK.get())
                .add(ModBlocks.NIGHTMARITE_ORE.get())
                .add(ModBlocks.NIGHTMARITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get())

                .add(ModBlocks.NIGHTMARE_STAIRS.get())
                .add(ModBlocks.NIGHTMARE_SlAB.get())
                .add(ModBlocks.NIGHTMARE_WALL.get())
                .add(ModBlocks.NIGHTMARE_FENCE.get())
                .add(ModBlocks.NIGHTMARE_FENCE_GATE.get())
                .add(ModBlocks.NIGHTMARE_DOOR.get())
                .add(ModBlocks.NIGHTMARE_TRAPDOOR.get())
                .add(ModBlocks.NIGHTMARE_BUTTON.get())
                .add(ModBlocks.NIGHTMARE_PRESSURE_PLATE.get())
                .add(ModBlocks.MAGIC_BLOCK.get());

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
                .add(ModBlocks.MAGIC_BLOCK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NIGHTMARITE_ORE.get())
                .add(ModBlocks.NIGHTMARITE_DEEPSLATE_ORE.get());

        tag(BlockTags.FENCES).add(ModBlocks.NIGHTMARE_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.NIGHTMARE_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.NIGHTMARE_WALL.get());
    }
}
