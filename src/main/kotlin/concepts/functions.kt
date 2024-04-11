package org.tempest.concepts

import kotlin.math.pow

/**
 * Calcula la potencia de un número elevado a un exponente.
 *
 * Esta función calcula la potencia de [number] elevado a [exponent].
 * Si no se proporcionan [number] y [exponent], se utilizarán los valores predeterminados 5.0 y 2.0 respectivamente.
 *
 * @param number El número base para el cálculo de la potencia. El valor predeterminado es 5.0.
 * @param exponent El exponente al que se elevará el número base. El valor predeterminado es 2.0.
 * @return El resultado de elevar [number] a la potencia de [exponent].
 */
fun powerOf(
    number: Double = 5.0,
    exponent: Double = 2.0
): Double { return number.pow(exponent) }

// ARGUMENTOS NOMBRADOS
fun reformat(
    str: String,
    normalizeCase: Boolean = false,
    upperCaseFirstLetter: Boolean = false,
    divideByCamelHumps: Boolean = false,
    wordSeparator: Char = ' '
) {
}

fun testFunReformat() {
    reformat(
        str = "hello world",
        normalizeCase = true,
        true,
        divideByCamelHumps = true,
        '-',
    )
}

// SINGLE EXPRESSION FUNCTIONS
fun dobule(x: Int) = 2 * x

// Variable number of arguments (varargs)
fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()

    for (item in ts) {
        result.add(item)
    }
    return result
}