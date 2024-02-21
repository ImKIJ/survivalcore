package net.furium.utils

import net.furium.Main
import net.furium.config.configs.General
import org.bukkit.Location

object Util {
    var spawnLoaction: Location
        get() {
            val location = Main.instance.generalConfig.spawn.location
            return Location(
                Main.instance.server.getWorld(location.world),
                location.x,
                location.y,
                location.z,
                location.yaw,
                location.pitch
            )
        }
        set(value) {
            val location = Main.instance.generalConfig.spawn.location

            location.x = value.x
            location.y = value.y
            location.z = value.z
            location.yaw = value.yaw
            location.pitch = value.pitch
            location.world = value.world!!.name
        }
}