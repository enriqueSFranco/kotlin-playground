package org.tempest.concepts

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.coroutineScope

fun main() = runBlocking { // this: CoroutineScope
    launch { // launch a new coroutine and continue
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }
    println("Hello") // main coroutine continues while a previous one is delayed
}

// REFACTOR
fun init() = runBlocking {
    launch{doWorld()}
    println("Hello")
}

suspend fun doWorld(){
    delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
    println("World!") // print after delay
}


// CONSTRUCTOR DE ALCANCE
fun _init() = runBlocking {
    _doWorld()
    println("Done")
}

suspend fun _doWorld() = coroutineScope {
    launch {
        delay(2000L)
        println("Isekai!")
    }

    launch {
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }
    println("Hello")
}