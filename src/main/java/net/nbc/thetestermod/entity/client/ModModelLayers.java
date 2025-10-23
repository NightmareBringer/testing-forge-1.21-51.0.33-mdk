package net.nbc.thetestermod.entity.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.nbc.thetestermod.TesterMod;

public class ModModelLayers {
    public static final ModelLayerLocation CORRUPTED_OAK_BOAT_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "boat/corrupted_oak"), "main");

    public static final ModelLayerLocation CORRUPTED_OAK_CHEST_BOAT_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "chest_boat/corrupted_oak"), "main");
}
