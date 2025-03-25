package net.nbc.thetestermod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.entity.ModEntities;
import net.nbc.thetestermod.entity.custom.TesterEntity;

public class TesterModel<T extends TesterEntity> extends HierarchicalModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "tester_mob"), "main");
    private final ModelPart body;
    private final ModelPart head;
   // private final ModelPart armL;
    //private final ModelPart armR;
    //private final ModelPart legL;
    //private final ModelPart legR;

    public TesterModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = this.body.getChild("head");
        //this.armL = this.body.getChild("armL");
        //this.armR = this.body.getChild("armR");
        //this.legL = this.body.getChild("legL");
        //this.legR = this.body.getChild("legR");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -8.0F, -0.5F, 4.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.5F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, 0.0F));

        PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(10, 0).addBox(-3.0F, -6.0F, -1.5F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        PartDefinition armL = body.addOrReplaceChild("armL", CubeListBuilder.create().texOffs(14, 9).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -7.5F, 0.0F));

        PartDefinition armR = body.addOrReplaceChild("armR", CubeListBuilder.create().texOffs(10, 9).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -7.5F, 0.0F));

        PartDefinition legL = body.addOrReplaceChild("legL", CubeListBuilder.create().texOffs(4, 17).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 8.0F, 0.0F));

        PartDefinition legR = body.addOrReplaceChild("legR", CubeListBuilder.create().texOffs(0, 17).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 8.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(TesterEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(TesterAnimations.WALK, limbSwing, limbSwingAmount, 2f, 0.5f);

        this.animate(entity.idleAnimationState, TesterAnimations.IDLE, ageInTicks, 1f);

        this.animate(entity.attackAnimationState, TesterAnimations.ATTACK, ageInTicks, 1f);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0f);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0f);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        //armL.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
       // armR.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        //legL.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        //legR.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        //head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return body;
    }
}
