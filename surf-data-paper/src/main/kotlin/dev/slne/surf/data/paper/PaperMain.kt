package dev.slne.surf.data.paper

import com.github.shynixn.mccoroutine.folia.SuspendingJavaPlugin
import dev.slne.surf.data.core.context.DataContext
import org.bukkit.plugin.java.JavaPlugin

class PaperMain : SuspendingJavaPlugin() {
    override suspend fun onLoadAsync() {
        DataContext.initialize(dataPath, classLoader)
    }

    override suspend fun onEnableAsync() {

    }

    override suspend fun onDisableAsync() {

    }
}

val plugin get() = JavaPlugin.getPlugin(PaperMain::class.java)