package aura.tungtungclient.commands.impl

import aura.tungtungclient.commands.BaseCommand
import aura.tungtungclient.commands.CommandBuilder
import aura.tungtungclient.mc
import net.minecraft.network.chat.Component

object TestCommand: BaseCommand("testCommand", "testingCommand") {
  override fun CommandBuilder.build() {
    runs {
      mc.gui.chat.addMessage(Component.literal("fuck axle"))
    }
    literal("cancer") {
      runs {
        mc.gui.chat.addMessage(Component.literal("fuck axle"))
      }
    }
  }
}