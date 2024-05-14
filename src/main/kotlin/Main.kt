package org.tempest

import org.tempest.concepts.getTimeAgo
import kotlin.time.measureTime

fun main() {
   //val employee = EmployeeBuilder.Builder("1", "", 28).build()
    val dateTimeString = "2024-04-30 02:25:00"
    val time = measureTime {
        println("El evento ocurrió ${getTimeAgo(dateTimeString)}")
    }
    println("El tiempo de ejecución fue de $time milisegundos.")
}
