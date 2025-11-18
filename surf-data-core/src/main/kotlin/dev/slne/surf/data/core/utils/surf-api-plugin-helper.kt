package dev.slne.surf.data.core.utils

fun retrieveSurfApiPluginClassLoader(): ClassLoader {
    val javaPluginClass = Class.forName("org.bukkit.plugin.java.JavaPlugin")
    val getPluginMethod = javaPluginClass.getDeclaredMethod("getProvidingPlugin", Class::class.java)
    val surfApiBukkitApiClass = Class.forName("dev.slne.surf.surfapi.core.api.messages.Colors")
    val pluginInstance = getPluginMethod.invoke(null, surfApiBukkitApiClass)
    val getClassLoaderMethod = javaPluginClass.getDeclaredMethod("getClassLoader")
    getClassLoaderMethod.isAccessible = true
    val classLoaderInstance = getClassLoaderMethod.invoke(pluginInstance)

    return classLoaderInstance as ClassLoader
}