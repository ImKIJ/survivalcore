import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

plugins {
    kotlin("jvm") version "1.9.22"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "net.furium"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://jitpack.io/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
    implementation("com.github.Revxrsal.Lamp:common:3.1.9")
    implementation("com.github.Revxrsal.Lamp:bukkit:3.1.9")
    compileOnly("org.spongepowered:configurate-yaml:4.0.0")
}

tasks.test {
    useJUnitPlatform()
}
tasks.jar {
    from(configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") })
    archiveBaseName.set("survivalcore")
    archiveVersion.set("1.0.0")
    destinationDirectory.set(file("D:\\Furium\\Survival\\plugins"))
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-parameters")
}

tasks.withType<KotlinJvmCompile> {
    compilerOptions {
        javaParameters = true
    }
}

kotlin {
    jvmToolchain(17)
}

tasks.shadowJar {
    configurations = listOf(project.configurations.runtimeClasspath.get())
    archiveBaseName.set("survivalcore")
    archiveVersion.set("1.0.0")
    destinationDirectory.set(file("D:\\Furium\\Survival\\plugins"))

    // Relocate packages
    relocate("com.github.Revxrsal.Lamp", "net.furium.shadowed.Lamp")
    relocate("gg.flyte.twilight", "net.furium.shadowed.twilight")
}