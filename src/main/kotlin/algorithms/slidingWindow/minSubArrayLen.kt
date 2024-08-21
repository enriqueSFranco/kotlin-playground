package org.tempest.algorithms.slidingWindow

// https://leetcode.com/problems/minimum-size-subarray-sum/
fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var minWindow = Int.MAX_VALUE
    var currSum = 0
    var low = 0
    var high = 0

    while (high < nums.size) {
        currSum += nums[high]
        high++
        while (currSum >= target) {
            currSum -= nums[low]
            var currWindowSize = high - low
            minWindow = minOf(minWindow, currWindowSize)
            low++
        }
    }
    return if (minWindow == Int.MAX_VALUE) 0 else minWindow
}