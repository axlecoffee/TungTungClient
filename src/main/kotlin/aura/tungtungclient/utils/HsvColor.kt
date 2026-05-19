package aura.tungtungclient.utils

import kotlinx.serialization.Serializable
import java.awt.Color
import kotlin.math.abs

// from old days sigma client first or second attempt on 1.21
@Serializable
data class HsvColor(val h: Float, val s: Float, val v: Float, val alpha: Int = 255) {
  init {
    if (h !in 0f..360f) throw error("Hue is not in the correct range")
    if (s !in 0f..100f) throw error("Saturation is not in the correct range")
    if (v !in 0f..100f) throw error("Value is not in the correct range")
  }

  fun toColor(): Color {
    val h = this.h
    val s = this.s / 100f
    val v = this.v / 100f

    val c = v * s
    val x = c * (1f - abs((h / 60f) % 2f - 1f))
    val m = v - c

    val (r, g, b) = when (h) {
      in 0f..60f -> Triple(c, x, 0f)
      in 60f..120f -> Triple(x, c, 0f)
      in 120f..180f -> Triple(0f, c, x)
      in 180f..240f -> Triple(0f, x, c)
      in 240f..300f -> Triple(x, 0f, c)
      else -> Triple(c, 0f, x)
    }

    val finalR = ((r + m) * 255).toInt()
    val finalG = ((g + m) * 255).toInt()
    val finalB = ((b + m) * 255).toInt()

    return Color(finalR, finalG, finalB, alpha)
  }
}