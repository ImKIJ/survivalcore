package net.furium.commands

import net.furium.Main
import net.furium.config.configs.General
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player
import revxrsal.commands.annotation.Command
import revxrsal.commands.annotation.DefaultFor
import revxrsal.commands.bukkit.annotation.CommandPermission

@Command("reloadconfig")
class ReloadConfig {

    @DefaultFor("~")
    @CommandPermission("core.config.reload")
    fun reloadConfig(sender: Player) {
        Main.instance.generalConfig = Main.instance.configManager.loadConfig("general", General::class.java)!!
        sender.sendMessage(Component.text("<green>Config reloaded!"))
    }
}