package aura.tungtungclient.event

import aura.tungtungclient.event.events.Priority

data class EventState(val action: () -> Any?, val priority: Priority, val runIf: () -> Boolean = {true})
