package org.tempest

import kotlin.time.measureTime
import org.tempest.algorithms.dynamicProgramming.maxProduct

fun main() {
   //val employee = EmployeeBuilder.Builder("1", "", 28).build()
    val prices = intArrayOf(0,2)
    val time = measureTime {
        val ans = maxProduct(prices)
        println(ans)
    }
    println("El tiempo de ejecución fue de $time milisegundos.")
}
