package net.nbc.thetestermod.packets;

import net.minecraft.server.level.ServerPlayer;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.entity.custom.CodeVaultBlockEntity;
import net.nbc.thetestermod.packets.custom.CodeEnteredPayload;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = TesterMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModMessages {
    @SubscribeEvent
    public static void onRegisterPayloads(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1"); // protocol version
        registrar.playToServer(
                CodeEnteredPayload.TYPE,
                CodeEnteredPayload.STREAM_CODEC,
                CodeEnteredPayload::handle
        );
    }
}
