package org.tempest.algorithms.leetcode

// https://leetcode.com/problems/number-of-arithmetic-triplets/
fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
    var i = 0
    var j = 1
    var k = 2
    var count = 0
    var numsSize = nums.size

    /**
     *             i   j    k
     *         0 1 2 3 4 5
     * nums = [0,1,4,6,7,10], diff = 3
     * */

    while (i < numsSize && j < numsSize && k < numsSize) {
        if (nums[j] - nums[i] < diff) {
            j++
        } else if (nums[j] - nums[i] > diff) {
            i++
        } else {
            if (nums[k] - nums[j] < diff) {
                k++
            } else if (nums[k] - nums[j] > diff) {
                j++
            } else {
                k++
                count++
            }
        }
    }

    return count
}