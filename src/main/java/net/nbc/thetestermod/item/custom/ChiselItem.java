package net.nbc.thetestermod.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.component.ModDataComponentTypes;
import net.nbc.thetestermod.sound.ModSounds;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class ChiselItem extends Item
{
    private static final Random RANDOM = new Random();

    public static Block getChiseledBlock(Block originalBlock) {
        if (originalBlock == Blocks.GRASS_BLOCK) {
            return RANDOM.nextBoolean() ? ModBlocks.NIGHTMARITE_ORE.get() : ModBlocks.STORMITE_ORE.get();
        }

        return CHISEL_MAP.getOrDefault(originalBlock, originalBlock);
    }

    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                    Blocks.TUFF, Blocks.TUFF_BRICKS

            );

    public ChiselItem(Properties pProperties)
    {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();
        Player player = pContext.getPlayer();

        Block chiseledBlock = getChiseledBlock(clickedBlock);

        if (chiseledBlock != clickedBlock) {
            if (!level.isClientSide()) {
                // Update the block in the world
                level.setBlockAndUpdate(pContext.getClickedPos(), chiseledBlock.defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, pContext.getClickedPos(), ModSounds.CHISEL_USE.get(), SoundSource.BLOCKS);

                if (player != null && !player.getAbilities().instabuild)
                {
                    pContext.getItemInHand().set(ModDataComponentTypes.COORDINATES.get(), pContext.getClickedPos());
                }
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown())
        {
            pTooltipComponents.add(Component.translatable("tooltip.testermod.chisel.shift_down1"));
            pTooltipComponents.add(Component.translatable("tooltip.testermod.chisel.shift_down2"));
        }
        else
        {
            pTooltipComponents.add(Component.translatable("tooltip.testermod.chisel"));
        }

        if(pStack.get(ModDataComponentTypes.COORDINATES.get()) != null)
        {
            pTooltipComponents.add(Component.literal("Last Block changed at " + pStack.get(ModDataComponentTypes.COORDINATES.get())));
        }

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
