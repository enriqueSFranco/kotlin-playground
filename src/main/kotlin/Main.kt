package org.tempest

import org.tempest.algorithms.dynamicProgramming.generate
import kotlin.time.measureTime

fun main() {
    //val employee = EmployeeBuilder.Builder("1", "", 28).build()
    //val dateTimeString = "2024-04-30 02:25:00"
    val time = measureTime {
        println("El evento ocurrió ${generate(2).joinToString()}")
    }
    println("El tiempo de ejecución fue de $time milisegundos.")
}
