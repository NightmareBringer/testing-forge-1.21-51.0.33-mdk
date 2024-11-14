package net.nbc.thetestermod.datagen;

import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

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
        dropSelf(ModBlocks.MAGIC_BLOCK.get());
        dropSelf(ModBlocks.ANTI_MAGIC_BLOCK.get());

        dropSelf(ModBlocks.NIGHTMARE_STAIRS.get());
        dropSelf(ModBlocks.NIGHTMARE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.NIGHTMARE_BUTTON.get());
        dropSelf(ModBlocks.NIGHTMARE_FENCE.get());
        dropSelf(ModBlocks.NIGHTMARE_FENCE_GATE.get());
        dropSelf(ModBlocks.NIGHTMARE_WALL.get());
        dropSelf(ModBlocks.NIGHTMARE_TRAPDOOR.get());

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

        this.add(ModBlocks.NIGHTMARE_SlAB.get(),
                block -> createSlabItemTable(ModBlocks.NIGHTMARE_SlAB.get()));
        this.add(ModBlocks.NIGHTMARE_DOOR.get(),
                block -> createDoorTable(ModBlocks.NIGHTMARE_DOOR.get()));

        this.add(ModBlocks.STORM_SlAB.get(),
                block -> createSlabItemTable(ModBlocks.STORM_SlAB.get()));
        this.add(ModBlocks.STORM_DOOR.get(),
                block -> createDoorTable(ModBlocks.STORM_DOOR.get()));

        this.add(ModBlocks.NIGHTMARITE_ORE.get(),
                block -> createOreDrop(ModBlocks.NIGHTMARITE_ORE.get(), ModItems.NIGHTMARITE.get()));
        this.add(ModBlocks.NIGHTMARITE_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.NIGHTMARITE_DEEPSLATE_ORE.get(), ModItems.NIGHTMARITE.get(), 2, 3));

        this.add(ModBlocks.STORMITE_ORE.get(),
                block -> createOreDrop(ModBlocks.STORMITE_ORE.get(), ModItems.STORMITE.get()));
        this.add(ModBlocks.STORMITE_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.STORMITE_DEEPSLATE_ORE.get(), ModItems.STORMITE.get(), 0, 1.5f));


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
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
