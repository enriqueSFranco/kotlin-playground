package org.tempest.algorithms.leetcode

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()

    nums.forEachIndexed { idx, item ->
        val found = map[target - item]
        found?.let {
            return intArrayOf(found, idx)
        }
        map[item] = idx
    }
    throw IllegalArgumentException("No solution")
}
