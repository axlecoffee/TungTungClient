package mixin;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static aura.tungtungclient.TungTungClientKt.mc;

@Mixin(Screen.class)
public class ScreenMixin {
    @Inject(method = "renderPanorama", at = @At("HEAD"), cancellable = true)
    private static void renderPanorama(GuiGraphics guiGraphics, float partialTick, CallbackInfo ci) {
        ci.cancel();
//        assert Minecraft.getInstance().screen != null;
        int screenWidth = mc.screen.width;
        int screenHeight = mc.screen.height;
        ResourceLocation image = ResourceLocation.fromNamespaceAndPath("tungtungclient", "textures/img.png");
        guiGraphics.blit(image, 0, 0, screenWidth, screenHeight, 0f, 1f, 0f, 1f);
    }

    @Inject(method = "addRenderableWidget", at = @At(value = "HEAD"), cancellable = true)
    private <T extends GuiEventListener & Renderable & NarratableEntry> void hideCopyrightText(T widget, CallbackInfoReturnable<T> cir) {

        if (widget instanceof PlainTextButton button) {
            if (button.getMessage().getString().startsWith("Copyright")) {
                cir.setReturnValue(widget);
                cir.cancel();
            }
        }
//        if (guiEventListener instanceof PlainTextButton button) {
//            if (button.getMessage().getString().startsWith("COP")) return null;
//        }
//        if (instance instanceof PlainTextButton) return
    }
}
