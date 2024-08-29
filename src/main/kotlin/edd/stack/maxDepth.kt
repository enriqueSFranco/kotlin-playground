package org.tempest.dataStructure.stack

// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

fun maxDepth(s: String): Int {
    var ans = 0
    var stack = ArrayDeque<Char>()

    for (char in s) {
        when (char) {
            '(' -> {
                stack.addLast(char)
                ans = maxOf(ans, stack.size)
            }

            ')' -> {
                if (stack.isEmpty()) return -1
                stack.removeLast()
            }

            else -> continue
        }
    }
    return if (stack.isEmpty()) ans else -1
}