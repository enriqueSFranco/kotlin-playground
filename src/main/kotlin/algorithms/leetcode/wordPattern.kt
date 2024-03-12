package org.tempest.algorithms.leetcode

// https://leetcode.com/problems/word-pattern/

/**
 * s = "dog cat cat dog"
 * pattern = "abba"
 **/

fun wordPattern(pattern: String, s: String): Boolean {
    val words = s.split(" ")

    if (words.size != pattern.length) return false

    val map = hashMapOf<Char, String>()

    for ((index, word) in words.withIndex()) {
        val c = pattern[index]

        if (!map.containsKey(c) && !map.containsValue(word)) {
            map[c] = word
        } else if (map[c] != word) {
            return false
        }
    }
    return true
}