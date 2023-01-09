pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://papermc.io/repo/repository/maven-public/")
    }
}

rootProject.name = "Kaiiju"

include("Kaiiju-API", "Kaiiju-Server")
