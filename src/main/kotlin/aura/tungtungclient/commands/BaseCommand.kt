package aura.tungtungclient.commands

abstract class BaseCommand(vararg val names: String) {
  abstract fun CommandBuilder.build()
}