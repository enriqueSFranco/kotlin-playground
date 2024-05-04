package org.tempest.dataStructure.stack

import org.tempest.dataStructure.Stack

fun isValid(s: String): Boolean {
    val closeToOpen = mapOf<Char, Char>(')' to '(', ']' to '[', '}' to '{')
    var storage = Stack<Char>()

    for(symbol in s) {
        if (closeToOpen.containsKey(symbol)) {
            if (!storage.isEmpty() && closeToOpen[symbol] == storage.peek())
                storage.pop()
            else return false
        } else storage.push(symbol)
    }

    return storage.isEmpty()
}