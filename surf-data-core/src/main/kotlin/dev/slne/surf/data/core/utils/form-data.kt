package dev.slne.surf.data.core.utils

import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap

fun formData(block: MultiValueMap<String, String>.() -> Unit) = LinkedMultiValueMap<String, String>().apply {
    block()
}