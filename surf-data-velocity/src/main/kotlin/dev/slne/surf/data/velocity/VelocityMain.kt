package dev.slne.surf.data.velocity

import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent
import dev.slne.surf.data.core.context.DataContext

class VelocityMain @Inject constructor() {
    init {
        DataContext.dataClassLoader = this::class.java.classLoader
    }

    @Subscribe
    fun onProxyInitialization(event: ProxyInitializeEvent) {

    }

    @Subscribe
    fun onProxyShutdown(event: ProxyShutdownEvent) {

    }
}