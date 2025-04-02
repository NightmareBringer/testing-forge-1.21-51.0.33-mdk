package net.nbc.thetestermod.entity.client;// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.entity.custom.ThrowingKnifeProjectileEntity;

public class ThrowingKnifeProjectileModel extends EntityModel<ThrowingKnifeProjectileEntity> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "throwing_knife"), "main");
	private final ModelPart throwing_knife;

	public ThrowingKnifeProjectileModel(ModelPart root) {
		this.throwing_knife = root.getChild("throwing_knife");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition knife = partdefinition.addOrReplaceChild("throwing_knife", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 1.5F, -1.5F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(12, 1).addBox(-0.5F, -2.5F, -1.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(8, 9).addBox(-0.5F, -4.5F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 7).addBox(-0.5F, -6.5F, 0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 16.5F, 0.5F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(ThrowingKnifeProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		throwing_knife.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}

}