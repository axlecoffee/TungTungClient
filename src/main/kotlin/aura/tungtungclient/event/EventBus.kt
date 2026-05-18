package aura.tungtungclient.event

object EventBus {
  val events = mutableMapOf<Event, () -> Unit>()

  fun Event.post() {
    this.events.forEach {
      it.invoke()
    }
  }
}