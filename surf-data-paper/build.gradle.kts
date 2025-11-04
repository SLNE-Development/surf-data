plugins {
    id("dev.slne.surf.surfapi.gradle.paper-plugin")
}

dependencies {
    api(project(":surf-data-core"))
}

surfPaperPluginApi {
    mainClass("dev.slne.surf.data.paper.PaperMain")
    generateLibraryLoader(false)

    authors.add("Ammo")

    runServer {
        minecraftVersion("1.21.10")
    }
}