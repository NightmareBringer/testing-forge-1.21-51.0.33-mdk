package net.nbc.thetestermod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.custom.MagicBlock;
import net.nbc.thetestermod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TesterMod.MOD_ID);

    public static final RegistryObject<Block> PURE_NIGHTMARITE_BLOCK = registerBlock("pure_nightmarite_block",
        () -> new Block(BlockBehaviour.Properties.of()
                .strength(10f).explosionResistance(15f)
                .requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> NIGHTMARITE_BLOCK = registerBlock("nightmarite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f).explosionResistance(5f)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHER_ORE)));

    public static final RegistryObject<Block> NIGHTMARITE_ORE = registerBlock("nightmarite_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .strength(5f).explosionResistance(5f)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE)));

    public static final RegistryObject<Block> NIGHTMARITE_DEEPSLATE_ORE = registerBlock("nightmarite_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(4,7), BlockBehaviour.Properties.of()
                    .strength(10f).explosionResistance(15f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of()
                    .strength(3f).explosionResistance(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final RegistryObject<Block> NIGHTMARE_BLOCK = registerBlock("nightmare_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(20f).explosionResistance(25f)
                    .requiresCorrectToolForDrops().sound(SoundType.METAL)));


    //public static final RegistryObject<StairBlock>


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
