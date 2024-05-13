package org.tempest.algorithms.dynamicProgramming

import kotlin.math.max

// https://leetcode.com/problems/longest-common-subsequence/
fun lcs(s1: String, s2: String, m: Int, n: Int): Int {
    if (m == 0 || n == 0) return 0
    return if (s1[m - 1] == s2[n - 1]) 1 + lcs(s1, s2, m - 1, n - 1)
    else return max(lcs(s1, s2, m, n - 1), lcs(s1, s2, m - 1, n))
}

fun longestCommonSubsequence(text1: String, text2: String): Int {
    return lcs(text1, text2, text1.length, text2.length)
}