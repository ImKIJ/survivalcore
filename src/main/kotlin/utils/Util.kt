package net.furium.utils

import net.furium.Main
import org.bukkit.Location

class Util {
    fun getSpawnLocation(): Location {
        val location = Main.instance.generalConfig.spawn.location
        val world = Main.instance.server.getWorld(location.world)
        return Location(world, location.x, location.y, location.z, location.yaw, location.pitch)
    }
}