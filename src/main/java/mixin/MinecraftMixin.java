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
    @Inject(method = "tick", at = @At("HEAD"))
    void onStartTick(CallbackInfo ci) {
        EventBus.post(TickEvent.Start.INSTANCE);
    }
    @Inject(method = "tick", at = @At("TAIL"))
    void onEndTick(CallbackInfo ci) {
        EventBus.post(TickEvent.End.INSTANCE);
    }
}
