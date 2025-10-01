package net.nbc.thetestermod.screen.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.item.ModItems;
import net.nbc.thetestermod.packets.custom.CodeEnteredPayload;
import net.neoforged.neoforge.network.PacketDistributor;


public class VaultScreen extends AbstractContainerScreen<VaultMenu> {
    // Store the entered numbers
    private String enteredCode = "";
    private boolean codeCorrect = true;
    private String feedbackMessage = "";

    private static final ResourceLocation GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID,"textures/gui/vault/vault_gui.png");

    public VaultScreen(VaultMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
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
                                (button) -> { feedbackMessage = ""; enteredCode += number; })
                        .pos(startX + x * (buttonWidth + padding), startY + y * (buttonHeight + padding))
                        .size(buttonWidth, buttonHeight)
                        .build());
            }
        }

        // 0 button (centered in bottom row of numbers)
        this.addRenderableWidget(Button.builder(
                        Component.literal("0"),
                        (button) -> { feedbackMessage = ""; enteredCode += "0"; })
                .pos(startX + buttonWidth + padding, startY + 3 * (buttonHeight + padding))
                .size(buttonWidth, buttonHeight)
                .build());

        // Enter button
        this.addRenderableWidget(Button.builder(
                        Component.literal("Enter"),
                        (button) -> handleEnterPressed())
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

    private void handleEnterPressed() {
        feedbackMessage = ""; // reset

        if (enteredCode.isEmpty()) {
            feedbackMessage = "Code must be at least 1 number!";
            codeCorrect = false;
        } else if (enteredCode.length() > 10) {
            feedbackMessage = "Code mustn't be over 10 numbers!";
            codeCorrect = false;
        } else {
            boolean hasKey = Minecraft.getInstance().player.getMainHandItem().is(ModItems.STEELICHROME_KEYS.get())
                    || Minecraft.getInstance().player.getOffhandItem().is(ModItems.STEELICHROME_KEYS.get());

            // Send intent to server
            PacketDistributor.sendToServer(
                    new CodeEnteredPayload(menu.getBlockEntity().getBlockPos(), enteredCode, hasKey)
            );

            // Guess result locally
            codeCorrect = hasKey ||
                    enteredCode.equals(menu.getBlockEntity().getCurrentCode());

            if (codeCorrect) {
                this.onClose();
            } else {
                feedbackMessage = "Incorrect code!";
            }
        }

        enteredCode = "";
    }

    @Override
    public void render(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(guiGraphics, pMouseX, pMouseY, pPartialTick);
        super.render(guiGraphics, pMouseX, pMouseY, pPartialTick);

        // Draw the title
        guiGraphics.drawCenteredString(this.font, this.title, this.width / 2, 20, 0xFFFFFFFF);

        // Show entered code
        guiGraphics.drawCenteredString(this.font, "Code: " + enteredCode, this.width / 2, 35, 0xFFFFFF00);

        if (!feedbackMessage.isEmpty()) {
            int color = 0xFF0000; // red
            guiGraphics.drawCenteredString(this.font, feedbackMessage, this.width / 2, 50, color);
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
