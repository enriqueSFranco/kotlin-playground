package org.tempest.algorithms.leetcode

fun maximumOddBinaryNumber(s: String): String {
    var s = s.toMutableList()
    var left = 0

    for (i in s.indices) {
        if (s[i] == '1') {
            val tmp = s[i]
            s[i] = s[left]
            s[left] = tmp
            left++
        }
    }
    val tmp = s[left - 1]
    s[left - 1] = s[s.size - 1]
    s[s.size - 1] = tmp

    return s.joinToString("")
}