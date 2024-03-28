package org.tempest

import org.tempest.algorithms.leetcode.arithmeticTriplets

fun main() {
    val nums = intArrayOf(0, 1, 4, 6, 7, 10)
    println("result ${arithmeticTriplets(nums, 3)}")
}