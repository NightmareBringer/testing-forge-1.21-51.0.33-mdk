package net.nbc.thetestermod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.custom.*;
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
    public static final RegistryObject<Block> ANTI_MAGIC_BLOCK = registerBlock("anti_magic_block",
            () -> new AntiMagicBlock(BlockBehaviour.Properties.of()
                    .strength(4f).explosionResistance(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final RegistryObject<Block> NIGHTMARE_BLOCK = registerBlock("nightmare_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(20f).explosionResistance(25f)
                    .requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final RegistryObject<StairBlock> NIGHTMARE_STAIRS = registerBlock("nightmare_stairs",
            () -> new StairBlock(ModBlocks.NIGHTMARE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(7f).explosionResistance(25f)
                            .sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<SlabBlock> NIGHTMARE_SlAB = registerBlock("nightmare_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(5f).explosionResistance(25f)
                    .sound(SoundType.METAL).requiresCorrectToolForDrops()));

    public static final RegistryObject<PressurePlateBlock> NIGHTMARE_PRESSURE_PLATE = registerBlock("nightmare_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<ButtonBlock> NIGHTMARE_BUTTON = registerBlock("nightmare_button",
            () -> new ButtonBlock(BlockSetType.IRON, 20, BlockBehaviour.Properties.of().strength(2f)
                    .requiresCorrectToolForDrops().noCollission()));

    public static final RegistryObject<FenceBlock> NIGHTMARE_FENCE = registerBlock("nightmare_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(5f).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceGateBlock> NIGHTMARE_FENCE_GATE = registerBlock("nightmare_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of().strength(5f).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<WallBlock> NIGHTMARE_WALL = registerBlock("nightmare_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(25f)
                    .explosionResistance(50f).sound(SoundType.METAL).requiresCorrectToolForDrops()));

    public static final RegistryObject<DoorBlock> NIGHTMARE_DOOR = registerBlock("nightmare_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(8f)
                    .explosionResistance(25f).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<TrapDoorBlock> NIGHTMARE_TRAPDOOR = registerBlock("nightmare_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(4f)
                    .explosionResistance(25f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> NIGHTMARE_LAMP = registerBlock("nightmare_lamp",
            () -> new NightmareLampBlock(BlockBehaviour.Properties.of().strength(3.5f)
                    .lightLevel(state -> state.getValue(NightmareLampBlock.CLICKED) ? 10 : 0)));


    public static final RegistryObject<Block> STORMITE_ORE = registerBlock("stormite_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,6), BlockBehaviour.Properties.of()
                    .strength(8f).explosionResistance(1f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> STORMITE_DEEPSLATE_ORE = registerBlock("stormite_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,9), BlockBehaviour.Properties.of()
                    .strength(16f).explosionResistance(10f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> STORM_BLOCK = registerBlock("storm_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(35f).explosionResistance(35f)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<StairBlock> STORM_STAIRS = registerBlock("storm_stairs",
            () -> new StairBlock(ModBlocks.STORM_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(15f).explosionResistance(34f)
                            .sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<SlabBlock> STORM_SlAB = registerBlock("storm_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(8f).explosionResistance(34f)
                    .sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops()));

    public static final RegistryObject<PressurePlateBlock> STORM_PRESSURE_PLATE = registerBlock("storm_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(5f)
                    .sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<ButtonBlock> STORM_BUTTON = registerBlock("storm_button",
            () -> new ButtonBlock(BlockSetType.IRON, 20, BlockBehaviour.Properties.of().strength(3f)
                    .sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops().noCollission()));

    public static final RegistryObject<FenceBlock> STORM_FENCE = registerBlock("storm_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(15f).sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceGateBlock> STORM_FENCE_GATE = registerBlock("storm_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of().strength(12f).sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<WallBlock> STORM_WALL = registerBlock("storm_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(50f)
                    .explosionResistance(70f).sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops()));

    public static final RegistryObject<DoorBlock> STORM_DOOR = registerBlock("storm_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(20f)
                    .explosionResistance(25f).sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<TrapDoorBlock> STORM_TRAPDOOR = registerBlock("storm_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(10f)
                    .explosionResistance(25f).sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> STORM_LAMP = registerBlock("storm_lamp",
            () -> new NightmareLampBlock(BlockBehaviour.Properties.of().strength(7f)
                    .lightLevel(state -> state.getValue(NightmareLampBlock.CLICKED) ? 3 : 0)));


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
