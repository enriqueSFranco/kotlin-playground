package org.tempest.dataStructure

import kotlin.collections.isNotEmpty
import kotlin.collections.joinToString
import kotlin.text.isEmpty
import kotlin.text.isNotBlank
import kotlin.text.split

fun simplifyPath(path: String): String {
    var stack = mutableListOf<String>()
    val pathArray = path.split("/")

    for (dir in pathArray) {
        if (stack.isNotEmpty() && dir == "..") {
            stack.removeLast()
        }
        if (dir.isNotBlank() && dir != "." && dir != "..") {
            stack.add(dir)
        }
    }
    val result = "/" + stack.joinToString("/")

    return if (result.isEmpty()) "/" else result
}