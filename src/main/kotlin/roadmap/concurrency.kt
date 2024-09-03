package org.tempest.roadmap

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

//suspend fun doWorld() {
//    delay(2000L) // non-blocking delay for 1 second (default time unit is ms)
//    println("World") // print after delay
//}

//fun main() = runBlocking { // this: CoroutineScope
//    launch { // launch a new coroutine and continue
//        // delay(2000L) // non-blocking delay for 1 second (default time unit is ms)
//        // println("World") // print after delay
//        doWorld()
//    }
//    println("Hello") // main coroutine continues while a previous one is delayed
//}

// Ejercicio
suspend fun runTask(name: String, duration: Long) {
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")

    println("$name ha comenzado a las ${LocalDateTime.now().format(formatter)}")
    println("Duracion estimada $duration")
    delay(duration)
    println("$name ha finalizado a las ${LocalDateTime.now().format(formatter)}")
}


fun main(): Unit = runBlocking {
    val tC = async { runTask("Task C", 3000L) }
    val tB = async { runTask("Task B", 2000L) }
    val tA = async { runTask("Task A", 1000L) }

//    tC.await()
//    tB.await()
//    tA.await()
    awaitAll(tC, tB, tA)

    runTask("Task D", 1000L)
}