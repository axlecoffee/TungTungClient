package mixin;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.LogoRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LogoRenderer.class)
public class LogoRendererMixin {
    @Inject(method = "renderLogo(Lnet/minecraft/client/gui/GuiGraphics;IF)V", at = @At("HEAD"), cancellable = true)
    private void renderLogo(GuiGraphics guiGraphics, int screenWidth, float transparency, CallbackInfo ci) {
        ci.cancel();
    }
}
