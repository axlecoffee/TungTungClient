package mixin;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.SplashRenderer;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SplashRenderer.class)
public class SplashRendererMixin {
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void render(GuiGraphics guiGraphics, int width, Font font, float fade, CallbackInfo ci) {
        ci.cancel();
    }
}
