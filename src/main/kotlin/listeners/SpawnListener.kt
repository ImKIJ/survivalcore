package net.furium.listeners

import net.furium.Main
import net.furium.utils.Util
import net.kyori.adventure.text.Component
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerRespawnEvent

class SpawnListener : Listener {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val options = Main.instance.generalConfig.spawn
        if(!options.enabled) return

        event.player.teleport(Util.spawnLoaction)
        if(!options.sendMessage) return

        options.messages.forEach {
            event.player.sendMessage(Component.text(it))
        }
    }

    @EventHandler
    fun onRespawnEvent(event: PlayerRespawnEvent) {
        if(!Main.instance.generalConfig.spawn.enabled) return;

        event.player.teleport(Util.spawnLoaction)
    }
}