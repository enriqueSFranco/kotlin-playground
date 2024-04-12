package algorithms.leetcode

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.tempest.algorithms.leetcode.twoSum

class TwoSumTest {

    @Test
    fun `test twoSum with valid input`() {
        val nums = intArrayOf(2,7,11,15)
        val target = 9
        val expected = intArrayOf(0, 1)

        assertArrayEquals(expected, twoSum(nums, target))
    }

    @Test
    fun `test twoSum with no solution`() {
        val nums = intArrayOf(2,7,11,15)
        val target = 3

        assertThrows(IllegalArgumentException::class.java) {
            twoSum(nums, target)
        }
    }

    @Test
    fun `test twoSum with multiple valid solution`() {
        val nums = intArrayOf(3,2,4)
        val target = 6

        val expectedFirst = intArrayOf(1, 2)
        val expectedSecond = intArrayOf(2, 1)

        val result = twoSum(nums, target)

        assert(result.contentEquals(expectedFirst) || result.contentEquals(expectedSecond))
    }
}