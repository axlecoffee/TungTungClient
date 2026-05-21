package aura.tungtungclient.utils

object StringUtils {
  fun String.spaceCaps(): String {
    if (this.isEmpty()) return this
    return this[0] + this.substring(1)
      .replace(Regex("(?<=[a-z])(?=[A-Z])"), " ")
      .trim()
  }
}