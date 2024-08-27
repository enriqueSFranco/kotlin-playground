package org.tempest.algorithms.divideAndConquer

import kotlin.math.floor

/*
* 1. Tener un método básico para resolver los problemas de tamaño pequeño.
* 2. División del problema original en un conjunto de subproblemas con soluciones más sencillas.
* 3. Los problemas en los que se dividen deben ser disjuntos e independientes
* 4. Tener un método para combinar los resultados.
* */

// Buscar el máximo en un vector entre las posiciones p y q.
const val Th = 3
fun maximo(nums: IntArray, p: Int, q: Int): Int {
    if (q - p < Th) {
        var max = nums[p]
        for (i in p + 1 until q) {
            if (max <= nums[i])
                max = nums[i]
        }
        return max
    } else {
        val m = p + (q - p) / 2
        val max1 = maximo(nums, p, m)
        val max2 = maximo(nums, m, q)
        return if(max1 > max2) max1 else max2
    }
}

