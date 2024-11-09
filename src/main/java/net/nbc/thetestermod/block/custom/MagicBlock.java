package net.nbc.thetestermod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.nbc.thetestermod.item.ModItems;
import net.nbc.thetestermod.util.ModTags;

import java.util.List;

public class MagicBlock extends Block
{
    public MagicBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos,
                                               Player pPlayer, BlockHitResult pHitResult) {
        pLevel.playSound(pPlayer, pPos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity instanceof ItemEntity itemEntity)
        {
            if(isValidItem(itemEntity.getItem()))
            {
                itemEntity.setItem(new ItemStack(Items.MUD, itemEntity.getItem().getCount()));
            }

            if(itemEntity.getItem().getItem() == ModItems.NIGHTMARITE.get())
            {
                itemEntity.setItem(new ItemStack(ModItems.PURE_NIGHTMARITE.get(), itemEntity.getItem().getCount()));
            }

            if(itemEntity.getItem().getItem() == Items.ROTTEN_FLESH)
            {
                itemEntity.setItem(new ItemStack(Items.LEATHER, itemEntity.getItem().getCount()));
            }

            if(itemEntity.getItem().getItem() == Items.DIAMOND_BLOCK)
            {
                itemEntity.setItem(new ItemStack(Items.EMERALD, itemEntity.getItem().getCount()));
            }
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    private boolean isValidItem(ItemStack item)
    {
        return item.is(ModTags.Items.TRANSFORMABLE_ITEMS);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("tooltip.testermod.magic_block.tooltip"));
        //for a new line in the tooltip, copy the same line as above and just replace the pKey
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
