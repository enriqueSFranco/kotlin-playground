package org.tempest.concepts

import kotlin.math.pow

/*
 * EJERCICIO:
 * - Crea ejemplos de funciones básicas que representen las diferentes
 *   posibilidades del lenguaje:
 *   Sin parámetros ni retorno, con uno o varios parámetros, con retorno...
 * - Comprueba si puedes crear funciones dentro de funciones.
 * - Utiliza algún ejemplo de funciones ya creadas en el lenguaje.
 * - Pon a prueba el concepto de variable LOCAL y GLOBAL.
 * - Debes hacer print por consola del resultado de todos los ejemplos.
 *   (y tener en cuenta que cada lenguaje puede poseer más o menos posibilidades)
 *
 * DIFICULTAD EXTRA (opcional):
 * Crea una función que reciba dos parámetros de tipo cadena de texto y retorne un número.
 * - La función imprime todos los números del 1 al 100. Teniendo en cuenta que:
 *   - Si el número es múltiplo de 3, muestra la cadena de texto del primer parámetro.
 *   - Si el número es múltiplo de 5, muestra la cadena de texto del segundo parámetro.
 *   - Si el número es múltiplo de 3 y de 5, muestra las dos cadenas de texto concatenadas.
 *   - La función retorna el número de veces que se ha impreso el número en lugar de los textos.
 *
 * Presta especial atención a la sintaxis que debes utilizar en cada uno de los casos.
 * Cada lenguaje sigue una convenciones que debes de respetar para que el código se entienda.
 */
fun imprimeNumerosYCuenta(text1: String, text2: String): Int {
    var count = 0
    for (i in 1..100) {
        when {
            i % 15 == 0 -> println("$text1 $text2")
            i % 3 == 0 -> println(text1)
            i % 5 == 0 -> println(text2)
            else -> {
                println(i)
                count++
            }
        }
    }
    return count
}


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

// ********** FUNCIONES INFIX **********

// Requisitos para Funciones Infix
//Debe ser una función de un solo parámetro
//Debe estar definida con el modificador infix: Este modificador indica que la función se puede usar en notación infija.
//Debe ser un miembro de una clase o un método de extensión: La función debe ser parte de una clase o un método de extensión.
infix fun Int.plus(other: Int): Int {
    return this + other
}

class Vector(val a: Double, val b: Double) {
    infix fun sumar(v: Vector): Vector {
        return Vector(this.a + v.a, this.b + v.b)
    }
}

class Consulta(val query: String) {
    infix fun donde(condicion: String): Consulta {
        return Consulta("${this.query} WHERE $condicion")
    }

    infix fun ordenarPor(order: String): Consulta {
        return Consulta("${this.query} ORDER BY $order")
    }

    override fun toString() = query
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

fun testingFunctions() {
    reformat(
        str = "hello world",
        normalizeCase = true,
        true,
        divideByCamelHumps = true,
        '-',
    )

    // Uso de la función infix
    val result = 5 plus 3 // 5.plus(3)
    print("Infix: $result") // 8

    val v1 = Vector(4.0, 5.0)
    val v2 = Vector(3.0, 5.0)
    print("suma del vector(4.0, 5.0) y vector(3.0, 5.0) = ${v1 sumar v2}")

    val consultaFinal = Consulta("SELECT * FROM Users") donde "age >= 18" ordenarPor "name"
    print(consultaFinal)
}
