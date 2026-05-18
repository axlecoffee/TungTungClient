package aura.tungtungclient.event

abstract class Event(val cancellable: Boolean = false) {
  var scheduleCancel = false
  val events = mutableSetOf<EventState>()

  fun cancel() {
    scheduleCancel = true
  }
}