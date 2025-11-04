package dev.slne.surf.data.core

import dev.slne.surf.data.core.context.DataContext
import dev.slne.surf.data.core.utils.JoinClassLoader
import org.springframework.boot.Banner
import org.springframework.boot.WebApplicationType
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.core.io.DefaultResourceLoader
import kotlin.reflect.KClass

class DataSpringApplication {
    companion object {
        fun start(
            source: KClass<*>,
            primaryClassLoader: ClassLoader,
            vararg classLoaders: ClassLoader,
        ): ConfigurableApplicationContext {
            val originalClassLoader = Thread.currentThread().contextClassLoader
            Thread.currentThread().contextClassLoader = primaryClassLoader

            val finalClassLoaders = mutableListOf<ClassLoader>().apply {
                add(DataContext.dataClassLoader)
                add(primaryClassLoader)
                addAll(classLoaders)
            }

            val builder = SpringApplicationBuilder(source.java).apply {
                resourceLoader(
                    DefaultResourceLoader(
                        JoinClassLoader(
                            parent = primaryClassLoader,
                            delegate = finalClassLoaders.toTypedArray()
                        )
                    )
                )

                bannerMode(Banner.Mode.OFF)
                web(WebApplicationType.NONE)
                logStartupInfo(false)
            }

            Thread.currentThread().contextClassLoader = originalClassLoader

            return builder.run()
        }
    }
}