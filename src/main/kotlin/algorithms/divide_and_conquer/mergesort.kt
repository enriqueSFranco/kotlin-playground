package org.tempest.algorithms.divideAndConquer

fun merge(sortedLeftArray: List<Int>, sortedRightArray: List<Int>): List<Int> {
    var idxLeft = 0
    var idxRight = 0
    var sortedList: MutableList<Int> = mutableListOf()

    while (idxLeft < sortedLeftArray.count() && idxRight < sortedRightArray.count()) {
        if (sortedLeftArray[idxLeft] <= sortedRightArray[idxRight]) {
            sortedList.add(sortedLeftArray[idxLeft])
            idxLeft++
        } else {
            sortedList.add(sortedRightArray[idxRight])
            idxRight++
        }
    }
    // si quedan elementos en sortedLeftArray
    while (idxLeft < sortedLeftArray.size) {
        sortedList.add(sortedLeftArray[idxLeft])
        idxLeft++
    }
    // si quedan elementos en sortedRightArray
    while (idxRight < sortedRightArray.size) {
        sortedList.add(sortedRightArray[idxRight])
        idxRight++
    }

    return sortedList
}
// Θ(nlog2(n))
fun mergeSortDyV(arr: List<Int>): List<Int> {
    if (arr.size <= 1) return arr

    // dividir el array en dos partes
    val m = arr.size / 2
    var left = arr.subList(0, m)
    var right = arr.subList(m, arr.size)

    return merge(mergeSortDyV(left), mergeSortDyV(right))
}