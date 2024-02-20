package net.furium.config.configs

import org.spongepowered.configurate.objectmapping.ConfigSerializable

@ConfigSerializable
class General {
    var spawn = SpawnSection()
}

@ConfigSerializable
class SpawnSection {
    var enabled = false
    var sendMessage = false
    var messages: List<String> = ArrayList()
    var location: LocationSection = LocationSection()
}

@ConfigSerializable
class LocationSection {
    var world: String = ""
    var x: Double = 0.0
    var y: Double = 0.0
    var z: Double = 0.0
    var pitch: Float = 0.0f
    var yaw: Float = 0.0f
}