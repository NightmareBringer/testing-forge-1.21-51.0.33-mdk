package net.nbc.thetestermod.datagen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.server.ReloadableServerRegistries;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.block.custom.WhiteCarrotCropBlock;
import net.nbc.thetestermod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraft.core.Holder;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.NIGHTMARITE_BLOCK.get());
        dropSelf(ModBlocks.PURE_NIGHTMARITE_BLOCK.get());
        dropSelf(ModBlocks.NIGHTMARE_BLOCK.get());
        dropSelf(ModBlocks.REFINED_NIGHTMARE_BLOCK.get());
        dropSelf(ModBlocks.MAGIC_BLOCK.get());
        dropSelf(ModBlocks.ANTI_MAGIC_BLOCK.get());
        dropSelf(ModBlocks.PEDESTAL_BLOCK.get());

        dropSelf(ModBlocks.PURIFIER_BLOCK.get());
        dropSelf(ModBlocks.IMPURIFIER_BLOCK.get());

        dropSelf(ModBlocks.NIGHTMARE_STAIRS.get());
        dropSelf(ModBlocks.NIGHTMARE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.NIGHTMARE_BUTTON.get());
        dropSelf(ModBlocks.NIGHTMARE_FENCE.get());
        dropSelf(ModBlocks.NIGHTMARE_FENCE_GATE.get());
        dropSelf(ModBlocks.NIGHTMARE_WALL.get());
        dropSelf(ModBlocks.NIGHTMARE_TRAPDOOR.get());

        dropSelf(ModBlocks.REFINED_NIGHTMARE_STAIRS.get());
        dropSelf(ModBlocks.REFINED_NIGHTMARE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.REFINED_NIGHTMARE_BUTTON.get());
        dropSelf(ModBlocks.REFINED_NIGHTMARE_FENCE.get());
        dropSelf(ModBlocks.REFINED_NIGHTMARE_FENCE_GATE.get());
        dropSelf(ModBlocks.REFINED_NIGHTMARE_WALL.get());

        dropSelf(ModBlocks.NIGHTMARE_LAMP.get());

        dropSelf(ModBlocks.STORM_BLOCK.get());

        dropSelf(ModBlocks.STORM_STAIRS.get());
        dropSelf(ModBlocks.STORM_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.STORM_BUTTON.get());
        dropSelf(ModBlocks.STORM_FENCE.get());
        dropSelf(ModBlocks.STORM_FENCE_GATE.get());
        dropSelf(ModBlocks.STORM_WALL.get());
        dropSelf(ModBlocks.STORM_TRAPDOOR.get());

        dropSelf(ModBlocks.STORM_LAMP.get());

        dropSelf(ModBlocks.RED_GAMING_CHAIR.get());
        dropSelf(ModBlocks.BLUE_GAMING_CHAIR.get());

        this.add(ModBlocks.NIGHTMARE_SlAB.get(),
                block -> createSlabItemTable(ModBlocks.NIGHTMARE_SlAB.get()));
        this.add(ModBlocks.REFINED_NIGHTMARE_SlAB.get(),
                block -> createSlabItemTable(ModBlocks.REFINED_NIGHTMARE_SlAB.get()));
        this.add(ModBlocks.NIGHTMARE_DOOR.get(),
                block -> createDoorTable(ModBlocks.NIGHTMARE_DOOR.get()));

        this.add(ModBlocks.STORM_SlAB.get(),
                block -> createSlabItemTable(ModBlocks.STORM_SlAB.get()));
        this.add(ModBlocks.STORM_DOOR.get(),
                block -> createDoorTable(ModBlocks.STORM_DOOR.get()));

        this.add(ModBlocks.NIGHTMARITE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.NIGHTMARITE_ORE.get(), ModItems.NIGHTMARITE.get(), 0, 2));
        this.add(ModBlocks.NIGHTMARITE_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.NIGHTMARITE_DEEPSLATE_ORE.get(), ModItems.NIGHTMARITE.get(), 0, 2));
        this.add(ModBlocks.NIGHTMARITE_NETHER_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.NIGHTMARITE_NETHER_ORE.get(), ModItems.NIGHTMARITE.get(), 0, 1));
        this.add(ModBlocks.NIGHTMARITE_END_ORE.get(),
                block -> createOreDrop(ModBlocks.NIGHTMARITE_END_ORE.get(), ModItems.NIGHTMARITE.get()));

        this.add(ModBlocks.STORMITE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.STORMITE_ORE.get(), ModItems.STORMITE.get(), 0, 1));
        this.add(ModBlocks.STORMITE_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.STORMITE_DEEPSLATE_ORE.get(), ModItems.STORMITE.get(), 0, 1));
        this.add(ModBlocks.STORM_NETHER_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.STORM_NETHER_ORE.get(), ModItems.STORMITE.get(), 0, 2));
        this.add(ModBlocks.STORM_END_ORE.get(),
                block -> createOreDrop(ModBlocks.STORM_END_ORE.get(), ModItems.STORMITE.get()));

        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.WHITE_CARROT_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(WhiteCarrotCropBlock.AGE, WhiteCarrotCropBlock.MAX_AGE));

        this.add(ModBlocks.WHITE_CARROT_CROP.get(), this.createCropDrops(ModBlocks.WHITE_CARROT_CROP.get(),
                ModItems.WHITE_CARROT.get(), ModItems.WHITE_CARROT.get(), lootItemConditionBuilder));

        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        this.add(ModBlocks.CRIMSON_BLUE_BERRY_BUSH.get(), block -> this.applyExplosionDecay(
                block,LootTable.lootTable().withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CRIMSON_BLUE_BERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))
                                ).add(LootItem.lootTableItem(ModItems.CRIMSON_BLUE_BERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                ).withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CRIMSON_BLUE_BERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
                                ).add(LootItem.lootTableItem(ModItems.CRIMSON_BLUE_BERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )));

        this.dropSelf(ModBlocks.CORRUPTED_OAK_LOG.get());
        this.dropSelf(ModBlocks.CORRUPTED_OAK_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_CORRUPTED_OAK_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_CORRUPTED_OAK_WOOD.get());
        this.dropSelf(ModBlocks.CORRUPTED_OAK_PLANKS.get());
        this.dropSelf(ModBlocks.CORRUPTED_OAK_SAPLING.get());

        dropSelf(ModBlocks.CORRUPTED_OAK_STAIRS.get());
        dropSelf(ModBlocks.CORRUPTED_OAK_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.CORRUPTED_OAK_BUTTON.get());
        dropSelf(ModBlocks.CORRUPTED_OAK_FENCE.get());
        dropSelf(ModBlocks.CORRUPTED_OAK_FENCE_GATE.get());
        dropSelf(ModBlocks.CORRUPTED_OAK_TRAPDOOR.get());
        dropSelf(ModBlocks.MYSTERIOUS_DUST_BLOCK.get());

        this.add(ModBlocks.CORRUPTED_OAK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CORRUPTED_OAK_SLAB.get()));
        this.add(ModBlocks.CORRUPTED_OAK_DOOR.get(),
                block -> createDoorTable(ModBlocks.CORRUPTED_OAK_DOOR.get()));
        this.add(ModBlocks.MYSTERIOUS_DUST_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MYSTERIOUS_DUST_SLAB.get()));

        this.add(ModBlocks.CORRUPTED_OAK_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.MYSTERIOUS_DUST_SLAB.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        dropSelf(ModBlocks.INDIGO_BRICKS.get());

        dropSelf(ModBlocks.INDIGO_BRICK_STAIRS.get());
        dropSelf(ModBlocks.INDIGO_BRICK_WALL.get());
        this.add(ModBlocks.INDIGO_BRICK_SlAB.get(),
                block -> createSlabItemTable(ModBlocks.INDIGO_BRICK_SlAB.get()));

        dropSelf(ModBlocks.STEELIUM_STAIRS.get());
        dropSelf(ModBlocks.STEELIUM_BARS.get());
        dropSelf(ModBlocks.STEELIUM_WALL.get());
        dropSelf(ModBlocks.STEELIUM_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.STEELIUM_BUTTON.get());
        dropSelf(ModBlocks.STEELIUM_TRAPDOOR.get());
        dropSelf(ModBlocks.STEELIUM_BLOCK.get());
        dropSelf(ModBlocks.STEELIUM_CONSOLE.get());
        dropSelf(ModBlocks.STEELIUM_CORE.get());
        dropSelf(ModBlocks.STEELIUM_ENERGY_TUBE_VERT.get());
        dropSelf(ModBlocks.STEELIUM_ENERGY_TUBE_HORI.get());
        dropSelf(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BL.get());
        dropSelf(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_BR.get());
        dropSelf(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TR.get());
        dropSelf(ModBlocks.STEELIUM_ENERGY_TUBE_CORNER_TL.get());
        dropSelf(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_L.get());
        dropSelf(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_B.get());
        dropSelf(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_R.get());
        dropSelf(ModBlocks.STEELIUM_ENERGY_TUBE_THREEWAY_T.get());

        dropSelf(ModBlocks.FALSE_STORMITE_BLOCK.get());
        dropSelf(ModBlocks.FALSE_NIGHTMARITE_BLOCK.get());

        this.add(ModBlocks.STEELIUM_SlAB.get(),
                block -> createSlabItemTable(ModBlocks.STEELIUM_SlAB.get()));
        this.add(ModBlocks.STEELIUM_DOOR.get(),
                block -> createDoorTable(ModBlocks.STEELIUM_DOOR.get()));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
