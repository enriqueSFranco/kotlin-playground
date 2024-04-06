package org.tempest.algorithms.leetcode

data class Node(val value: String, var prev: Node? = null, var next: Node? = null)

class BrowserHistory(homepage: String) {
    private var currentPage: Node? = Node(homepage)

    fun visit(url: String) {
        currentPage?.next = Node(url, currentPage)
        currentPage = currentPage?.next
    }

    fun back(steps: Int): String {
        var count = steps
        var current = currentPage?.prev
        while (current != null && count > 0) {
            current = current.prev
            count--
        }
        return current?.value ?: ""
    }

    fun forward(steps: Int): String {
        return ""
    }

    fun showBrowserHistory() {
        var curr: Node? = currentPage
        while (curr != null) {
            println(curr.value)
            curr = curr.next
        }
    }
}

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