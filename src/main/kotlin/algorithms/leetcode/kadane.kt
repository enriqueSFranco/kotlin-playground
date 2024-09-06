package org.tempest.algorithms.leetcode

import kotlin.math.max

/**
 * El algoritmo de Kadane es un algoritmo eficiente para encontrar la subserie contigua con la suma más grande
 * dentro de una serie de números, ya sea positivos, negativos o una combinación de ambos.
 * Es útil para problemas en los que necesitas encontrar la suma máxima de una subserie contigua
 * en un arreglo unidimensional.
 *
 *
 **/

@OptIn(ExperimentalStdlibApi::class)
fun kadane(arr: IntArray): Int {
    var maxSoFar = arr.first() // almacena la suma máxima encontrada hasta el momento durante el proceso.
    var maxEndingHere = arr.first() // almacena la suma máxima de la subserie que termina en el índice actual del arreglo.

    for (i in 1 ..< arr.size) {
        maxEndingHere = max(arr[i], arr[i] + maxEndingHere)
        maxSoFar = max(maxSoFar, maxEndingHere)
    }
    return maxSoFar
}