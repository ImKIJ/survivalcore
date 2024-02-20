package net.furium.config

import net.furium.Main
import org.spongepowered.configurate.CommentedConfigurationNode
import org.spongepowered.configurate.ConfigurateException
import org.spongepowered.configurate.ConfigurationNode
import org.spongepowered.configurate.yaml.YamlConfigurationLoader
import java.nio.file.Paths
import java.util.logging.Level

class ConfigManager {
    private var configs: MutableMap<String, YamlConfigurationLoader> = HashMap()
    private var nodes: MutableMap<String, ConfigurationNode> = HashMap()
    fun <T : Any> loadConfig(name: String, type: Class<T>): T? {
        val path = Paths.get(Main.instance.dataFolder.absolutePath, "$name.yml")
        val loader = YamlConfigurationLoader.builder()
            .path(path)
            .defaultOptions { options -> options.shouldCopyDefaults(true) }
            .build()
        val root: CommentedConfigurationNode
        try {
            root = loader.load()
            configs[name] = loader
            nodes[name] = root
            Main.instance.logger.info("Loaded config $name.yml")
            return root.get(type) as T
        } catch (e: ConfigurateException) {
            Main.instance.logger.log(Level.SEVERE, "Failed to load config $name.yml")
            e.printStackTrace()
            return null;
        }
    }

    fun <T : Any> saveConfig(name: String, data: T, type: Class<T>) {
        val loader = configs[name] ?: return
        val node = nodes[name] ?: return
        try {
            node.set(type, data)
            loader.save(node)
            Main.instance.logger.info("Saved config $name.yml")
        } catch (e: ConfigurateException) {
            Main.instance.logger.log(Level.SEVERE, "Failed to save config $name.yml")
            return
        }
    }
}