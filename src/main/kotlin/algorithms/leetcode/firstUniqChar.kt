package org.tempest.algorithms.leetcode

import java.util.LinkedList

fun firstUniqCharMap(s: String): Int {
    var index = -1
    val map = mutableMapOf<Char, Int>()

    for (i in s.indices)
        map[s[i]] = map.getOrDefault(s[i], 0) + 1

    for (i in s.indices) {
        if (map[s[i]] == 1) return i
    }

    return index
}

fun firstUniqCharQueue(s: String): Int {
    val charQueue = LinkedList<Char>()

    for (i in s.indices) {
        var c = s[i]
        if (!charQueue.contains(c)) {
            charQueue.offer(c)
        } else {
            charQueue.remove(c)
        }
    }
    return if (charQueue.isEmpty()) -1 else s.indexOf(charQueue.peek())
}