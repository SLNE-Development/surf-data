package dev.slne.surf.data.core.utils

import java.net.URL
import java.nio.ByteBuffer
import java.util.*
import kotlin.math.max
import kotlin.math.min

class JoinClassLoader(
    parent: ClassLoader,
    private vararg val delegate: ClassLoader,
) : ClassLoader(parent) {
    override fun findClass(name: String): Class<*>? {
        val path = name.replace(".", "/") + ".class"
        val url = findResource(path) ?: throw ClassNotFoundException(name)

        // try with resources
        val byteCode = runCatching { loadResource(url) }
            .getOrElse { throw ClassNotFoundException(name) }

        return defineClass(name, byteCode, null)
    }

    override fun findResource(name: String): URL? {
        for (loader in delegate) {
            val resource = loader.getResource(name)

            if (resource != null) {
                return resource
            }
        }

        return null
    }

    override fun findResources(name: String): Enumeration<URL?>? {
        val vector = Vector<URL>()

        for (loader in delegate) {
            val resources = loader.getResources(name)

            while (resources.hasMoreElements()) {
                vector.add(resources.nextElement())
            }
        }

        return vector.elements()
    }

    private fun loadResource(url: URL): ByteBuffer {
        val inputStream = url.openStream()
        var initialBufferCapacity = min(0x40000, inputStream.available() + 1)

        if (initialBufferCapacity <= 2) {
            initialBufferCapacity = 0x10000
        } else {
            initialBufferCapacity = max(initialBufferCapacity, 0x200)
        }

        var buffer = ByteBuffer.allocate(initialBufferCapacity)

        while (true) {
            if (!buffer.hasRemaining()) {
                val newBuf = ByteBuffer.allocate(buffer.capacity() * 2)

                buffer.flip()
                newBuf.put(buffer)
                buffer = newBuf
            }

            val length = inputStream.read(buffer.array(), buffer.position(), buffer.remaining())

            if (length <= 0) {
                break
            }

            buffer.position(buffer.position() + length)
        }

        buffer.flip()

        return buffer
    }
}