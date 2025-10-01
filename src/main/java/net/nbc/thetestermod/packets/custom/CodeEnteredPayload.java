package net.nbc.thetestermod.packets.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.entity.custom.CodeVaultBlockEntity;
import net.nbc.thetestermod.item.ModItems;
import net.nbc.thetestermod.screen.custom.VaultMenu;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record CodeEnteredPayload(BlockPos pos, String code, boolean settingNewCode) implements CustomPacketPayload {
    public static final Type<CodeEnteredPayload> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "code_entered"));

    public static final StreamCodec<FriendlyByteBuf, CodeEnteredPayload> STREAM_CODEC =
            StreamCodec.composite(
                    BlockPos.STREAM_CODEC, CodeEnteredPayload::pos,
                    ByteBufCodecs.STRING_UTF8, CodeEnteredPayload::code,
                    ByteBufCodecs.BOOL, CodeEnteredPayload::settingNewCode,
                    CodeEnteredPayload::new
            );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(CodeEnteredPayload payload, IPayloadContext ctx) {
        ctx.enqueueWork(() -> {
            ServerPlayer player = (ServerPlayer) ctx.player();
            if (player == null) return;

            if (player.level().getBlockEntity(payload.pos()) instanceof CodeVaultBlockEntity vault) {
                if (payload.settingNewCode()) {
                    // --- SET NEW CODE ---
                    if (!payload.code().isEmpty() && payload.code().length() <= 10) {
                        // validate player has keys
                        if (player.getMainHandItem().is(ModItems.STEELICHROME_KEYS.get()) ||
                                player.getOffhandItem().is(ModItems.STEELICHROME_KEYS.get())) {

                            // set code
                            vault.setCurrentCode(payload.code());

                            // consume one key (prefer main hand first)
                            if (player.getMainHandItem().is(ModItems.STEELICHROME_KEYS.get())) {
                                player.getMainHandItem().shrink(1);
                            } else {
                                player.getOffhandItem().shrink(1);
                            }

                            player.level().playSound(
                                    null,
                                    player.blockPosition(),
                                    SoundEvents.ITEM_BREAK,
                                    SoundSource.PLAYERS,
                                    1.0f,
                                    0.86f
                            );
                        }
                    }
                } else {
                    // --- UNLOCK CHECK ---
                    if (payload.code().equals(vault.getCurrentCode())) {
                        vault.removeConnectedWalls(5);
                    }
                }
            }
        });
    }
}
