package net.furium.commands

import net.furium.Main
import net.furium.utils.Util
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player
import revxrsal.commands.annotation.Command
import revxrsal.commands.annotation.DefaultFor

@Command("spawn")
class Spawn {

    @DefaultFor("~")
    fun spawn(sender: Player) {
        if (Main.instance.generalConfig.spawn.enabled) {
            val location = Util().getSpawnLocation()
            sender.teleport(location)
            if (Main.instance.generalConfig.spawn.sendMessage) {
                for (message in Main.instance.generalConfig.spawn.messages) {
                    sender.sendMessage(Component.text(message))
                }
            }
        } else {
            sender.sendMessage(Component.text("<red>Spawn is not enabled!"))
        }
    }
}