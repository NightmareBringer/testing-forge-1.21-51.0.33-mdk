package net.nbc.thetestermod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.entity.custom.TesterEntity;

public class TesterRenderer extends MobRenderer<TesterEntity, TesterModel<TesterEntity>> {

    public TesterRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new TesterModel<>(pContext.bakeLayer(TesterModel.LAYER_LOCATION)), 0.2f);
    }

    @Override
    public ResourceLocation getTextureLocation(TesterEntity testerEntity) {
        return ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "textures/entity/tester/test1.png");
    }

    @Override
    public void render(TesterEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            pPoseStack.scale(1f, 0.8f, 1f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
