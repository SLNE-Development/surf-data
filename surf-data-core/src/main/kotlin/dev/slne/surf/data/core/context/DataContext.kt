package dev.slne.surf.data.core.context

import org.springframework.context.ConfigurableApplicationContext
import java.nio.file.Path
import kotlin.properties.Delegates

object DataContext {
    private var initialized by Delegates.notNull<Boolean>()

    lateinit var dataPath: Path
        private set

    lateinit var dataClassLoader: ClassLoader
        private set

    fun initialize(path: Path, classLoader: ClassLoader) {
        if (this::dataPath.isInitialized) {
            throw IllegalStateException("DataContext is already initialized")
        }

        dataPath = path
        dataClassLoader = classLoader

        initialized = true
    }
}

inline fun <reified B : Any> ConfigurableApplicationContext.getBean(): B =
    this.getBean(B::class.java)