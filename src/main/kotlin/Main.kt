package net.furium

import net.furium.commands.ReloadConfig
import net.furium.commands.SetSpawnCommand
import net.furium.commands.Spawn
import net.furium.config.ConfigManager
import net.furium.config.configs.General
import net.furium.listeners.SpawnListener
import org.bukkit.plugin.java.JavaPlugin
import revxrsal.commands.bukkit.BukkitCommandHandler


class Main : JavaPlugin() {
    companion object {
        lateinit var instance: Main
    }

    lateinit var configManager: ConfigManager
    lateinit var generalConfig: General
    override fun onEnable() {
        try {
            instance = this
            configManager = ConfigManager()
            generalConfig = configManager.loadConfig("general", General::class.java)!!
            configManager.saveConfig("general", generalConfig, General::class.java)
            val handler = BukkitCommandHandler.create(this)
            handler.register(SetSpawnCommand(), ReloadConfig(), Spawn())
            this.server.pluginManager.registerEvents(SpawnListener(), this)
            this.logger.info("Hello, plugin initiated!")
        } catch(e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDisable() {
        this.logger.info("Goodbye, plugin terminated!")
    }
}