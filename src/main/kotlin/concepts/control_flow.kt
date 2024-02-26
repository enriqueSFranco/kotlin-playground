package org.tempest.concepts

import kotlin.random.Random

enum class Bit {
    ZERO, ONE
}


fun estrucuraIf() {
    val a = Random.nextInt(1, 100)
    val b = Random.nextInt(1, 100)
    var max = 0
    val maxLimit = 100
    // IF - ELSE IF - ELSE
    if (a < b)
        max = a
    else max = b

    max = if (a < b) a else b

    max = if (maxLimit > a) maxLimit else if (a > b) a else b
}

fun getRank(power: Int): String {
    val rank = when (power) {
        in 1..10 -> "rango E"
        in 11..20 -> "rango D"
        in 21..30 -> "rango C"
        in 31..80 -> "rango B"
        in 81..100 -> "rango A"
        in 101..150 -> "rango S"
        in 151..200 -> "monarca"
        in 201..1000 -> "emperador"
        else -> "fuera de rango"
    }
    return rank
}

fun getRandomBit(): Bit {
    return if (Random.nextBoolean()) Bit.ZERO else Bit.ONE
}

fun estructuraWhen(): Unit {
    val a = 10

    when (a) {
        1 -> println("The value of a is: one")
        2 -> println("The value of a is: two")
        10 -> println("The value of a is: teen")
        else -> println("The value of a is: ???")
    }
    // AL HACER QUE EL WHEN SEA UTILZADA COMO UNA EXPRESION, EL ELSE ES OBLIGATIRO A MENOS DE QUE EL COMPILADOR PUEDA PROBAR TODOS LOS CASOS PORBLIES ESTAN CUBIERTOS
    val numericValue = when (getRandomBit()) {
        Bit.ZERO -> 0
        Bit.ONE -> 1
    }
    println("Bit random: $numericValue")

    // USANDO WHEN CON RANGOS
    println("level: ${getRank(1_000)}")
}

fun cicloFor(): Unit {
    val array = arrayOf<String>("kike", "karla", "fernanda", "greta")

    println("iterar un array con indices")
    // iterar un array con indices
    for (i in array.indices)
        println("$i -> ${array[i]}")

    println("usando la función withIndex")
    //usando la función withIndex
    for ((index, value) in array.withIndex())
        println("the element at $index is $value")

    println("itera de 3 en 3 desde el 6 hasta el 0")
    // itera de 3 en 3 desde el 6 hasta el 0
    for (i in 6 downTo 0 step 3)
        println(i)
}
