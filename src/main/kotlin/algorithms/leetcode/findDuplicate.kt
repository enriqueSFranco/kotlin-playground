package org.tempest.algorithms.leetcode

// https://leetcode.com/problems/find-the-duplicate-number/
fun findDuplicate(nums: IntArray): Int {
    //  floyd's cycle detection
    var slow = 0
    var fast = 0

    do {
        slow = nums[slow]
        fast = nums[nums[fast]]
    } while (slow != fast)

    slow = 0
    while (slow != fast) {
        slow = nums[slow]
        fast = nums[fast]
    }

    return slow
}