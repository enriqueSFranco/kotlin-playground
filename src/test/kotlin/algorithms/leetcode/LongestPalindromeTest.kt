package algorithms.leetcode

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.tempest.algorithms.leetcode.isPalindrome

class LongestPalindromeTest {

    @Test
    fun `test`() {
        val s = "anita lava la tine"
        val expected = true
        val result = isPalindrome(s)

        assertEquals(expected, result)
    }
}