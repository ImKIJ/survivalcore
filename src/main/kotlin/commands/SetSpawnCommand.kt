package net.furium.commands

import net.furium.Main
import net.furium.config.configs.General
import net.furium.utils.Util
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
        val senderLocation = sender.location

        Main.instance.generalConfig.spawn.enabled = true
        Util.spawnLoaction = senderLocation
        Main.instance.configManager.saveConfig("general", Main.instance.generalConfig, General::class.java)

        sender.sendMessage(Component.text("<green>Spawn location set!"))
    }
}