package dev.slne.surf.data.test.paper

import com.github.shynixn.mccoroutine.folia.SuspendingJavaPlugin
import dev.slne.surf.data.core.DataSpringApplication
import dev.slne.surf.data.core.utils.retrieveSurfApiPluginClassLoader
import dev.slne.surf.data.test.paper.commands.ticketCommand
import org.bukkit.plugin.java.JavaPlugin
import org.springframework.context.ConfigurableApplicationContext

class PaperMain : SuspendingJavaPlugin() {
    lateinit var context: ConfigurableApplicationContext
        private set

    override suspend fun onLoadAsync() {
        context = DataSpringApplication.start(
            TestApplication::class.java,
            classLoader,
            retrieveSurfApiPluginClassLoader()
        )
    }

    override suspend fun onEnableAsync() {
        ticketCommand()
    }

    override suspend fun onDisableAsync() {

    }
}

val plugin get() = JavaPlugin.getPlugin(PaperMain::class.java)