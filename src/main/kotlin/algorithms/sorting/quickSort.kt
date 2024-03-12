package org.tempest.algorithms.sorting

/**
 * Complejidad:
 *  - mejor de los casos: O(N log (N))
 *  - peor de los casos de O(N2)
 *
 * Eficiente en grandes conjuntos de datos
 * No es buena opcion para conjuntos de datos pequeños
 *
 * Opciones para elegir el pivote
 *
 * Elegir siempre el primer elemento
 * Elegir siempre el ultimo elemnto
 * Elegir el medio como pivote
 *
 * {10, 80, 30, 90, 40}
 *                  piv
 *  10 < piv -> swap con 10 -> {10, 80, 30, 90, 40}
 *  80 > piv -> no hacemos nada
 *  30 < 40 -> swap(80, 30) -> {10, 30, 80, 90, 40}
 *  90 > 40 -> no hacemos nada
 *  {10, 30, 80, 90, 40} -> swap(80, 40) -> {10, 30, 40, 90, 80}
 **/

fun swap(arr: Array<Int>, i: Int, j: Int) {
    val tmp = arr[i]
    arr[i] = arr[j]
    arr[j] = tmp
}

fun partitionLastElementAsPivot(arr: Array<Int>, low: Int, high: Int): Int {
    val pivot = arr[high]
    var ptr = low - 1

    for (i in low..<high) {
        if (arr[i] <= pivot) {
            ptr++
            swap(arr, ptr, i)
        }
    }
    swap(arr, ptr + 1, high)

    return ptr
}

fun quickSortLastElementAsPivot(arr: Array<Int>, low: Int, high: Int) {
    if (low < high) {
        val pi = partitionLastElementAsPivot(arr, low, high) // partition index

        quickSortLastElementAsPivot(arr, low, pi - 1)
        quickSortLastElementAsPivot(arr, pi + 1, high)
    }
}

// QUICK SORT CON EL 1ER ELEMENTO COMO PIVOTE
fun partitionFirstElementAsPivot(arr: Array<Int>, low: Int, high: Int): Int {
    val pivot = arr[low]
    var ptr = high

    for (i in (arr.size - 1) downTo low) {
        if (arr[i] >= pivot)
            swap(arr, i, ptr--)
    }
    swap(arr, low, ptr)
    return ptr
}

fun quickSortFirstElementAsPivot(arr: Array<Int>, low: Int, high: Int) {
    if (low < high) {
        // partition index
        val pi = partitionFirstElementAsPivot(arr, low, high)
        quickSortFirstElementAsPivot(arr, low, pi - 1)
        quickSortFirstElementAsPivot(arr, pi + 1, high)
    }
}