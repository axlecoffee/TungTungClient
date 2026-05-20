package aura.tungtungclient

import aura.tungtungclient.bullshit.visual.ArrayList
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

@JvmField
val mc = Minecraft.getInstance()
class TungTungClient: ClientModInitializer {

  var counter = 0

  override fun onInitializeClient() {
    ArrayList.initialize()
  }
}
