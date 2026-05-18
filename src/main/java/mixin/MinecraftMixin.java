package mixin;

import aura.tungtungclient.event.EventBus;
import aura.tungtungclient.event.events.TickEvent;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    void onStartTick(CallbackInfo ci) {
        if (EventBus.post(TickEvent.Start.INSTANCE)) ci.cancel();
    }
}
