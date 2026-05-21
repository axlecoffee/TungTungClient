package aura.tungtungclient

import aura.tungtungclient.bullshit.visual.ArrayList
import aura.tungtungclient.commands.CommandManager
import aura.tungtungclient.event.EventBus
import aura.tungtungclient.event.EventBus.register
import aura.tungtungclient.event.events.HudEvent
import aura.tungtungclient.event.events.TickEvent
import aura.tungtungclient.misc.ClassGraphShit
import aura.tungtungclient.utils.RenderUtils
import aura.tungtungclient.utils.RenderUtils.rect
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents
import net.fabricmc.fabric.mixin.client.rendering.WorldRendererMixin
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.LevelRenderer
import net.minecraft.client.renderer.RenderType
import net.minecraft.client.renderer.entity.EntityRenderDispatcher
import net.minecraft.client.renderer.entity.layers.RenderLayer
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.Entity
import net.minecraft.world.level.pathfinder.Path
import java.awt.Color

@JvmField
val mc = Minecraft.getInstance()
class TungTungClient: ClientModInitializer {

  var counter = 0

  override fun onInitializeClient() {
    ClassGraphShit.initialize()
    CommandManager.registerAll()
    ArrayList.initialize()
  }
}
