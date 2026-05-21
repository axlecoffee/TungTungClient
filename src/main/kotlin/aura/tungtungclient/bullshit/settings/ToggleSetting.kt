package aura.tungtungclient.bullshit.settings

import aura.tungtungclient.bullshit.Setting
import com.mojang.brigadier.Command

class ToggleSetting(name: String): Setting<Boolean>(name, false) {
}