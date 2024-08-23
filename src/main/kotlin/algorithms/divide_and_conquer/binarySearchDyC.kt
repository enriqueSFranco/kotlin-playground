package org.tempest.algorithms.divideAndConquer

fun binarySearchDyC(arr: IntArray, target: Int, start: Int, end: Int): Int {
    if (end >= start) {
        val m = start + (end - start) / 2

        if (arr[m] == target) return m

        if (arr[m] < target) return binarySearchDyC(arr, target, m + 1, end)

        return binarySearchDyC(arr, target, start, m - 1)
    }
    return -1
}