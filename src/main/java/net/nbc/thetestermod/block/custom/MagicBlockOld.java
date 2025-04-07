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
import net.nbc.thetestermod.particle.ModParticles;
import net.nbc.thetestermod.util.ModTags;

import java.util.List;

public class MagicBlockOld extends Block {

    public MagicBlockOld(Properties pProperties) {
        super(pProperties);
    }

    /*

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return null;
    }


    public MagicBlock(Properties p_49795_) {
        super(p_49795_);
    }
*/
    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos,
                                               Player pPlayer, BlockHitResult pHitResult) {
        pLevel.addParticle(ModParticles.SHINE_PARTICLES.get(), pPos.getX()+0.5, pPos.getY()+1, pPos.getZ()+0.5, 0, 1, 0);
        //pLevel.playSound(pPlayer, pPos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity instanceof ItemEntity itemEntity)
        {
            if(isValidItem(itemEntity.getItem()))
            {
                itemEntity.setItem(new ItemStack(Items.MUD, itemEntity.getItem().getCount()));
                pLevel.playSound(pEntity, pPos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1f, 0.75f);
            }

            if(itemEntity.getItem().getItem() == ModItems.NIGHTMARITE.get())
            {
                itemEntity.setItem(new ItemStack(ModItems.PURE_NIGHTMARITE.get(), itemEntity.getItem().getCount()));
                pLevel.playSound(pEntity, pPos, SoundEvents.PLAYER_BREATH, SoundSource.BLOCKS, 1f, 1f);
            }

            if(itemEntity.getItem().getItem() == Items.ROTTEN_FLESH)
            {
                itemEntity.setItem(new ItemStack(Items.LEATHER, itemEntity.getItem().getCount()));
                pLevel.playSound(pEntity, pPos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1f, 1f);
            }

            if(itemEntity.getItem().getItem() == Items.DIAMOND_BLOCK)
            {
                itemEntity.setItem(new ItemStack(Items.EMERALD, itemEntity.getItem().getCount()));
                pLevel.playSound(pEntity, pPos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1f, 1f);
            }
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    private boolean isValidItem(ItemStack item)
    {
        return item.is(ModTags.Items.TRANSFORMABLE_ITEMS);
    }

}
