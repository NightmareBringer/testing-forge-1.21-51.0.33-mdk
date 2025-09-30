package net.nbc.thetestermod.item.custom;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.state.BlockState;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.util.ModTags;

public class SpecialPickaxeItem extends PickaxeItem {
    public SpecialPickaxeItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.is(ModTags.Blocks.NEEDS_STEELIUM_TOOL)) {
            return 256.0F;
        }

        return -1.0f;
    }
}
