package org.tempest.algorithms.sorting

fun countingSort(arr: Array<Int>): Array<Int> {
    var output = Array<Int>(arr.size) { 0 } //
    var count = Array<Int>(10) { 0 }

    for (i in arr) {
        count[i]++
    }

    // suma acumulativa
    for (i in 1..<count.size) {
        count[i] += count[i - 1]
    }

    for (i in arr.indices) {
        output[count[arr[i]] - 1] = arr[i]
        count[arr[i]]--
    }

    return output
}