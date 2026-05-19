package aura.tungtungclient.bullshit.visual

import aura.tungtungclient.event.EventBus
import aura.tungtungclient.event.events.HudEvent
import aura.tungtungclient.mc
import aura.tungtungclient.utils.HsvColor
import com.google.common.graph.ElementOrder.sorted

object ArrayList {
  fun initialize() {
    EventBus.register<HudEvent> {
      val features = setOf<String>(
        "Aura",
        "Bennis Aura",
        "Axle vs not ratting",
        "Sigma skid/ai allegations",
        "atowos aura"
      ).sortedByDescending { mc.font.width(it) }
      val hueStep = 360f / features.size * 0.3f

      features.forEachIndexed { index, feature ->
        val currentHue = ((360 - (hueStep * index.toFloat()).coerceIn(0f..360f)) + (System.currentTimeMillis() % 3000) / 3000f * 360f) % 360f
        val color = HsvColor(currentHue, 100f, 100f)

        event.context.drawString(mc.font, feature, 10, 10 + index * 10, color.toColor().rgb)
      }

    }
  }
}