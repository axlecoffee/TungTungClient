package aura.tungtungclient

import aura.tungtungclient.event.EventBus
import aura.tungtungclient.event.EventBus.register
import aura.tungtungclient.event.events.HudEvent
import aura.tungtungclient.event.events.TickEvent
import aura.tungtungclient.utils.RenderUtils
import aura.tungtungclient.utils.RenderUtils.rect
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.ModInitializer
import net.minecraft.client.Minecraft
import net.minecraft.network.chat.Component
import java.awt.Color

class TungTungClient: ClientModInitializer {
  val mc = Minecraft.getInstance()

  var counter = 0

  override fun onInitializeClient() {
//    TickEvent.Start.register {
//      mc.player?.isCrouching == true
//    }

    EventBus.register<TickEvent.Start> {
//      mc.gui.chat.addMessage(Component.literal(counter.toString()))
//      counter++
    }
    EventBus.register<HudEvent> {
//      mc.gui.chat.addMessage(Component.literal(counter.toString()))

      event.context.drawString(mc.font, "aaa", 10, 10, Color.WHITE.rgb)

      event.context.rect(10, 10, 10, 10, Color.WHITE)
    }
  }
}
