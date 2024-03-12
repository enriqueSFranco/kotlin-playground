package org.tempest.algorithms.leetcode

// https://leetcode.com/problems/reverse-words-in-a-string-iii/
fun reverseSubstring(s: CharArray, i: Int, j: Int) {
    var start = i
    var end = j

    while (start < end) {
        val tmp = s[start]
        s[start] = s[end]
        s[end] = tmp
        start++
        end--
    }
}


fun reverseWords(s: String): String {
    val word = s.toCharArray()
    var start = 0

    for ((index, char) in word.withIndex()) {
        if (index + 1 == word.size || word[index + 1] == ' ') {
            reverseSubstring(word, start, index)
            start = index + 2
        }
    }

    return word.joinToString("")
}