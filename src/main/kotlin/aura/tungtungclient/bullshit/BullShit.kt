package aura.tungtungclient.bullshit

import aura.tungtungclient.utils.StringUtils.spaceCaps
import kotlin.reflect.jvm.jvmName

open class BullShit(val description: String) {
  val name = this::class.simpleName.toString().spaceCaps()
  val settings = mutableListOf<Setting<*>>()

//  val settings = mutableListOf<>()
}