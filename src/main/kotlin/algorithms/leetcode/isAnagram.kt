package org.tempest.algorithms.leetcode

// https://leetcode.com/problems/valid-anagram/

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val normalizedS = s.lowercase().replace(" ", "")
    val normalizedT = t.lowercase().replace(" ", "")
    val bucketAlphabet = IntArray(26) {0}

    for (char in normalizedS)
        bucketAlphabet[char - 'a']++

    for (char in normalizedT)
        bucketAlphabet[char - 'a']--

    return bucketAlphabet.all { it == 0 }
}


// https://leetcode.com/problems/group-anagrams/

fun getFrequencyStr(str: String): String {
    val sb = StringBuilder("")
    val bucket = IntArray(26) { 0 }
    val normalizedStr = str.lowercase().replace(" ", "")

    for (char in  normalizedStr) {
        val idx = char - 'a'
        bucket[idx]++
    }

    for (i in bucket.indices) {
        if (bucket[i] != 0) {
            val asciiValueOfA = 'a'.toInt()
            sb.append("${(i + asciiValueOfA).toChar()}${bucket[i]}")
        }
    }

    return sb.toString()
}

fun groupAnagrams(strs: Array<String>): List<List<String>> = strs.groupBy { getFrequencyStr(it) }.values.toList()