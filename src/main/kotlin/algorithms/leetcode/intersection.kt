package org.tempest.algorithms.leetcode

// https://leetcode.com/problems/intersection-of-two-arrays/
fun searchInstersection(arr: IntArray, target: Int, low: Int, high: Int): Boolean {
    if (high >= low) {
        var middle = low + (high - low) / 2
        return when {
            arr[middle] == target -> true
            arr[middle] <= target -> searchInstersection(arr, target, middle + 1, high)
            else -> searchInstersection(arr, target, low, middle - 1)
        }
    }
    return false
}

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val N = nums1.size
    val intersections = HashSet<Int>()

    nums1.sort()

    for (num in nums2) {
        if(searchInstersection(nums1, num, 0, N - 1)) {
            intersections.add(num)
        }
    }
    return intersections.toIntArray()
}