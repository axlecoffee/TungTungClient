package aura.tungtungclient.event

open class Event(cancellable: Boolean) {
  val events = mutableSetOf<() -> Any>()
}