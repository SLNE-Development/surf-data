package dev.slne.surf.data.core

import dev.slne.surf.data.core.context.DataContext
import dev.slne.surf.data.core.utils.JoinClassLoader
import dev.slne.surf.surfapi.core.api.util.logger
import org.springframework.boot.Banner
import org.springframework.boot.WebApplicationType
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.core.io.DefaultResourceLoader

class DataSpringApplication {
    companion object {
        private val log = logger()

        @JvmStatic
        fun start(
            source: Class<*>,
            primaryClassLoader: ClassLoader,
            vararg pluginClassLoaders: ClassLoader,
        ): ConfigurableApplicationContext {
            val delegateLoaders = mutableListOf<ClassLoader>().apply {
                add(DataContext.dataClassLoader)
                add(primaryClassLoader)
                addAll(pluginClassLoaders)
            }

            val joined = JoinClassLoader(
                parent = primaryClassLoader,
                delegate = delegateLoaders.toTypedArray()
            )

            val originalClassLoader = Thread.currentThread().contextClassLoader
            Thread.currentThread().contextClassLoader = primaryClassLoader

            try {
                return SpringApplicationBuilder(source)
                    .resourceLoader(DefaultResourceLoader(joined))
                    .bannerMode(Banner.Mode.OFF)
                    .web(WebApplicationType.NONE)
                    .logStartupInfo(false)
                    .run()
            } catch (exception: Exception) {
                log.atSevere()
                    .withCause(exception)
                    .log("Failed to start DataSpringApplication of source ${source.name}")

                Thread.currentThread().contextClassLoader = originalClassLoader
            } finally {
                Thread.currentThread().contextClassLoader = originalClassLoader
            }

            throw IllegalStateException("Unreachable code reached in DataSpringApplication.start")
        }
    }
}