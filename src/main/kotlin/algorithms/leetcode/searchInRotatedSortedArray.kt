package org.tempest.algorithms.leetcode

fun modifiedBinarySearch(arr: IntArray, left: Int, right: Int, target: Int): Int {
    if (left > right) return -1

    val mid = left + ((right - left) / 2)

    if (arr[mid] == target) return mid

    if (arr[mid] >= arr[left]) { // search left array
        if (arr[left] <= target && target <= arr[mid])
            return modifiedBinarySearch(arr, left, mid - 1, target)
        else
            return modifiedBinarySearch(arr, mid + 1, right, target)
    } else { // search right array
        if (arr[mid] <= target && target <= arr[right])
            return modifiedBinarySearch(arr, left, mid - 1, target)
        else
            return modifiedBinarySearch(arr, mid + 1, right, target)
    }
}

fun search(nums: IntArray, target: Int): Int {
    return modifiedBinarySearch(nums, 0, nums.size - 1, target)
}