package org.tempest.dataStructure.stack

import java.util.Stack

// Ejercicio: https://leetcode.com/problems/design-browser-history/description/
data class BrowserHistoryNode(
    var value: String,
    var prev: BrowserHistoryNode? = null,
    var next: BrowserHistoryNode? = null
)
class BrowserHistory(homepage: String) {
    var currPage: BrowserHistoryNode? = BrowserHistoryNode(homepage)

    fun visit(url: String) {
        var newPage = BrowserHistoryNode(url)
        newPage.prev = currPage
        currPage?.next = newPage
        currPage = newPage
    }

    fun back(steps: Int): String {
        var tempPage: BrowserHistoryNode? = currPage
        var stepsRemaining = steps
        while (stepsRemaining > 0 && tempPage?.prev != null) {
            tempPage = tempPage.prev
            stepsRemaining--
        }
        currPage = tempPage
        return currPage?.value ?: ""
    }

    fun forward(steps: Int): String {
        var tempPage: BrowserHistoryNode? = currPage
        var stepsRemaining = steps

        while (stepsRemaining > 0 && tempPage?.next != null) {
            tempPage = tempPage.next
            stepsRemaining--
        }
        currPage = tempPage
        return currPage?.value ?: ""
    }
}

//class BrowserHistory(homepage: String) {
//    private val history = Stack<String>()
//    private val forwardStack = Stack<String>()
//
//    fun visit(url: String) {
//        history.push(url)
//        forwardStack.clear()
//    }
//
//    fun back(steps: Int): String {
//        for (i in 0 until steps) {
//            if (history.size > 1) forwardStack.push(history.pop())
//            else break
//        }
//        return history.peek()
//    }
//
//    fun forward(steps: Int): String {
//        for (i in 0 until steps) {
//            if (forwardStack.isNotEmpty()) history.push(forwardStack.pop())
//            else break
//        }
//        return history.peek()
//    }
//}