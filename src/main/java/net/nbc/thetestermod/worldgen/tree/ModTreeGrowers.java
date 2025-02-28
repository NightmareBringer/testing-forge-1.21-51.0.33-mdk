package net.nbc.thetestermod.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower CORRUPTED_OAK = new TreeGrower(TesterMod.MOD_ID + ":corrupted_oak",
            Optional.empty(), Optional.of(ModConfiguredFeatures.CORRUPTED_OAK_KEY), Optional.empty());
}
