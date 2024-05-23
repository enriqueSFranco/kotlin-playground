package org.tempest.algorithms.leetcode

fun moveZeroes(nums: IntArray): Unit {
    var insertPosition = 0

    for (i in 0 until nums.size) {
        if (nums[i] != 0) {
            nums[insertPosition] = nums[i]
            insertPosition++
        }
    }
    while (insertPosition < nums.size)
        nums[insertPosition++] = 0
}