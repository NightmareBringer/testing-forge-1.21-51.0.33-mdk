package net.nbc.thetestermod.event;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.entity.ModEntities;
import net.nbc.thetestermod.entity.client.TesterModel;
import net.nbc.thetestermod.entity.custom.TesterEntity;

@Mod.EventBusSubscriber(modid = TesterMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(TesterModel.LAYER_LOCATION, TesterModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.TESTER_MOB.get(), TesterEntity.createAttributes().build());
    }
}
