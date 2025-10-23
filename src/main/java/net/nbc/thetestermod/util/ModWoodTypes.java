package net.nbc.thetestermod.util;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.nbc.thetestermod.TesterMod;

public class ModWoodTypes {
    public static final WoodType CORRUPTED_OAK = WoodType.register(new WoodType(TesterMod.MOD_ID + ":corrupted_oak", BlockSetType.WARPED));
}
