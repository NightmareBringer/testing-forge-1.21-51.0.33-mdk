package net.nbc.thetestermod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.entity.custom.ThrowingKnifeProjectileEntity;

public class ThrowingKnifeProjectileRenderer extends EntityRenderer<ThrowingKnifeProjectileEntity> {
    private ThrowingKnifeProjectileModel model;

    public ThrowingKnifeProjectileRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new ThrowingKnifeProjectileModel(pContext.bakeLayer(ThrowingKnifeProjectileModel.LAYER_LOCATION));
    }

    @Override
    public void render(ThrowingKnifeProjectileEntity pEntity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();

        if(!pEntity.isGrounded()) {
            // Interpolate yaw and pitch for smooth movement
            float interpolatedYaw = Mth.lerp(partialTicks, pEntity.yRotO, pEntity.getYRot());
            float interpolatedPitch = Mth.lerp(partialTicks, pEntity.xRotO, pEntity.getXRot());

            // **Fix: Adjust the initial orientation correctly**
            poseStack.mulPose(Axis.YP.rotationDegrees(interpolatedYaw));
            poseStack.mulPose(Axis.XP.rotationDegrees(-interpolatedPitch - 90)); // Align blade FORWARD

            poseStack.translate(0, -1.0f, 0);
        } else {
            // Use grounded offsets for correct embedding
            poseStack.mulPose(Axis.YP.rotationDegrees(pEntity.groundedOffset.y));
            poseStack.mulPose(Axis.XP.rotationDegrees(pEntity.groundedOffset.x));
            poseStack.translate(0, -1.0f, 0);
        }

        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(
                buffer, this.model.renderType(this.getTextureLocation(pEntity)),false, false);
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(pEntity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(ThrowingKnifeProjectileEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "textures/entity/throwing_knife/throwing_knife.png");
    }
}
