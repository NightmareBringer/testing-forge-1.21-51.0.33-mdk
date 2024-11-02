package net.nbc.thetestermod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TesterMod.MOD_ID);

    public static final RegistryObject<Block> PURE_NIGHTMARITE_BLOCK = registerBlock("pure_nightmarite_block",
        () -> new Block(BlockBehaviour.Properties.of()
                .strength(10f).explosionResistance(15f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> NIGHTMARITE_BLOCK = registerBlock("nightmarite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f).explosionResistance(5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_ORE)));




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
