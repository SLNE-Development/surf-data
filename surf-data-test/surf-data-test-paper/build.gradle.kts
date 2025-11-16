import dev.slne.surf.surfapi.gradle.util.registerRequired

plugins {
    id("dev.slne.surf.surfapi.gradle.paper-plugin")
}

dependencies {
    compileOnly(project(":surf-data-core"))
}

surfPaperPluginApi {
    mainClass("dev.slne.surf.data.test.paper.PaperMain")
    generateLibraryLoader(false)

    authors.add("Ammo")

    serverDependencies {
        registerRequired("surf-data-paper")
    }

    runServer {
        dependsOn(":surf-data-paper:shadowJar")
        pluginJars.from(project(":surf-data-paper").tasks.shadowJar)

        minecraftVersion("1.21.10")
    }
}