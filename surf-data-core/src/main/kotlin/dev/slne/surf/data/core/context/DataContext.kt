package dev.slne.surf.data.core.context

import org.springframework.context.ConfigurableApplicationContext
import java.nio.file.Path

object DataContext {
    lateinit var dataPath: Path
    lateinit var dataClassLoader: ClassLoader
    lateinit var context: ConfigurableApplicationContext

    @Deprecated("", level = DeprecationLevel.ERROR)
    inline fun <reified B : Any> ConfigurableApplicationContext.getBean(): B =
        context.getBean(B::class.java)
}

@Deprecated("", level = DeprecationLevel.ERROR)
inline fun <reified B : Any> getBean(): B =
    DataContext.context.getBean(B::class.java)