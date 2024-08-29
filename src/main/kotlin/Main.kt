package org.tempest

import org.tempest.roadmap.fileManagement.readFromFile
import kotlin.time.measureTime

fun main() {
    //val employee = EmployeeBuilder.Builder("1", "", 28).build()
    //val dateTimeString = "2024-04-30 02:25:00"

    val time = measureTime {
        readFromFile()
    }
    println("El tiempo de ejecución fue de $time milisegundos.")
}
