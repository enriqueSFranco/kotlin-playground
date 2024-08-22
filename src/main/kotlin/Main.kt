package org.tempest

import org.tempest.algorithms.leetcode.Twitter
import kotlin.time.measureTime

fun main() {
    //val employee = EmployeeBuilder.Builder("1", "", 28).build()
    //val dateTimeString = "2024-04-30 02:25:00"
    val twitter = Twitter()

    val time = measureTime {
        println("El evento ocurrió ${twitter.postTweet(1, 5)}")
    }
    println("El tiempo de ejecución fue de $time milisegundos.")
}
