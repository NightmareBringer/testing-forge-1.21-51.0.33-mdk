package net.nbc.thetestermod.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Crackiness;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.entity.ArmoredAlienVariant;
import net.nbc.thetestermod.entity.custom.AlienEntity;
import net.nbc.thetestermod.entity.custom.ArmoredAlienEntity;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class ArmoredAlienRenderer extends MobRenderer<ArmoredAlienEntity, ArmoredAlienModel<ArmoredAlienEntity>> {

    private static final Map<ArmoredAlienVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(ArmoredAlienVariant.class), map -> {
                map.put(ArmoredAlienVariant.BLUE,
                        ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "textures/entity/alien/armored_alien_1"));
                map.put(ArmoredAlienVariant.GREEN,
                        ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "textures/entity/alien/armored_alien_2"));
            });

    public ArmoredAlienRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ArmoredAlienModel<>(pContext.bakeLayer(ArmoredAlienModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(ArmoredAlienEntity allenEntity) {
        Crackiness.Level level = allenEntity.getCrackiness();
        ResourceLocation variant = LOCATION_BY_VARIANT.get(allenEntity.getVariant());
        
        String path = switch (level) {
            case NONE   -> variant.getPath() + ".png";
            case LOW    -> variant.getPath() + "_withered_1.png";
            case MEDIUM -> variant.getPath() + "_withered_2.png";
            case HIGH   -> variant.getPath() + "_withered_3.png";
        };

        return ResourceLocation.fromNamespaceAndPath(variant.getNamespace(), path);
    }

    @Override
    public void render(ArmoredAlienEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    protected @Nullable RenderType getRenderType(ArmoredAlienEntity entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityTranslucent(getTextureLocation(entity));
    }
}
