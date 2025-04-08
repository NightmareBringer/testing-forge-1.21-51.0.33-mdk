package net.nbc.thetestermod.block;

import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.custom.*;
import net.nbc.thetestermod.item.ModItems;
import net.nbc.thetestermod.sound.ModSounds;
import net.nbc.thetestermod.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.createBlocks(TesterMod.MOD_ID);

    public static final DeferredBlock<Block> PURE_NIGHTMARITE_BLOCK = registerBlock("pure_nightmarite_block",
        () -> new Block(BlockBehaviour.Properties.of()
                .strength(10f).explosionResistance(15f)
                .requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

    public static final DeferredBlock<Block> NIGHTMARITE_BLOCK = registerBlock("nightmarite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f).explosionResistance(5f)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHER_ORE)));

    public static final DeferredBlock<Block> NIGHTMARITE_ORE = registerBlock("nightmarite_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .strength(5f).explosionResistance(5f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> NIGHTMARITE_DEEPSLATE_ORE = registerBlock("nightmarite_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(4,7), BlockBehaviour.Properties.of()
                    .strength(10f).explosionResistance(15f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> NIGHTMARITE_NETHER_ORE = registerBlock("nightmarite_nether_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .strength(5f).explosionResistance(5f)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE)));
    public static final DeferredBlock<Block> NIGHTMARITE_END_ORE = registerBlock("nightmarite_end_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .strength(5f).explosionResistance(5f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));


    public static final DeferredBlock<Block> NIGHTMARE_BLOCK = registerBlock("nightmare_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(20f).explosionResistance(25f)
                    .requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<StairBlock> NIGHTMARE_STAIRS = registerBlock("nightmare_stairs",
            () -> new StairBlock(ModBlocks.NIGHTMARE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(7f).explosionResistance(25f)
                            .sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final DeferredBlock<SlabBlock> NIGHTMARE_SlAB = registerBlock("nightmare_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(5f).explosionResistance(25f)
                    .sound(SoundType.METAL).requiresCorrectToolForDrops()));

    public static final DeferredBlock<PressurePlateBlock> NIGHTMARE_PRESSURE_PLATE = registerBlock("nightmare_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ButtonBlock> NIGHTMARE_BUTTON = registerBlock("nightmare_button",
            () -> new ButtonBlock(BlockSetType.IRON, 20, BlockBehaviour.Properties.of().strength(2f)
                    .requiresCorrectToolForDrops().noCollission()));

    public static final DeferredBlock<FenceBlock> NIGHTMARE_FENCE = registerBlock("nightmare_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(5f).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final DeferredBlock<FenceGateBlock> NIGHTMARE_FENCE_GATE = registerBlock("nightmare_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of().strength(5f).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final DeferredBlock<WallBlock> NIGHTMARE_WALL = registerBlock("nightmare_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(25f)
                    .explosionResistance(50f).sound(SoundType.METAL).requiresCorrectToolForDrops()));

    public static final DeferredBlock<DoorBlock> NIGHTMARE_DOOR = registerBlock("nightmare_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(8f)
                    .explosionResistance(25f).requiresCorrectToolForDrops().noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> NIGHTMARE_TRAPDOOR = registerBlock("nightmare_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(4f)
                    .explosionResistance(25f).requiresCorrectToolForDrops().noOcclusion()));

    public static final DeferredBlock<Block> NIGHTMARE_LAMP = registerBlock("nightmare_lamp",
            () -> new NightmareLampBlock(BlockBehaviour.Properties.of().strength(3.5f)
                    .lightLevel(state -> state.getValue(NightmareLampBlock.CLICKED) ? 10 : 0)));


    public static final DeferredBlock<Block> STORMITE_ORE = registerBlock("stormite_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,6), BlockBehaviour.Properties.of()
                    .strength(8f).explosionResistance(1f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> STORMITE_DEEPSLATE_ORE = registerBlock("stormite_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,9), BlockBehaviour.Properties.of()
                    .strength(16f).explosionResistance(10f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> STORM_NETHER_ORE = registerBlock("stormite_nether_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .strength(8f).explosionResistance(5f)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE)));
    public static final DeferredBlock<Block> STORM_END_ORE = registerBlock("stormite_end_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .strength(8f).explosionResistance(5f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> STORM_BLOCK = registerBlock("storm_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(35f).explosionResistance(35f)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

    public static final DeferredBlock<StairBlock> STORM_STAIRS = registerBlock("storm_stairs",
            () -> new StairBlock(ModBlocks.STORM_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(15f).explosionResistance(34f)
                            .sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops()));
    public static final DeferredBlock<SlabBlock> STORM_SlAB = registerBlock("storm_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(8f).explosionResistance(34f)
                    .sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops()));

    public static final DeferredBlock<PressurePlateBlock> STORM_PRESSURE_PLATE = registerBlock("storm_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(5f)
                    .sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ButtonBlock> STORM_BUTTON = registerBlock("storm_button",
            () -> new ButtonBlock(BlockSetType.IRON, 20, BlockBehaviour.Properties.of().strength(3f)
                    .sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops().noCollission()));

    public static final DeferredBlock<FenceBlock> STORM_FENCE = registerBlock("storm_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(15f).sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops()));
    public static final DeferredBlock<FenceGateBlock> STORM_FENCE_GATE = registerBlock("storm_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of().strength(12f).sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops()));
    public static final DeferredBlock<WallBlock> STORM_WALL = registerBlock("storm_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(50f)
                    .explosionResistance(70f).sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops()));

    public static final DeferredBlock<DoorBlock> STORM_DOOR = registerBlock("storm_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(20f)
                    .explosionResistance(25f).sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops().noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> STORM_TRAPDOOR = registerBlock("storm_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(10f)
                    .explosionResistance(25f).sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops().noOcclusion()));

    public static final DeferredBlock<Block> STORM_LAMP = registerBlock("storm_lamp",
            () -> new NightmareLampBlock(BlockBehaviour.Properties.of().strength(7f)
                    .lightLevel(state -> state.getValue(NightmareLampBlock.CLICKED) ? 3 : 0)));

    public static final DeferredBlock<Block> REFINED_NIGHTMARE_BLOCK = registerBlock("refined_nightmare_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(180f).explosionResistance(225f)
                    .requiresCorrectToolForDrops().sound(SoundType.TUFF)));

    public static final DeferredBlock<StairBlock> REFINED_NIGHTMARE_STAIRS = registerBlock("refined_nightmare_stairs",
            () -> new StairBlock(ModBlocks.REFINED_NIGHTMARE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(63f).explosionResistance(225f)
                            .sound(SoundType.TUFF).requiresCorrectToolForDrops()));
    public static final DeferredBlock<SlabBlock> REFINED_NIGHTMARE_SlAB = registerBlock("refined_nightmare_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(45f).explosionResistance(225f)
                    .sound(SoundType.TUFF).requiresCorrectToolForDrops()));

    public static final DeferredBlock<PressurePlateBlock> REFINED_NIGHTMARE_PRESSURE_PLATE = registerBlock("refined_nightmare_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.GOLD, BlockBehaviour.Properties.of().strength(27f).sound(SoundType.TUFF).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ButtonBlock> REFINED_NIGHTMARE_BUTTON = registerBlock("refined_nightmare_button",
            () -> new ButtonBlock(BlockSetType.IRON, 20, BlockBehaviour.Properties.of().strength(18f)
                    .sound(SoundType.TUFF).requiresCorrectToolForDrops().noCollission()));

    public static final DeferredBlock<FenceBlock> REFINED_NIGHTMARE_FENCE = registerBlock("refined_nightmare_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(45f).sound(SoundType.TUFF).requiresCorrectToolForDrops()));
    public static final DeferredBlock<FenceGateBlock> REFINED_NIGHTMARE_FENCE_GATE = registerBlock("refined_nightmare_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of().strength(45f).sound(SoundType.TUFF).requiresCorrectToolForDrops()));
    public static final DeferredBlock<WallBlock> REFINED_NIGHTMARE_WALL = registerBlock("refined_nightmare_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(225f)
                    .explosionResistance(450f).sound(SoundType.TUFF).requiresCorrectToolForDrops()));

    public static final DeferredHolder<Block, WhiteCarrotCropBlock> WHITE_CARROT_CROP = BLOCKS.register("white_carrot_crop",
            () -> new WhiteCarrotCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CARROTS)));

    public static final DeferredHolder<Block, CrimsonBlueBerryBushBlock> CRIMSON_BLUE_BERRY_BUSH = BLOCKS.register("crimson_blue_berry_bush",
            () -> new CrimsonBlueBerryBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)));

    public static final DeferredBlock<RotatedPillarBlock> CORRUPTED_OAK_LOG = registerBlock("corrupted_oak_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<RotatedPillarBlock> CORRUPTED_OAK_WOOD = registerBlock("corrupted_oak_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));

    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_CORRUPTED_OAK_LOG = registerBlock("stripped_corrupted_oak_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_LOG)));
    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_CORRUPTED_OAK_WOOD = registerBlock("stripped_corrupted_oak_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_WOOD)));

    public static final DeferredBlock<Block> CORRUPTED_OAK_PLANKS = registerBlock("corrupted_oak_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return super.isFlammable(state, level, pos, direction);
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 25;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<Block> CORRUPTED_OAK_LEAVES = registerBlock("corrupted_oak_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return super.isFlammable(state, level, pos, direction);
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 50;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 35;
                }
            });

    public static final DeferredBlock<Block> CORRUPTED_OAK_SAPLING = registerBlock("corrupted_oak_sapling",
            () -> new SaplingBlock(ModTreeGrowers.CORRUPTED_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    // FOR TREE THAT DOESN'T GROW ON GRASS/DIRT
    // public static final DeferredBlock<Block> CORRUPTED_OAK_SAPLING = registerBlock("corrupted_oak_sapling",
    //         () -> new ModSaplingBlock(ModTreeGrowers.CORRUPTED_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), () -> Blocks.GRAVEL));

    public static final DeferredBlock<StairBlock> CORRUPTED_OAK_STAIRS = registerBlock("corrupted_oak_stairs",
            () -> new StairBlock(ModBlocks.CORRUPTED_OAK_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STAIRS)));
    public static final DeferredBlock<SlabBlock> CORRUPTED_OAK_SLAB = registerBlock("corrupted_oak_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_SLAB)));

    public static final DeferredBlock<PressurePlateBlock> CORRUPTED_OAK_PRESSURE_PLATE = registerBlock("corrupted_oak_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.WARPED, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PRESSURE_PLATE)));
    public static final DeferredBlock<ButtonBlock> CORRUPTED_OAK_BUTTON = registerBlock("corrupted_oak_button",
            () -> new ButtonBlock(BlockSetType.WARPED, 20, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_BUTTON)));

    public static final DeferredBlock<FenceBlock> CORRUPTED_OAK_FENCE = registerBlock("corrupted_oak_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FENCE)));
    public static final DeferredBlock<FenceGateBlock> CORRUPTED_OAK_FENCE_GATE = registerBlock("corrupted_oak_fence_gate",
            () -> new FenceGateBlock(WoodType.WARPED, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FENCE_GATE)));

    public static final DeferredBlock<DoorBlock> CORRUPTED_OAK_DOOR = registerBlock("corrupted_oak_door",
            () -> new DoorBlock(BlockSetType.WARPED, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_DOOR)));
    public static final DeferredBlock<TrapDoorBlock> CORRUPTED_OAK_TRAPDOOR = registerBlock("corrupted_oak_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.WARPED, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_TRAPDOOR)));

    public static final DeferredBlock<Block> MYSTERIOUS_DUST_BLOCK = registerBlock("mysterious_dust_block",
            () -> new MysteriousDustBlock((BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SAND).strength(0.35f))));

    public static final DeferredBlock<FallingSlabBlock> MYSTERIOUS_DUST_SLAB = registerBlock("mysterious_dust_slab",
            () -> new FallingSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SAND).strength(0.15f)));

    public static final DeferredBlock<Block> RED_GAMING_CHAIR = registerBlock("gaming_chair_red",
            () -> new GamingChairRedBlock(BlockBehaviour.Properties.of().strength(0.25f).noOcclusion()));

    public static final DeferredBlock<Block> BLUE_GAMING_CHAIR = registerBlock("gaming_chair_blue",
            () -> new GamingChairBlueBlock(BlockBehaviour.Properties.of().strength(0.25f).noOcclusion()));

    public static final DeferredBlock<Block> PEDESTAL_BLOCK = registerBlock("pedestal",
            () -> new PedestalBlock(BlockBehaviour.Properties.of().strength(10f).noOcclusion()));

    public static final DeferredBlock<Block> PURIFIER_BLOCK = registerBlock("purifier_block",
            () -> new PurifierBlock(BlockBehaviour.Properties.of().strength(3.5f).explosionResistance(3.5f)
                    .requiresCorrectToolForDrops().sound(ModSounds.MAGIC_BLOCK_SOUNDS)));
    public static final DeferredBlock<Block> IMPURIFIER_BLOCK = registerBlock("impurifier_block",
            () -> new ImpurifierBlock(BlockBehaviour.Properties.of().strength(5f).explosionResistance(5f)
                    .requiresCorrectToolForDrops().sound(ModSounds.ANTI_MAGIC_BLOCK_SOUNDS)));

    public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlockOld(BlockBehaviour.Properties.of()
                    .strength(3.5f).explosionResistance(3.5f)
                    .requiresCorrectToolForDrops().sound(ModSounds.MAGIC_BLOCK_SOUNDS)));
    public static final DeferredBlock<Block> ANTI_MAGIC_BLOCK = registerBlock("anti_magic_block",
            () -> new AntiMagicBlockOld(BlockBehaviour.Properties.of()
                    .strength(5f).explosionResistance(5f)
                    .requiresCorrectToolForDrops().sound(ModSounds.ANTI_MAGIC_BLOCK_SOUNDS)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block)
    {
        DeferredBlock<T> toReturn = (DeferredBlock<T>) BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
