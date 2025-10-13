package net.nbc.thetestermod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.nbc.thetestermod.item.ModItems;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.WOVEN_INDIGO_BRICK.getId(), new FurnaceFuel(300), false)
                .add(ModItems.PURE_EYE.getId(), new FurnaceFuel(1200), false)
                .add(ModItems.IMPURE_EYE.getId(), new FurnaceFuel(2400), false);

        this.builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(ModItems.WHITE_CARROT.getId(), new Compostable(0.25f), false)
                .add(ModItems.GLISTERING_CARROT.getId(), new Compostable(0.99f), false);
    }
}
