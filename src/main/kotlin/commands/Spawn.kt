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
        val spawn = Main.instance.generalConfig.spawn
        if (!spawn.enabled) return

        val location = Util.spawnLoaction
        sender.teleport(location)

        if (!spawn.sendMessage) return

        spawn.messages.forEach {
            sender.sendMessage(Component.text(it))
        }
    }
}