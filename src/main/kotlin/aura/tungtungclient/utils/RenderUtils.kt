package aura.tungtungclient.utils

import net.minecraft.client.gui.GuiGraphics
import java.awt.Color

object RenderUtils {
  fun GuiGraphics.rect(x: Number, y: Number, width: Number, height: Number, color: Color) {
    this.fill(x.toInt(),y.toInt(), x.toInt() + width.toInt(), y.toInt() + height.toInt(), color.rgb)
  }
}