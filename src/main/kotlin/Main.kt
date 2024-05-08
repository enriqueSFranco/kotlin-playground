package org.tempest
import kotlin.time.measureTime

import org.tempest.algorithms.dynamicProgramming.coinChange


fun main() {
   //val employee = EmployeeBuilder.Builder("1", "", 28).build()
    val coins = intArrayOf(186,419,83,408)
    val amount = 6249
    val time = measureTime {
        val ans = coinChange(coins, amount)
        println(ans)
    }
    println("El tiempo de ejecución fue de $time milisegundos.")
}
