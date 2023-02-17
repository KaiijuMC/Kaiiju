import io.papermc.paperweight.util.*
import io.papermc.paperweight.util.constants.*

plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.papermc.paperweight.patcher") version "1.5.1"
}

allprojects {
    apply(plugin = "java")

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }
}

val paperMavenPublicUrl = "https://repo.papermc.io/repository/maven-public/"

repositories {
    mavenCentral()
    maven(paperMavenPublicUrl) {
        content {
            onlyForConfigurations(PAPERCLIP_CONFIG)
        }
    }
}

dependencies {
    remapper("net.fabricmc:tiny-remapper:0.8.6:fat")
    decompiler("net.minecraftforge:forgeflower:2.0.605.1")
    paperclip("io.papermc:paperclip:3.0.2")
}

subprojects {
    tasks.withType<JavaCompile>().configureEach {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(17)
    }
    tasks.withType<Javadoc> {
        options.encoding = Charsets.UTF_8.name()
    }
    tasks.withType<ProcessResources> {
        filteringCharset = Charsets.UTF_8.name()
    }
    repositories {
        mavenCentral()
        maven(paperMavenPublicUrl)
        maven("https://jitpack.io")
    }
}

paperweight {
    serverProject.set(project(":kaiiju-server"))

    remapRepo.set(paperMavenPublicUrl)
    decompileRepo.set(paperMavenPublicUrl)

    useStandardUpstream("Purpur") {
        url.set(github("PurpurMC", "Purpur"))
        ref.set(providers.gradleProperty("purpurRef"))
        
        withStandardPatcher {
            baseName("Purpur")

            apiPatchDir.set(layout.projectDirectory.dir("patches/api"))
            apiOutputDir.set(layout.projectDirectory.dir("kaiiju-api"))

            serverPatchDir.set(layout.projectDirectory.dir("patches/server"))
            serverOutputDir.set(layout.projectDirectory.dir("kaiiju-server"))
        }
    }

    tasks.register("purpurRefLatest") {
        // Update the purpurRef in gradle.properties to be the latest commit.
        val tempDir = layout.cacheDir("purpurRefLatest");
        val file = "gradle.properties";
        
        doFirst {
            data class GithubCommit(
                    val sha: String
            )

            val purpurLatestCommitJson = layout.cache.resolve("purpurLatestCommit.json");
            download.get().download("https://api.github.com/repos/PurpurMC/Purpur/commits/ver/1.19.3", purpurLatestCommitJson);
            val purpurLatestCommit = gson.fromJson<paper.libs.com.google.gson.JsonObject>(purpurLatestCommitJson)["sha"].asString;

            copy {
                from(file)
                into(tempDir)
                filter { line: String ->
                    line.replace("purpurRef = .*".toRegex(), "purpurRef = $purpurLatestCommit")
                }
            }
        }

        doLast {
            copy {
                from(tempDir.file("gradle.properties"))
                into(project.file(file).parent)
            }
        }
    }
}

