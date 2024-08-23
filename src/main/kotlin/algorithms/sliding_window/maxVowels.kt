package org.tempest.algorithms.slidingWindow

import kotlin.math.max

// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
fun maxVowels(s: String, k: Int): Int {
    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    var windowVowels = 0

    for (i in 0 until k)
        if (vowels.contains(s[i])) windowVowels++

    var maxVowels = windowVowels // 1

    for (i in k until s.length) {
        if (vowels.contains(s[i - k])) windowVowels--
        if (vowels.contains(s[i])) windowVowels++
        maxVowels = max(maxVowels, windowVowels)
    }

    return maxVowels
}