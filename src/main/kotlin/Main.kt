package org.tempest

import org.tempest.roadmap.examplesWhitLogs
import org.tempest.roadmap.TaskRepository
import org.tempest.roadmap.TaskUtils

fun main() {
    //val employee = EmployeeBuilder.Builder("1", "", 28).build()
    //val dateTimeString = "2024-04-30 02:25:00"
    examplesWhitLogs()

    var tasks = mutableMapOf<String, String>()
    val taskRepository = TaskRepository(tasks)
    taskRepository.createTask("Comprar despensa", "Ir al supermercado a comprar la despensa")
    taskRepository.createTask("Hacer ejercicio", "Ir al parque a correr")
    taskRepository.createTask("Estudiar 3hrs", "Estudiar para el examen de programacion")
    taskRepository.createTask("Leer el manhwa", "Leer el manhwa de solo leveling")

    val taskUtils = TaskUtils(tasks)

    taskUtils.show()

    taskRepository.removeTask("Leer el manhwa")

    taskUtils.show()
}
