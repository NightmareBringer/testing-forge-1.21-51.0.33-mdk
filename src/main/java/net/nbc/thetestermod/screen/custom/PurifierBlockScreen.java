package net.nbc.thetestermod.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.nbc.thetestermod.TesterMod;

public class PurifierBlockScreen extends AbstractContainerScreen<PurifierBlockMenu> {
    private static final ResourceLocation GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID,"textures/gui/purifier_block/purifier_block_gui.png");
    private static final ResourceLocation ARROW_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID,"textures/gui/arrow_progress.png");
    private static final ResourceLocation FLAME_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "textures/gui/purifier_progress.png");

    public PurifierBlockScreen(PurifierBlockMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        int x = (width - imageWidth) / 2;
        int y = ((height - imageHeight) / 2) - 9;

        pGuiGraphics.blit(GUI_TEXTURE, x, y, 0, 0, 176, 175, 256,256);

        renderProgressArrow(pGuiGraphics, x, y);
        renderBurnIcon(pGuiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(ARROW_TEXTURE,x + 73, y + 35+9, 0, 0, menu.getScaledArrowProgress(), 16, 24, 16);
        }
    }

    private void renderBurnIcon(GuiGraphics guiGraphics, int x, int y) {
        if (menu.isBurning()) {
            int burnHeight = menu.getBurnProgress();
            int textureHeight = 44;
            int textureWidth = 40;

            // anchor so it grows upward
            int burnX = x + 42;
            int burnY = (y - 4) + (textureHeight - burnHeight);

            guiGraphics.blit(FLAME_TEXTURE,
                    burnX, burnY+17,
                    0, (textureHeight - burnHeight),
                    textureWidth, burnHeight,
                    textureWidth, textureHeight);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, this.title, 8, -2, 4210752, false);
        guiGraphics.drawString(this.font, this.playerInventoryTitle, 8, this.imageHeight - 94, 4210752, false);
    }
}
