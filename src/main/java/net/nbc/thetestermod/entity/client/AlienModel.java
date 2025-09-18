package net.nbc.thetestermod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.entity.custom.AlienEntity;

public class AlienModel<T extends AlienEntity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "alien"), "main");
    private final ModelPart head;
    private final ModelPart body;

    public AlienModel(ModelPart root) {
        this.head = root.getChild("head");
        this.body = root.getChild("body");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -30.0F, -0.5F));

        PartDefinition eyeL = head.addOrReplaceChild("eyeL", CubeListBuilder.create().texOffs(70, 43).addBox(-1.5F, -2.5F, -0.5F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -1.5F, -6.5F));

        PartDefinition eyeR = head.addOrReplaceChild("eyeR", CubeListBuilder.create().texOffs(70, 57).addBox(-1.5F, -2.5F, -0.5F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -1.5F, -6.5F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(52, 65).addBox(-2.0F, -13.625F, -1.5F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 24).addBox(-10.0F, -8.625F, -1.5F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.375F, -0.5F));

        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(60, 16).addBox(6.0F, -4.0F, -3.0F, 2.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 7.375F, 0.5F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 30).addBox(-9.0F, -3.0F, -2.0F, 19.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 3.375F, 0.5F, 0.0F, 0.0F, 1.5708F));

        PartDefinition upper = body.addOrReplaceChild("upper", CubeListBuilder.create().texOffs(16, 78).addBox(1.75F, -4.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 75).addBox(-4.75F, 1.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 75).addBox(-4.75F, 1.5F, -4.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 75).addBox(1.75F, 1.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 76).addBox(1.75F, 1.5F, -4.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(50, 77).addBox(1.75F, -2.5F, 3.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 77).addBox(-4.75F, -2.5F, 3.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 77).addBox(-4.75F, 1.5F, 3.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 77).addBox(1.75F, 1.5F, 3.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 78).addBox(1.75F, 3.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(54, 75).addBox(2.75F, 3.5F, -3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 80).addBox(-3.75F, 3.5F, 2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(80, 10).addBox(2.75F, 3.5F, 2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 79).addBox(-3.75F, 3.5F, -3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 78).addBox(-3.75F, 3.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 76).addBox(1.75F, -2.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 73).addBox(1.75F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 76).addBox(-4.75F, -2.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(48, 73).addBox(-5.75F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 79).addBox(2.75F, -4.5F, -3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(80, 8).addBox(-3.75F, -4.5F, 2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(80, 6).addBox(2.75F, -4.5F, 2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(50, 79).addBox(-3.75F, -4.5F, -3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(76, 52).addBox(-4.75F, -2.5F, -4.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(76, 54).addBox(1.75F, -2.5F, -4.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(70, 12).addBox(0.75F, -0.5F, -5.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 71).addBox(-5.75F, -0.5F, 4.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(70, 63).addBox(0.75F, -0.5F, 4.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(70, 14).addBox(-5.75F, -0.5F, -5.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(78, 43).addBox(-3.75F, -4.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.375F, 0.0F));

        PartDefinition cube_r3 = upper.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(52, 55).addBox(-9.0F, -1.5F, 0.75F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, -1.0F, -3.5F, 0.0F, 1.5708F, 3.1416F));

        PartDefinition cube_r4 = upper.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(60, 50).addBox(-8.0F, 0.5F, 0.75F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, -1.0F, -3.5F, 0.0F, 1.5708F, 3.1416F));

        PartDefinition cube_r5 = upper.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(70, 2).addBox(-7.0F, 2.5F, 0.75F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 7.0F, -3.5F, 0.0F, 1.5708F, 3.1416F));

        PartDefinition cube_r6 = upper.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(70, 0).addBox(-7.0F, 2.5F, 0.75F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 7.0F, -3.5F, 0.0F, 1.5708F, 3.1416F));

        PartDefinition cube_r7 = upper.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(60, 31).addBox(-8.0F, 0.5F, 0.75F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, 3.0F, -3.5F, 0.0F, 1.5708F, 3.1416F));

        PartDefinition cube_r8 = upper.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(60, 29).addBox(-8.0F, 0.5F, 0.75F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 3.0F, -3.5F, 0.0F, 1.5708F, 3.1416F));

        PartDefinition cube_r9 = upper.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(68, 33).addBox(-7.0F, 2.5F, 0.75F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.0F, -3.5F, 0.0F, 1.5708F, 3.1416F));

        PartDefinition cube_r10 = upper.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(60, 27).addBox(-8.0F, 0.5F, 0.75F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -1.0F, -3.5F, 0.0F, 1.5708F, 3.1416F));

        PartDefinition cube_r11 = upper.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(44, 34).addBox(-9.0F, -1.5F, 0.75F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -1.0F, -3.5F, 0.0F, 1.5708F, 3.1416F));

        PartDefinition cube_r12 = upper.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(60, 52).addBox(-7.0F, 2.5F, 0.75F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, -1.0F, -3.5F, 0.0F, 1.5708F, 3.1416F));

        PartDefinition lower = body.addOrReplaceChild("lower", CubeListBuilder.create(), PartPose.offset(0.0F, 5.375F, 0.5F));

        PartDefinition armR = body.addOrReplaceChild("armR", CubeListBuilder.create().texOffs(24, 37).addBox(-2.0F, -0.75F, -2.5F, 4.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.75F, -8.625F, 0.0F));

        PartDefinition handR = armR.addOrReplaceChild("handR", CubeListBuilder.create(), PartPose.offset(0.0F, 13.0F, -0.5F));

        PartDefinition cube_r13 = handR.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(38, 67).addBox(-2.0F, 7.2124F, -0.0817F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 63).addBox(1.0F, 7.2124F, -0.0817F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 30).addBox(-0.5F, 7.7468F, -2.0251F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 62).addBox(-1.0F, -1.5951F, -1.0216F, 2.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4593F, -0.5524F, -0.3927F, 0.0F, 0.0F));

        PartDefinition armL = body.addOrReplaceChild("armL", CubeListBuilder.create().texOffs(42, 37).addBox(-2.0F, -0.75F, -2.5F, 4.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(10.75F, -8.625F, 0.0F));

        PartDefinition handL = armL.addOrReplaceChild("handL", CubeListBuilder.create(), PartPose.offset(0.0F, 13.0F, -0.5F));

        PartDefinition cube_r14 = handL.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(78, 45).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.5F, -5.5F, -0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r15 = handL.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(78, 56).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 78).addBox(-3.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 7.75F, -3.5F, -0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r16 = handL.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(60, 36).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.75F, 0.5F, -0.3927F, 0.0F, 0.0F));

        PartDefinition legR = body.addOrReplaceChild("legR", CubeListBuilder.create().texOffs(70, 35).addBox(-0.9286F, 19.2143F, -1.4286F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(70, 39).addBox(-0.9286F, 18.2143F, -1.4286F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(48, 17).addBox(1.0714F, -1.7857F, -2.9286F, 1.0F, 12.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 37).addBox(-0.9286F, -2.7857F, -1.9286F, 2.0F, 21.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(60, 0).addBox(-1.9286F, -1.7857F, -1.9286F, 1.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(10, 62).addBox(-1.9286F, -1.7857F, 2.0714F, 4.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(30, 63).addBox(-1.9286F, -1.7857F, -2.9286F, 3.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0714F, 14.1607F, -0.0714F));

        PartDefinition footR = legR.addOrReplaceChild("footR", CubeListBuilder.create().texOffs(58, 73).addBox(-3.0F, -1.0F, -6.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(6, 79).addBox(-6.0F, -2.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(74, 69).addBox(-5.0F, -1.0F, 2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(78, 60).addBox(-5.0F, -2.0F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(68, 78).addBox(-5.0F, -3.0F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(54, 79).addBox(-6.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(58, 79).addBox(-3.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 79).addBox(-3.0F, -2.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(52, 57).addBox(-6.0F, -3.0F, -3.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(74, 16).addBox(-6.0F, -1.0F, -6.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(74, 76).addBox(-5.0F, -3.0F, -4.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0714F, 23.2143F, 0.5714F));

        PartDefinition legL = body.addOrReplaceChild("legL", CubeListBuilder.create().texOffs(70, 4).addBox(-0.9286F, 19.2143F, -1.4286F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(70, 8).addBox(-0.9286F, 18.2143F, -1.4286F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(48, 0).addBox(1.0714F, -1.7857F, -2.9286F, 1.0F, 12.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(12, 37).addBox(-0.9286F, -2.7857F, -1.9286F, 2.0F, 21.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(42, 55).addBox(-1.9286F, -1.7857F, -1.9286F, 1.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(20, 63).addBox(-1.9286F, -1.7857F, 2.0714F, 4.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 65).addBox(-1.9286F, -1.7857F, -2.9286F, 3.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1143F, 14.1607F, 0.0571F, 0.0F, 3.1416F, 0.0F));

        PartDefinition footL = legL.addOrReplaceChild("footL", CubeListBuilder.create().texOffs(74, 20).addBox(1.0F, 0.2273F, -5.3636F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(34, 79).addBox(-2.0F, -0.7727F, 2.6364F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(74, 24).addBox(-1.0F, 0.2273F, 2.6364F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(58, 77).addBox(-1.0F, -0.7727F, 2.6364F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 78).addBox(-1.0F, -1.7727F, 2.6364F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 80).addBox(-2.0F, -0.7727F, -3.3636F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(80, 4).addBox(1.0F, -0.7727F, -3.3636F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 79).addBox(1.0F, -0.7727F, 2.6364F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 55).addBox(-2.0F, -1.7727F, -2.3636F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(74, 65).addBox(-2.0F, 0.2273F, -5.3636F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(74, 72).addBox(-1.0F, -1.7727F, -3.3636F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0714F, 21.987F, -0.0649F, 0.0F, 3.1416F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(AlienEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(AlienAnimations.WALK, limbSwing, limbSwingAmount, 2f, 1.0f);

        this.animate(entity.idleAnimationState, AlienAnimations.IDLE, ageInTicks, 1f);

        this.animate(entity.attackAnimationState, AlienAnimations.ATTACK, ageInTicks, 1f);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0f);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0f);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return body;
    }

}
