package net.furium.commands

import net.furium.Main
import net.furium.config.configs.General
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player
import revxrsal.commands.annotation.Command
import revxrsal.commands.annotation.DefaultFor
import revxrsal.commands.bukkit.annotation.CommandPermission


@Command("setspawn")
class SetSpawnCommand {
    @DefaultFor("~")
    @CommandPermission("core.spawn.set")
    fun setSpawn(sender: Player) {
        val location = sender.location
        Main.instance.generalConfig.spawn.location.x = location.x
        Main.instance.generalConfig.spawn.location.y = location.y
        Main.instance.generalConfig.spawn.location.z = location.z
        Main.instance.generalConfig.spawn.location.yaw = location.yaw
        Main.instance.generalConfig.spawn.location.pitch = location.pitch
        Main.instance.generalConfig.spawn.location.world = location.world!!.name
        Main.instance.generalConfig.spawn.enabled = true
        Main.instance.configManager.saveConfig("general", Main.instance.generalConfig, General::class.java)
        sender.sendMessage(Component.text("<green>Spawn location set!"))
    }
}