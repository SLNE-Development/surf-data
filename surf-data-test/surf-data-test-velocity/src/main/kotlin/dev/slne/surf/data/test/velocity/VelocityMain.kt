package dev.slne.surf.data.test.velocity

import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent
import com.velocitypowered.api.plugin.annotation.DataDirectory
import dev.slne.surf.data.core.context.DataContext
import java.nio.file.Path

class VelocityMain @Inject constructor(@param:DataDirectory val path: Path) {
    init {
        DataContext.dataPath = path
        DataContext.dataClassLoader = this::class.java.classLoader
    }

    @Subscribe
    fun onProxyInitialization(event: ProxyInitializeEvent) {

    }

    @Subscribe
    fun onProxyShutdown(event: ProxyShutdownEvent) {

    }
}