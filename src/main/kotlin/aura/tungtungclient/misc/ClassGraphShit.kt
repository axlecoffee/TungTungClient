package aura.tungtungclient.misc

import aura.tungtungclient.TungTungClient
import aura.tungtungclient.bullshit.BullShit
import aura.tungtungclient.bullshit.BullShitManager
import aura.tungtungclient.commands.BaseCommand
import aura.tungtungclient.commands.CommandManager
import aura.tungtungclient.event.Event
import io.github.classgraph.ClassGraph
import kotlin.reflect.KClass
import kotlin.reflect.cast
import kotlin.to

object ClassGraphShit {
  private data class ClassAction<T: Any>(val clazz: KClass<T>, val action: (T) -> Unit) {
    fun invoke(obj: Any) {
      @Suppress("UNCHECKED_CAST")
      action(obj as T)
    }
  }
  private val classActions = setOf<ClassAction<*>>(
    ClassAction(BaseCommand::class) { command ->
      CommandManager.commands.add(command)
    },
    ClassAction(BullShit::class) { bullshit ->
      BullShitManager.bullshits.add(bullshit)
    }
  )

  fun initialize() {
    val classes = ClassGraph()
      .enableAllInfo()
      .acceptPackages(TungTungClient::class.java.`package`.name)
      .overrideClassLoaders(Thread.currentThread().contextClassLoader)
      .scan()

    classes.use {
      classActions.forEach { classAction ->
        val clazz = classAction.clazz
        it.getSubclasses(clazz.qualifiedName).forEach { info ->
          runCatching { clazz.cast(info.loadClass().getDeclaredField("INSTANCE").get(null)) }.getOrNull()?.let { obj -> classAction.invoke(obj) }
        }
      }
    }
  }
}