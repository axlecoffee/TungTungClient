package aura.tungtungclient.event

data class EventState(val action: (Event) -> Any?, val priority: Priority, val runIf: () -> Boolean = {true})
