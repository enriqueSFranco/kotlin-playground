package org.tempest

import org.tempest.dataStructure.stack.maxDepth
import kotlin.time.measureTime

fun main() {
    //val employee = EmployeeBuilder.Builder("1", "", 28).build()
    //val dateTimeString = "2024-04-30 02:25:00"

    val time = measureTime {
        println("maxDepth: ${maxDepth("(1+(2*3)+((8)/4))+1")}")
    }
    println("El tiempo de ejecución fue de $time milisegundos.")
}
