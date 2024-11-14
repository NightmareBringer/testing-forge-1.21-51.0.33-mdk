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

public class AntiMagicBlock extends Block
{
    public AntiMagicBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos,
                                               Player pPlayer, BlockHitResult pHitResult) {
        //pLevel.playSound(pPlayer, pPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity instanceof ItemEntity itemEntity)
        {
            if(itemEntity.getItem().getItem() == ModItems.STORMITE.get())
            {
                itemEntity.setItem(new ItemStack(ModItems.IMPURE_STORMITE.get(), itemEntity.getItem().getCount()));
                pLevel.playSound(pEntity, pPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1f, 0.7f);
            }

            if(isValidItem(itemEntity.getItem()))
            {
                itemEntity.setItem(new ItemStack(Items.COAL_BLOCK, itemEntity.getItem().getCount()));
                pLevel.playSound(pEntity, pPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1f, 1.5f);
            }

            if(itemEntity.getItem().getItem() == ModItems.NIGHTMARITE.get())
            {
                itemEntity.setItem(new ItemStack(ModItems.PURE_NIGHTMARITE.get(), itemEntity.getItem().getCount()));
                pLevel.playSound(pEntity, pPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1f, 0.7f);
            }

            if(itemEntity.getItem().getItem() == Items.LEATHER)
            {
                itemEntity.setItem(new ItemStack(Items.ROTTEN_FLESH, itemEntity.getItem().getCount()));
                pLevel.playSound(pEntity, pPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1f, 1f);
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
        pTooltipComponents.add(Component.translatable("tooltip.testermod.anti_magic_block.tooltip"));
        //for a new line in the tooltip, copy the same line as above and just replace the pKey
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
