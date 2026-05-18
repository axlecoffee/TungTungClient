package aura.tungtungclient

import aura.tungtungclient.event.EventBus
import aura.tungtungclient.event.EventBus.register
import aura.tungtungclient.event.events.TickEvent
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.ModInitializer
import net.minecraft.client.Minecraft
import net.minecraft.network.chat.Component

class TungTungClient: ClientModInitializer {
  val mc = Minecraft.getInstance()

  var counter = 0

  override fun onInitializeClient() {
    TickEvent.Start.register {
      mc.gui.chat.addMessage(Component.literal(counter.toString()))
      counter++
      mc.player?.isCrouching == true
    }
  }
}
