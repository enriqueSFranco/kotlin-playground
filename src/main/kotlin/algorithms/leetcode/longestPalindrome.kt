package org.tempest.algorithms.leetcode

fun isPalindrome(s: String): Boolean {
    val cleanString = s.replace(" ", "").lowercase()
    var low = 0
    var high = cleanString.length - 1
    val charArrayS = cleanString.toList()

    while (low < high) {
        if (charArrayS[low] != charArrayS[high]) return false
        low++
        high--
    }
    return true
}

fun longestPalindrome(s: String): String {
    var start = 0
    var end = 0

    for (idx in s.indices) {
        // odd
        var left = idx
        var right = idx

        while (left >= 0 && right < s.length && s[left] == s[right]) {
            if ((right - left + 1) > (end - start + 1)) {
                start = left
                end = right
            }
            left--
            right++
        }

        // even
        left = idx
        right = idx + 1

        while (left >= 0 && right < s.length && s[left] == s[right]) {
            if ((right - left + 1) > (end - start + 1)) {
                start = left
                end = right
            }
            left--
            right++
        }
    }
    return s.substring(start, end + 1)
}