package org.tempest.concepts

import kotlin.math.pow

fun double (x: Int) : Int {
    return 2 * x
}

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