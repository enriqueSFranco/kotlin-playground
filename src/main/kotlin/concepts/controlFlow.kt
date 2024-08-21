package org.tempest.concepts

import kotlin.random.Random

enum class Bit {
    ZERO, ONE
}

fun areEqual(a: Double, b: Double, epsilon: Double = 1e-10): Boolean {
    return Math.abs(a - b) < epsilon
}

fun isGreaterThan(a: Double, b: Double, epsilon: Double = 1e-10): Boolean {
    return (a - b) > epsilon
}

fun getRandomBit(): Bit {
    return if (Random.nextBoolean()) Bit.ZERO else Bit.ONE
}

fun main() {
    // ************* Operations on numbers *************
    println("suma: ${1 + 1}")
    println("resta: ${2_500_000_000L - 1L}")
    println("multiplicacion: ${3.14159 * 2.71}")
    println("division: ${10.0 / 3}") // la division siempre devuelve un numero entero y descarta la parte fraccionaria
    print(5 / 2.toDouble() == 2.5) // true

    // ************* Bitwise operations *************
    val a = 5 // 0101
    val b = 3 // 0011

    // Esta operación compara cada bit de dos números y da como resultado un 1 si ambos bits son 1, de lo contrario, da 0.
    print("and: ${a and b}") // 0001

    // Esta operación compara cada bit de dos números y da como resultado un 1 si al menos uno de los bits es 1, de lo contrario, da 0.
    print("or: ${a or b}") // 0111

    // Esta operación compara cada bit de dos números y da como resultado un 1 si los bits son diferentes, de lo contrario, da 0.
    print("xor: ${a xor b}") // 0110

    // Complemento (inv): Esta operación invierte todos los bits de un número, cambiando los 0 a 1 y los 1 a 0.
    print("complemento: ${a.inv()}") // binario: 1010 decimal: -6 usando complemento a2

    // Desplazamiento a la izquierda (shl)
    // Desplaza todos los bits de un número a la izquierda, llenando los bits vacíos con ceros.
    // Esto es equivalente a multiplicar el número por una potencia de 2.
    println("shl: ${a shl 2}") // Salida: 20, En binario: 10100 (20 en decimal)

    // Desplazamiento a la derecha (shr)
    //Desplaza todos los bits de un número a la derecha. Los bits vacíos se llenan con el bit de signo
    // (0 para números positivos, 1 para números negativos).
    print("shr: ${a shr 2}") // 5

    // Desplazamiento a la derecha con relleno de ceros (ushr)
    //Desplaza todos los bits de un número a la derecha, llenando los bits vacíos con ceros.
    // Esto se usa para números no negativos.
    print("ushr: ${-20 ushr 2}") // En binario: 0011 1100 (1073741821 en decimal, en una visualización de 32 bits)

    // ************* Floating-point numbers comparison *************
    val x = 0.1 + 0.2
    val y = 0.3
    val z = 0.1 + 0.2 + 0.1

    println("x == y: ${areEqual(x, y)}") // true
    println("x < z: ${isGreaterThan(z, x)}") // true
    println("y < z: ${isGreaterThan(z, y)}") // true

    // ********+ ESTRUCTURAS DE CONTROL **********

    val start = Random.nextInt(1, 100)
    val end = Random.nextInt(1, 100)
    val maxLimit = 100
    var max = 0

    // ********* IF | ELSE-IF | ELSE *********
    max = if (start < end) start else end
    print(max)

    max = if (maxLimit > start) maxLimit else if (start > end) a else end
    print(max)

    // ********* WHEN *********
    val power = 999
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
    print(rank)

    val c = 10
    when (c) {
        1 -> println("The value of a is: one")
        2 -> println("The value of a is: two")
        10 -> println("The value of a is: teen")
        else -> println("The value of a is: ???")
    }
    // AL HACER QUE EL WHEN SEA UTILZADA COMO UNA EXPRESION
    // EL ELSE ES OBLIGATIRO A MENOS DE QUE EL COMPILADOR PUEDA PROBAR TODOS LOS CASOS POSIBLES ESTAN CUBIERTOS
    val numericValue = when (getRandomBit()) {
        Bit.ZERO -> 0
        Bit.ONE -> 1
        else -> "The value not is a bit"
    }
    println("Bit random: $numericValue")

    val value = 0
    when(value) {
        in 1..10 -> print("Numero entre 1 y 10")
        in 11..20 -> print("Numero entre 11 y 20")
        else -> print("Numero fuera de rango")
    }

    var name = ""
    when {
        name.isEmpty() -> print("Nombre vacio")
        name.length < 5 -> println("Nombre corto")
        else -> println("Nombre adecuado")
    }

    val objeto: String = ""
    when(objeto) {
        is String -> print("Es un string")
        is Int -> print("Es un entero")
        else -> print("Es otro tipo")
    }

    // *********** BUCLE FOR ***********
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

    for (i in 10 downTo 1) {
        println(i)
    }

}
