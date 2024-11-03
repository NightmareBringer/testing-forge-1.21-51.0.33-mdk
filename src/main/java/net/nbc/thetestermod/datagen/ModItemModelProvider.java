package net.nbc.thetestermod.datagen;

import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TesterMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.NIGHTMARITE.get());
        basicItem(ModItems.PURE_NIGHTMARITE.get());
        basicItem(ModItems.NIGHTMARE_INGOT.get());
        basicItem(ModItems.NIGHTMARE_NUGGET.get());

        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.KRABS.get());
        basicItem(ModItems.PURE_EYE.get());
    }
}
