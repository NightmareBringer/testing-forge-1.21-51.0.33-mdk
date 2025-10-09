package net.nbc.thetestermod.item.custom;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.util.ModTags;

import java.util.Set;

public class SpecialPickaxeItem extends PickaxeItem {
    public SpecialPickaxeItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    // Create set for misc related blocks
    private static final Set<Block> OTHER_BLOCKS = Set.of(
            ModBlocks.STEELIUM_VAULT_BLOCK.get(),
            ModBlocks.NEPTOCHROME_VAULT_BLOCK.get(),
            ModBlocks.STEELIUM_VAULT_WALL.get(),
            ModBlocks.NEPTOCHROME_VAULT_WALL.get(),
            ModBlocks.STEELIUM_DOOR.get(),
            ModBlocks.STEELIUM_TRAPDOOR.get(),
            ModBlocks.STEELIUM_BLOCK.get(),
            ModBlocks.STEELIUM_STAIRS.get(),
            ModBlocks.STEELIUM_CORE.get(),
            ModBlocks.STEELIUM_BARS.get(),
            ModBlocks.STEELIUM_ENERGY_TUBE_HORI.get(),
            ModBlocks.STEELIUM_ENERGY_TUBE_VERT.get(),
            ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BR.get(),
            ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BL.get(),
            ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TR.get(),
            ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TL.get(),
            ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_B.get(),
            ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_T.get(),
            ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_L.get(),
            ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_R.get(),
            ModBlocks.NEPTOCHROME_BLOCK.get(),
            ModBlocks.NEPTOCHROME_STAIRS.get(),
            ModBlocks.NEPTOCHROME_CORE.get(),
            ModBlocks.NEPTOCHROME_BARS.get(),
            ModBlocks.NEPTOCHROME_DOOR.get(),
            ModBlocks.NEPTOCHROME_TRAPDOOR.get(),
            ModBlocks.NEPTOCHROME_ENERGY_TUBE_VERT.get(),
            ModBlocks.NEPTOCHROME_ENERGY_TUBE_HORI.get(),
            ModBlocks.NEPTOCHROME_ENERGY_TUBE_CORNER_BR.get(),
            ModBlocks.NEPTOCHROME_ENERGY_TUBE_CORNER_BL.get(),
            ModBlocks.NEPTOCHROME_ENERGY_TUBE_CORNER_TR.get(),
            ModBlocks.NEPTOCHROME_ENERGY_TUBE_CORNER_TL.get(),
            ModBlocks.NEPTOCHROME_ENERGY_TUBE_THREEWAY_B.get(),
            ModBlocks.NEPTOCHROME_ENERGY_TUBE_THREEWAY_T.get(),
            ModBlocks.NEPTOCHROME_ENERGY_TUBE_THREEWAY_L.get(),
            ModBlocks.NEPTOCHROME_ENERGY_TUBE_THREEWAY_R.get()
    );

    // Create set for Nightmarite and Stormite ores
    private static final Set<Block> ORES = Set.of(
            ModBlocks.NIGHTMARITE_ORE.get(),
            ModBlocks.NIGHTMARITE_END_ORE.get(),
            ModBlocks.NIGHTMARITE_NETHER_ORE.get(),
            ModBlocks.NIGHTMARITE_DEEPSLATE_ORE.get(),
            ModBlocks.STORMITE_ORE.get(),
            ModBlocks.STORM_END_ORE.get(),
            ModBlocks.STORM_NETHER_ORE.get(),
            ModBlocks.STORMITE_DEEPSLATE_ORE.get()
    );

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (OTHER_BLOCKS.contains(state.getBlock())) {
            return 3600000.0F*2;
        }
        if (ORES.contains(state.getBlock())) {
            return 64.0F;
        }
        if (state.is(ModTags.Blocks.NEEDS_STEELIUM_TOOL)) {
            return 480.0F;
        }

        return -1.0f;
    }
}
