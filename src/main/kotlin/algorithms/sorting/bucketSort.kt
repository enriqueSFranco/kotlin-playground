package org.tempest.algorithms.sorting

fun bucketSort(nums: IntArray): IntArray {
    val N = nums.max() // encontrar el maximo valor en el input
    var buckets = IntArray(N + 1) { 0 } // construir un array de tamaño N + 1

    // contar las ocurrencias de cada elemento
    for (i in nums.indices)
        buckets[nums[i]]++

    // suma acumulativa
    val prefixSum = IntArray(N + 1)
    prefixSum[0] = buckets[0]

    for (i in 1 .. nums.size) {
        prefixSum[i] += prefixSum[i - 1] + buckets[i]
    }

    return  intArrayOf()
}