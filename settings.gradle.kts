pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.fabricmc.net/")
        maven("https://maven.architectury.dev")
        maven("https://maven.minecraftforge.net")
        maven("https://maven.neoforged.net/releases/")
        maven("https://maven.kikugie.dev/snapshots")
    }
}

plugins {
    id("dev.kikugie.stonecutter") version "0.5.1"
}

stonecutter {
    centralScript = "build.gradle.kts"
    kotlinController = true
    create(rootProject) {
        // Root `src/` functions as the 'common' project
        versions("1.20.1", "1.20.4", "1.20.6", "1.21.3")
        branch("fabric") { versions("1.20.1", "1.21.3") }
        branch("forge") { versions("1.20.1") }
        branch("neoforge") { versions("1.20.4", "1.20.6", "1.21.3") }
    }
}

rootProject.name = "puncher"