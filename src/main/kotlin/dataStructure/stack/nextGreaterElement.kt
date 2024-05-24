package org.tempest.dataStructure.stack

import java.util.Stack

// https://leetcode.com/problems/next-greater-element-i/

fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    val stack = Stack<Int>()
    val nextGreaterMap = mutableMapOf<Int, Int>()

    for (num in nums2) {
        while (!stack.empty() && num > stack.peek()) {
            val smallerNum = stack.pop()
            nextGreaterMap[smallerNum] = num
        }
        stack.push(num)
    }

    val ans = IntArray(nums1.size) { nextGreaterMap.getOrDefault(nums1[it], -1) }

    return ans
}