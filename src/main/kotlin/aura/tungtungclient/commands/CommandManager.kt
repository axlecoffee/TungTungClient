package aura.tungtungclient.commands

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback

object CommandManager {
  val commands = mutableSetOf<BaseCommand>()

  fun registerAll() {
    ClientCommandRegistrationCallback.EVENT.register { dispatcher, _ ->
      commands.forEach {
        it.names.map { name -> ClientCommandManager.literal(name) to name}.forEach { (root, name) ->
          CommandBuilder(root).apply { with(it) { build() } }
          dispatcher.register(root)
        }
      }
    }
  }
}