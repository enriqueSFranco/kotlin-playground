package org.tempest.algorithms.leetcode

class Solution {
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
}