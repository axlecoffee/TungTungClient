package aura.tungtungclient.event

import aura.tungtungclient.event.events.Priority

object EventBus {
  @JvmStatic
  fun Event.post(): Boolean {
    var shouldCancel = this.scheduleCancel
    this.events.sortedBy { it.priority.ordinal }.filter { it.runIf() }.forEach {
      if (it.action.invoke() as? Boolean == true && this.cancellable) shouldCancel = true
    }
    return shouldCancel
  }

  fun Event.register(priority: Priority = Priority.NORMAL, runIf: () -> Boolean = { true }, action: () -> Any?) {
    this.events.add(EventState(action, priority, runIf))
  }
}