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
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.entity.custom.ArmoredAlienEntity;

public class ArmoredAlienModel<T extends ArmoredAlienEntity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "armored_alien"), "main");
    private final ModelPart body;
    private final ModelPart head;

    public ArmoredAlienModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = this.body.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(142, 132).addBox(-2.0F, -13.625F, -1.5F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 24).addBox(-10.0F, -8.625F, -1.5F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.375F, -0.5F));

        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(112, 21).addBox(6.0F, -4.0F, -3.0F, 2.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 7.375F, 0.5F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 30).addBox(-9.0F, -3.0F, -2.0F, 19.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 3.375F, 0.5F, 0.0F, 0.0F, 1.5708F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.625F, 0.0F));

        PartDefinition headArmor = head.addOrReplaceChild("headArmor", CubeListBuilder.create().texOffs(52, 103).addBox(-6.0F, -7.0F, -9.5F, 12.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(104, 100).addBox(-6.0F, -7.0F, 7.0F, 12.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r3 = headArmor.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 76).addBox(-6.0F, -8.0F, 0.0F, 12.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -1.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r4 = headArmor.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(60, 71).addBox(-6.0F, -8.0F, 0.0F, 12.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, -1.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r5 = headArmor.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(52, 29).addBox(-8.0F, -7.0F, 0.0F, 16.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.0F, -1.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r6 = headArmor.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(48, 15).addBox(-8.0F, -7.0F, 0.0F, 16.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 0.0F, -1.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition eyeL = head.addOrReplaceChild("eyeL", CubeListBuilder.create().texOffs(158, 123).addBox(-1.5F, -2.5F, -0.5F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -1.5F, -6.5F));

        PartDefinition eyeR = head.addOrReplaceChild("eyeR", CubeListBuilder.create().texOffs(132, 158).addBox(-1.5F, -2.5F, -0.5F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -1.5F, -6.5F));

        PartDefinition upper = body.addOrReplaceChild("upper", CubeListBuilder.create().texOffs(108, 58).addBox(1.75F, -4.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(160, 72).addBox(-4.75F, 1.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(160, 74).addBox(-4.75F, 1.5F, -4.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(160, 89).addBox(1.75F, 1.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(160, 91).addBox(1.75F, 1.5F, -4.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(162, 6).addBox(1.75F, -2.5F, 3.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(162, 4).addBox(-4.75F, -2.5F, 3.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(162, 2).addBox(-4.75F, 1.5F, 3.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(162, 0).addBox(1.75F, 1.5F, 3.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 150).addBox(1.75F, 3.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(74, 129).addBox(2.75F, 3.5F, -3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(160, 162).addBox(-3.75F, 3.5F, 2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(128, 162).addBox(2.75F, 3.5F, 2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(74, 131).addBox(-3.75F, 3.5F, -3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 162).addBox(-3.75F, 3.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(160, 93).addBox(1.75F, -2.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(158, 129).addBox(1.75F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(160, 95).addBox(-4.75F, -2.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(158, 139).addBox(-5.75F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(74, 133).addBox(2.75F, -4.5F, -3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(62, 161).addBox(-3.75F, -4.5F, 2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 161).addBox(2.75F, -4.5F, 2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(154, 119).addBox(-3.75F, -4.5F, -3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(54, 161).addBox(-4.75F, -2.5F, -4.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(140, 161).addBox(1.75F, -2.5F, -4.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 32).addBox(0.75F, -0.5F, -5.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(156, 137).addBox(-5.75F, -0.5F, 4.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(156, 87).addBox(0.75F, -0.5F, 4.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(154, 70).addBox(-5.75F, -0.5F, -5.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(108, 162).addBox(-3.75F, -4.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.375F, 0.0F));

        PartDefinition cube_r7 = upper.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(132, 87).addBox(-9.0F, -1.5F, 0.75F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, -1.0F, -3.5F, 0.0F, 1.5708F, 3.1416F));

        PartDefinition cube_r8 = upper.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(142, 16).addBox(-8.0F, 0.5F, 0.75F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, -1.0F, -3.5F, 0.0F, 1.5708F, 3.1416F));

        PartDefinition cube_r9 = upper.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(152, 79).addBox(-7.0F, 2.5F, 0.75F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 7.0F, -3.5F, 0.0F, 1.5708F, 3.1416F));

        PartDefinition cube_r10 = upper.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(152, 77).addBox(-7.0F, 2.5F, 0.75F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 7.0F, -3.5F, 0.0F, 1.5708F, 3.1416F));

        PartDefinition cube_r11 = upper.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(142, 14).addBox(-8.0F, 0.5F, 0.75F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, 3.0F, -3.5F, 0.0F, 1.5708F, 3.1416F));

        PartDefinition cube_r12 = upper.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(86, 41).addBox(-8.0F, 0.5F, 0.75F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 3.0F, -3.5F, 0.0F, 1.5708F, 3.1416F));

        PartDefinition cube_r13 = upper.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(144, 75).addBox(-7.0F, 2.5F, 0.75F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.0F, -3.5F, 0.0F, 1.5708F, 3.1416F));

        PartDefinition cube_r14 = upper.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(30, 69).addBox(-8.0F, 0.5F, 0.75F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -1.0F, -3.5F, 0.0F, 1.5708F, 3.1416F));

        PartDefinition cube_r15 = upper.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(130, 19).addBox(-9.0F, -1.5F, 0.75F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -1.0F, -3.5F, 0.0F, 1.5708F, 3.1416F));

        PartDefinition cube_r16 = upper.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(142, 140).addBox(-7.0F, 2.5F, 0.75F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, -1.0F, -3.5F, 0.0F, 1.5708F, 3.1416F));

        PartDefinition upperArmor = upper.addOrReplaceChild("upperArmor", CubeListBuilder.create().texOffs(52, 43).addBox(4.0F, 6.0F, -6.0F, 3.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(154, 18).addBox(3.0F, 7.0F, -7.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(86, 70).addBox(3.0F, 6.0F, -6.0F, 1.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(154, 24).addBox(3.0F, 7.0F, 2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(98, 152).addBox(2.0F, 7.0F, -7.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(154, 115).addBox(-2.0F, 10.0F, -6.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(72, 150).addBox(-2.0F, 7.0F, -7.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(142, 7).addBox(-2.0F, 13.75F, -3.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(154, 108).addBox(-3.0F, 7.0F, -7.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(142, 103).addBox(-3.0F, 6.0F, -3.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(132, 77).addBox(2.0F, 9.0F, -2.0F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(160, 50).addBox(-2.0F, 9.0F, 2.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(122, 132).addBox(-3.0F, 9.0F, -2.0F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(138, 53).addBox(-3.0F, 9.0F, 2.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(30, 62).addBox(-3.0F, 7.0F, 2.0F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(154, 58).addBox(-4.0F, 7.0F, -7.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(86, 85).addBox(-4.0F, 6.0F, -6.0F, 1.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(154, 64).addBox(-4.0F, 7.0F, 2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(52, 57).addBox(-7.0F, 6.0F, -6.0F, 3.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 62).addBox(-7.0F, -6.0F, -7.0F, 14.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(30, 71).addBox(-7.0F, -6.0F, 6.0F, 14.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 37).addBox(7.0F, -6.0F, -6.0F, 1.0F, 13.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(96, 130).addBox(2.0F, 9.0F, 3.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(152, 35).addBox(-2.0F, 8.75F, 2.0F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(152, 154).addBox(-2.0F, 10.0F, 4.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(154, 30).addBox(-2.0F, 9.0F, 4.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(132, 148).addBox(-2.0F, 5.75F, -4.0F, 4.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 37).addBox(-8.0F, -6.0F, -6.0F, 1.0F, 13.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r17 = upperArmor.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(82, 60).addBox(-7.0F, -3.0F, -1.0F, 14.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.5F, 1.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r18 = upperArmor.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(24, 150).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 1.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r19 = upperArmor.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(48, 0).addBox(-7.0F, -5.0F, -1.0F, 14.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5F, 1.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition lower = body.addOrReplaceChild("lower", CubeListBuilder.create(), PartPose.offset(0.0F, 5.375F, 0.5F));

        PartDefinition armR = body.addOrReplaceChild("armR", CubeListBuilder.create().texOffs(46, 119).addBox(-2.0F, -0.75F, -1.5F, 4.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.75F, -8.625F, 0.0F));

        PartDefinition armRarmor = armR.addOrReplaceChild("armRarmor", CubeListBuilder.create().texOffs(142, 97).addBox(-2.75F, 8.375F, -2.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(86, 34).addBox(-1.75F, -6.625F, -2.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(126, 39).addBox(-2.75F, -5.625F, -2.5F, 1.0F, 14.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(56, 136).addBox(2.25F, -5.4306F, -3.0556F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 3.625F, 0.0F));

        PartDefinition cube_r20 = armRarmor.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(96, 115).addBox(-4.0F, -1.0F, -3.25F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.625F, 3.5F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r21 = armRarmor.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(66, 148).addBox(0.0F, -1.0F, -3.25F, 2.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.625F, -2.5F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r22 = armRarmor.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(86, 152).addBox(-1.0F, 12.0F, -3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(62, 117).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -3.625F, -2.5F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r23 = armRarmor.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 127).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 14.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(152, 81).addBox(-1.0F, 12.0F, -3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -3.625F, 3.5F, 0.0F, -1.5708F, 0.0F));

        PartDefinition handR = armR.addOrReplaceChild("handR", CubeListBuilder.create(), PartPose.offset(0.0F, 13.0F, -0.5F));

        PartDefinition cube_r24 = handR.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(82, 17).addBox(-2.0F, 7.2124F, -0.0817F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 80).addBox(1.0F, 7.2124F, -0.0817F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 76).addBox(-0.5F, 7.7468F, -2.0251F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(144, 58).addBox(-1.0F, -1.5951F, -1.0216F, 2.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4593F, -0.5524F, -0.3927F, 0.0F, 0.0F));

        PartDefinition armL = body.addOrReplaceChild("armL", CubeListBuilder.create().texOffs(122, 114).addBox(-2.0F, -0.75F, -2.5F, 4.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(10.75F, -8.625F, 0.0F));

        PartDefinition armLarmor = armL.addOrReplaceChild("armLarmor", CubeListBuilder.create().texOffs(132, 142).addBox(-3.5F, 5.0556F, -2.4444F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(142, 0).addBox(-2.5F, -9.9444F, -2.4444F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(132, 58).addBox(-3.5F, -8.9444F, -2.4444F, 1.0F, 14.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(114, 58).addBox(1.5F, -8.75F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 6.9444F, -0.0556F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r25 = armLarmor.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(12, 127).addBox(-4.0F, -1.0F, -3.25F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, -6.9444F, 3.5556F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r26 = armLarmor.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(116, 149).addBox(0.0F, -1.0F, -3.25F, 2.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, -6.9444F, -2.4444F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r27 = armLarmor.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(152, 148).addBox(-1.0F, 12.0F, -3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(130, 0).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -6.9444F, -2.4444F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r28 = armLarmor.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(130, 89).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 14.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(152, 142).addBox(-1.0F, 12.0F, -3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -6.9444F, 3.5556F, 0.0F, -1.5708F, 0.0F));

        PartDefinition handL = armL.addOrReplaceChild("handL", CubeListBuilder.create(), PartPose.offset(0.0F, 13.0F, -0.5F));

        PartDefinition cube_r29 = handL.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(82, 21).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.5F, -5.5F, -0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r30 = handL.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(82, 25).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(108, 0).addBox(-3.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 7.75F, -3.5F, -0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r31 = handL.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(144, 21).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.75F, 0.5F, -0.3927F, 0.0F, 0.0F));

        PartDefinition legR = body.addOrReplaceChild("legR", CubeListBuilder.create().texOffs(158, 53).addBox(-0.9286F, 19.2143F, -1.4286F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(84, 158).addBox(-0.9286F, 18.2143F, -1.4286F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(44, 135).addBox(0.5714F, -1.5357F, -2.9286F, 1.0F, 12.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(20, 117).addBox(-0.9286F, -2.5357F, -1.9286F, 2.0F, 21.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(86, 136).addBox(-1.6786F, -1.5357F, -1.9286F, 1.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 146).addBox(-1.9286F, -1.5357F, 2.0714F, 4.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(145, 148).addBox(-1.4286F, -1.5357F, -2.9286F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0714F, 14.1607F, -0.0714F));

        PartDefinition legRarmor = legR.addOrReplaceChild("legRarmor", CubeListBuilder.create().texOffs(12, 142).addBox(-1.9917F, -7.625F, 3.1248F, 4.0F, 13.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(112, 70).addBox(-1.9917F, -7.625F, -5.1252F, 4.0F, 13.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(104, 114).addBox(-2.9917F, -7.625F, -4.1252F, 1.0F, 13.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(138, 39).addBox(-1.9917F, 5.375F, -3.1252F, 1.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(140, 108).addBox(1.0083F, 5.375F, -3.1252F, 1.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(78, 115).addBox(2.0083F, -7.625F, -4.1252F, 1.0F, 13.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(140, 122).addBox(-1.8774F, -8.625F, -4.0681F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0631F, 5.8393F, -0.0533F));

        PartDefinition cube_r32 = legRarmor.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(0, 159).addBox(1.0F, 2.2143F, -2.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1226F, -10.8393F, -1.0681F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r33 = legRarmor.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(144, 72).addBox(-4.0243F, 2.2143F, -2.3071F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3726F, -11.8393F, -1.0681F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r34 = legRarmor.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(152, 158).addBox(0.0F, 2.2143F, -2.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1226F, -10.8393F, 3.9319F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r35 = legRarmor.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(46, 152).addBox(-0.5F, -6.5F, -2.0F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5083F, 11.875F, -3.6252F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r36 = legRarmor.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(152, 42).addBox(-0.5F, -4.0F, -1.5F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0083F, 9.375F, 3.3748F, 0.0F, 1.5708F, 0.0F));

        PartDefinition footR = legR.addOrReplaceChild("footR", CubeListBuilder.create().texOffs(144, 35).addBox(-3.0F, -1.0F, -6.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(108, 4).addBox(-6.0F, -2.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(52, 85).addBox(-5.0F, -1.0F, 2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(122, 162).addBox(-5.0F, -2.0F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(148, 162).addBox(-5.0F, -3.0F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 157).addBox(-6.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(140, 158).addBox(-3.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(108, 7).addBox(-3.0F, -2.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 142).addBox(-6.0F, -3.0F, -3.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(94, 159).addBox(-6.0F, -1.0F, -6.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(20, 108).addBox(-5.0F, -3.0F, -4.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0714F, 23.2143F, 0.5714F));

        PartDefinition footRarmor = footR.addOrReplaceChild("footRarmor", CubeListBuilder.create().texOffs(78, 100).addBox(1.0F, -3.0F, -7.0F, 1.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(26, 102).addBox(6.25F, -3.0F, -7.0F, 1.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(162, 11).addBox(4.75F, -2.0F, 6.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(162, 14).addBox(2.75F, -2.0F, 6.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(20, 163).addBox(2.75F, -3.0F, 7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 163).addBox(4.75F, -3.0F, 7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(74, 123).addBox(2.75F, -5.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(74, 126).addBox(4.75F, -5.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 163).addBox(2.75F, -5.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 163).addBox(4.75F, -5.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 163).addBox(2.75F, -6.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(162, 97).addBox(0.5F, -2.0F, -6.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(162, 100).addBox(0.5F, -2.0F, 2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(156, 132).addBox(0.5F, -2.0F, -3.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(40, 163).addBox(4.75F, -6.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.25F, 0.0F, 0.0F));

        PartDefinition cube_r37 = footRarmor.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(26, 157).addBox(-1.5F, -2.7678F, -0.6299F, 3.0F, 5.25F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.9822F, -1.5F, 5.6299F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r38 = footRarmor.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(18, 157).addBox(-3.0F, -5.25F, 3.0F, 3.0F, 5.25F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.0F, -11.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r39 = footRarmor.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(26, 85).addBox(-1.0F, -4.5F, -7.0F, 1.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.25F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r40 = footRarmor.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(82, 43).addBox(-1.0F, -4.5F, -7.0F, 1.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.25F, -4.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition legL = body.addOrReplaceChild("legL", CubeListBuilder.create().texOffs(158, 119).addBox(-0.9286F, 19.2143F, -1.4286F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(122, 158).addBox(-0.9286F, 18.2143F, -1.4286F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(96, 135).addBox(1.0714F, -1.7857F, -2.9286F, 1.0F, 12.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(32, 117).addBox(-0.9286F, -2.5357F, -1.9286F, 2.0F, 21.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(122, 142).addBox(-1.9286F, -1.5357F, -1.9286F, 1.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(56, 148).addBox(-1.9286F, -1.5357F, 2.0714F, 4.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(108, 149).addBox(-1.9286F, -1.5357F, -2.9286F, 3.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1143F, 14.1607F, 0.0571F, 0.0F, 3.1416F, 0.0F));

        PartDefinition legLarmor = legL.addOrReplaceChild("legLarmor", CubeListBuilder.create().texOffs(126, 21).addBox(-2.1143F, -1.7857F, 0.1929F, 4.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 108).addBox(-2.1143F, -1.7857F, -5.0571F, 4.0F, 13.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(108, 34).addBox(-3.1143F, -1.7857F, -4.0571F, 1.0F, 13.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(108, 135).addBox(-2.1143F, 11.2143F, -3.0571F, 1.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(72, 136).addBox(0.8857F, 11.2143F, -3.0571F, 1.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(112, 0).addBox(1.8857F, -1.7857F, -3.5571F, 1.0F, 13.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(112, 89).addBox(-2.0F, -2.7857F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.25F, 0.0F, 0.0F));

        PartDefinition cube_r41 = legLarmor.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(72, 156).addBox(0.0F, 2.2143F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -5.0F, -1.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r42 = legLarmor.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(108, 55).addBox(-4.0243F, 2.2143F, -2.3071F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.25F, -6.0F, -1.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r43 = legLarmor.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(156, 103).addBox(0.0F, 2.2143F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -5.0F, 4.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r44 = legLarmor.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(38, 152).addBox(-0.5F, -6.5F, -2.0F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3857F, 17.7143F, -3.5571F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r45 = legLarmor.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(78, 88).addBox(-0.5F, -6.5F, -2.0F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3857F, 17.7143F, 3.4429F, 0.0F, 1.5708F, 0.0F));

        PartDefinition footL = legL.addOrReplaceChild("footL", CubeListBuilder.create().texOffs(160, 42).addBox(1.0F, 0.2273F, -5.3636F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(108, 10).addBox(-2.0F, -0.7727F, 2.6364F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(72, 160).addBox(-1.0F, 0.2273F, 2.6364F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(154, 162).addBox(-1.0F, -0.7727F, 2.6364F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(162, 158).addBox(-1.0F, -1.7727F, 2.6364F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 159).addBox(-2.0F, -0.7727F, -3.3636F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(80, 160).addBox(1.0F, -0.7727F, -3.3636F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(108, 13).addBox(1.0F, -0.7727F, 2.6364F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(142, 89).addBox(-2.0F, -1.7727F, -2.3636F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(160, 46).addBox(-2.0F, 0.2273F, -5.3636F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(20, 112).addBox(-1.0F, -1.7727F, -3.3636F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0714F, 21.987F, -0.0649F, 0.0F, 3.1416F, 0.0F));

        PartDefinition footLarmor = footL.addOrReplaceChild("footLarmor", CubeListBuilder.create().texOffs(52, 88).addBox(-3.1857F, -1.7727F, -6.4922F, 1.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 93).addBox(2.0643F, -1.7727F, -6.4922F, 1.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(102, 159).addBox(0.5643F, -0.7727F, 6.5078F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(162, 8).addBox(-1.4357F, -0.7727F, 6.5078F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(162, 160).addBox(-1.4357F, -1.7727F, 7.5078F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 163).addBox(0.5643F, -1.7727F, 7.5078F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(74, 117).addBox(-1.4357F, -3.7727F, 5.5078F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(74, 120).addBox(0.5643F, -3.7727F, 5.5078F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 163).addBox(-1.4357F, -3.7727F, -5.4922F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 163).addBox(0.5643F, -3.7727F, -5.4922F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 163).addBox(-1.4357F, -4.7727F, -6.4922F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 163).addBox(0.5643F, -4.7727F, -6.4922F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(80, 162).addBox(2.5643F, -0.7727F, -5.4922F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(130, 108).addBox(2.5643F, -0.7727F, -2.4922F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(86, 162).addBox(2.5643F, -0.7727F, 2.5078F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r46 = footLarmor.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(10, 157).addBox(-1.5F, -2.7678F, -0.6299F, 3.0F, 5.25F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2036F, -0.2727F, 6.1376F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r47 = footLarmor.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(44, 30).addBox(-3.0F, -5.25F, 3.0F, 3.0F, 5.25F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6857F, 1.2273F, -10.4922F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r48 = footLarmor.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(86, 17).addBox(-1.0F, -4.5F, -7.0F, 1.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0643F, 1.2273F, 0.5078F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r49 = footLarmor.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(82, 0).addBox(-1.0F, -4.5F, -7.0F, 1.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0643F, -2.7727F, 0.5078F, 0.0F, 0.0F, -1.5708F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void setupAnim(ArmoredAlienEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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
        //head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return body;
    }

}
