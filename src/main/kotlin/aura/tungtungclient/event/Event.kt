package aura.tungtungclient.event

import aura.tungtungclient.event.events.Priority

open class Event(val cancellable: Boolean) {
  var scheduleCancel = false
  val events = mutableSetOf<EventState>()
}