package org.tempest.algorithms.leetcode

data class Node(val value: String, var prev: Node? = null, var next: Node? = null)

class BrowserHistory(homepage: String) {
    private var currentPage: Node? = Node(homepage)

    // OK
    fun visit(url: String) {
        val newNode = Node(url)
        newNode.prev = currentPage
        currentPage?.next = newNode
        currentPage = newNode
    }

    // OK
    fun back(steps: Int): String {
        var count = steps
        var tmp = currentPage
        while (tmp?.prev != null && count > 0) {
            tmp = tmp.prev
            count--
        }
        currentPage = tmp
        return currentPage?.value ?: ""
    }

    // OK
    fun forward(steps: Int): String {
        var count = steps
        var tmp = currentPage
        while (tmp?.next != null && count > 0) {
            tmp = tmp.next
            count--
        }
        currentPage = tmp
        return currentPage?.value ?: ""
    }
}

fun testBrowserHistory() {
    val homepages = listOf<String>("google.com", "facebook.com", "youtube.com")
    val browserHistory = BrowserHistory("leetcode.com")

    for (homepage in homepages)
        browserHistory.visit(homepage)


    println(browserHistory.back(3))
    println(browserHistory.forward(3))
}