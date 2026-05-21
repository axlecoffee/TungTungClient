package aura.tungtungclient.commands

import com.mojang.brigadier.Command
import com.mojang.brigadier.arguments.ArgumentType
import com.mojang.brigadier.builder.ArgumentBuilder
import com.mojang.brigadier.builder.RequiredArgumentBuilder
import com.mojang.brigadier.context.CommandContext
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource
import net.minecraft.commands.SharedSuggestionProvider

// Credit goes to @noamm9, I couldnt have figure this shit out my self ngl (fuck mincraft commands)
class CommandBuilder(private val builder: ArgumentBuilder<FabricClientCommandSource, *>) {
  fun literal(name: String, block: CommandBuilder.() -> Unit) {
    val subNode = ClientCommandManager.literal(name)
    CommandBuilder(subNode).apply(block)
    builder.then(subNode)
  }
  fun runs(block: (CommandContext<FabricClientCommandSource>) -> Unit) {
    builder.executes { context ->
      block(context)
      Command.SINGLE_SUCCESS
    }
  }

  fun <T: Any>argument(name: String, type: ArgumentType<T>, block: CommandBuilder.() -> Unit) {
    val argumentNode = ClientCommandManager.argument(name, type)
    CommandBuilder(argumentNode).apply(block)
    builder.then(argumentNode)
  }

  fun suggests(strings: () -> Iterable<String>) {
    if (builder is RequiredArgumentBuilder<*, *>) {
      (builder as RequiredArgumentBuilder<FabricClientCommandSource, *>).suggests { _, suggestionsBuilder ->
        SharedSuggestionProvider.suggest(strings(), suggestionsBuilder)
      }
    }
  }
}