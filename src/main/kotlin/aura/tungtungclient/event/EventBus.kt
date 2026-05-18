package aura.tungtungclient.event

import aura.tungtungclient.event.events.HudEvent
import com.ibm.icu.lang.UCharacter.GraphemeClusterBreak.T
import kotlin.jvm.java
import kotlin.reflect.KClass

object EventBus {
  // took some inspiration from @noamm9
  class EventContext<T: Event>(val event: T, val listener: Listener<T>)
  data class Listener<T: Event>(val clazz: Class<out Event>, val priority: Priority, val runIf: () -> Boolean, val action: EventContext<T>.() -> Any?)

  val listeners = mutableMapOf<Class<out Event>, MutableSet<Listener<*>>>()

  @JvmStatic
  fun Event.post(): Boolean {
    var shouldCancel = this.scheduleCancel
    val suitableEvents = listeners[this::class.java] ?: return false

    suitableEvents.sortedBy { it.priority.ordinal }.filter { it.runIf() }.forEach {
      // go figure why the ide is screaming at this
      val action = it.action as EventContext<Event>.() -> Any?
      val result = action.invoke(EventContext(this, it as Listener<Event>))

      if (this.cancellable && result as? Boolean == true) shouldCancel = true
    }
    return shouldCancel
  }

  inline fun <reified T: Event>register(
    priority: Priority = Priority.NORMAL,
    noinline runIf: () -> Boolean = { true },
    noinline action: EventContext<T>.() -> Any?
  ) {
    listeners.getOrPut(T::class.java) { emptySet<Listener<*>>().toMutableSet()}.add(Listener(T::class.java, priority, runIf, action))
  }
}