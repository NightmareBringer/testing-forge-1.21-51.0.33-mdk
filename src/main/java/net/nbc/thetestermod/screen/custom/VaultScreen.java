package net.nbc.thetestermod.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.entity.custom.CodeVaultBlockEntity;
import org.jetbrains.annotations.Nullable;


public class VaultScreen extends AbstractContainerScreen<VaultMenu> {
    // Store the entered numbers
    private String enteredCode = "";
    private boolean codeCorrect = true;
    public boolean editMode = false;

    private static final ResourceLocation GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID,"textures/gui/vault/vault_gui.png");

    public VaultScreen(VaultMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    private void onNumberPressed(int number) {
        VaultMenu menu = this.menu;
        enteredCode += number;
        menu.broadcastChanges();
        menu.clickMenuButton(getMinecraft().player, number);
    }

    @Override
    protected void init() {
        super.init();
        int buttonWidth = 40;
        int buttonHeight = 20;
        int padding = 5;
        int gridWidth = buttonWidth * 3 + padding * 2;      // Based on amount of columns
        int gridHeight = buttonHeight * 4 + padding * 3;    // Based on amount of rows
        int startX = (this.width - gridWidth) / 2;
        int startY = (this.height - gridHeight) / 2;

        // Numbers 1–9
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                int number = y * 3 + x + 1;
                this.addRenderableWidget(Button.builder(
                                Component.literal(String.valueOf(number)),
                                (button) -> onNumberPressed(number))
                        .pos(startX + x * (buttonWidth + padding), startY + y * (buttonHeight + padding))
                        .size(buttonWidth, buttonHeight)
                        .build());
            }
        }

        // 0 button (centered in bottom row of numbers)
        this.addRenderableWidget(Button.builder(
                        Component.literal("0"),
                        (button) -> onNumberPressed(0))
                .pos(startX + buttonWidth + padding, startY + 3 * (buttonHeight + padding))
                .size(buttonWidth, buttonHeight)
                .build());

        // Enter button
        this.addRenderableWidget(Button.builder(
                        Component.literal("Enter"),
                        (button) -> {
                            VaultMenu menu = (VaultMenu) this.menu;
                            CodeVaultBlockEntity be = menu.getBlockEntity();

                            if (enteredCode.equals(be.getCode())) {
                                be.unlock();
                                System.out.println("Correct!");
                                //removeConnectedWalls(be.getBlockPos(), level);
                                codeCorrect = true;

                                this.onClose();
                            } else {
                                System.out.println("Incorrect!");
                                codeCorrect = false;
                            }
                            enteredCode = "";
                        })
                .pos(this.width / 2 - 50, startY + gridHeight + 10)
                .size(100, buttonHeight)
                .build());

        // Close button
        this.addRenderableWidget(Button.builder(
                        Component.literal("Close"),
                        (button) -> this.onClose())
                .pos(this.width / 2 - 50, startY + gridHeight + 35)
                .size(100, buttonHeight)
                .build());
    }

    @Override
    public void render(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(guiGraphics, pMouseX, pMouseY, pPartialTick);
        super.render(guiGraphics, pMouseX, pMouseY, pPartialTick);

        // Draw the title
        guiGraphics.drawCenteredString(this.font, this.title, this.width / 2, 20, 0xFFFFFFFF);

        // Show entered code
        guiGraphics.drawCenteredString(this.font, "Code: " + enteredCode, this.width / 2, 35, 0xFFFFFF00);

        if (!codeCorrect && enteredCode == "") {
            guiGraphics.drawCenteredString(this.font, "Incorrect code!", this.width / 2, 50, 0xFF0000);
        }
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {

    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {

    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

}
