package aura.tungtungclient.event.events

import aura.tungtungclient.event.Event
import net.minecraft.client.DeltaTracker
import net.minecraft.client.gui.GuiGraphics

class HudEvent(val context: GuiGraphics, val deltaTracker: DeltaTracker): Event() {}