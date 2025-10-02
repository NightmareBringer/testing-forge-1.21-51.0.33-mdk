package net.nbc.thetestermod.item.custom;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.util.ModTags;
import net.neoforged.neoforge.common.Tags;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SpecialPickaxeItem extends PickaxeItem {
    public SpecialPickaxeItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    // Create set for vault related blocks
    private static final Set<Block> VAULT_BLOCKS = Set.of(
            ModBlocks.STEELIUM_VAULT_BLOCK.get(),
            ModBlocks.NEPTOCHROME_VAULT_BLOCK.get(),
            ModBlocks.STEELIUM_VAULT_WALL.get(),
            ModBlocks.NEPTOCHROME_VAULT_WALL.get(),
            // I know not vault blocks but whatever
            ModBlocks.STEELIUM_DOOR.get(),
            ModBlocks.STEELIUM_TRAPDOOR.get(),
            ModBlocks.NEPTOCHROME_DOOR.get(),
            ModBlocks.NEPTOCHROME_TRAPDOOR.get()
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
        if (VAULT_BLOCKS.contains(state.getBlock())) {
            return 3600000.0F;
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
