package org.tempest.roadmap

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlin.time.measureTime

private val logger = KotlinLogging.logger {}

fun examplesWhitLogs() {
    logger.trace { "This is trace log" }
    logger.debug { "This is debug log" }
    logger.info { "This. is info log" }
    logger.error { "This is error log" }
}

class TaskRepository(private var tasks: MutableMap<String, String>) {

    fun createTask(name: String, description: String) {
        val time = measureTime {
            if (tasks[name] != null) {
                logger.info { "No se pudo agregar la tarea. La tarea $name ya existe." }
            } else {
                tasks[name] = description
                logger.info { "Tarea agregada $name" }
            }
        }
        logger.debug { "Tiempo de ejecucion para agregar una nueva tarea $time ms" }
    }

    fun removeTask(name: String): Boolean {
        val time = measureTime {
            if (tasks[name] != null) {
                tasks.remove(name)
                logger.info { "Tarea eliminada: '$name'" }
                return true
            } else {
                logger.info { "No se pudo eliminar la tarea. No se encontro ninguna tarea con el nombre $name" }
            }
        }
        logger.debug { "Tiempo de ejecucion para eliminar una tarea $time ms" }
        return false
    }
}

class TaskUtils(private val tasks: MutableMap<String,String>) {
    fun show() {
        val time = measureTime {
            if (tasks.isNotEmpty()) {
                tasks.forEach { (name, description) ->
                    logger.info { "Name: $name - Description: $description" }
                }
            } else {
                logger.info { "No hay tareas disponibles" }
            }
        }
    }
}