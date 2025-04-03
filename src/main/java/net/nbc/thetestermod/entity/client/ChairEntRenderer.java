package net.nbc.thetestermod.entity.client;

import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.nbc.thetestermod.entity.custom.ChairEntity;

public class ChairEntRenderer extends EntityRenderer<ChairEntity> {
    public ChairEntRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(ChairEntity chairEntity) {
        return null;
    }

    @Override
    public boolean shouldRender(ChairEntity pLivingEntity, Frustum pCamera, double pCamX, double pCamY, double pCamZ) {
        return true;
    }
}
