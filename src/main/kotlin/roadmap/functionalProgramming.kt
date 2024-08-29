package org.tempest.concepts

/**
 * FP(Functional Programming) es un paradigma de programación
 * donde los programas se construyen aplicando y componiendo funciones.
 * */

fun fooOne(list: IntArray) {
    // Opcion 1
    var sum = 0
    for (item in list) {
        if (item > 0) {
            sum += item * item
        }
    }

    // Opcion 2
    list.filter { it > 0 }.map { it * it }.sum()
}


/**
 * En Kotlin se pueden pasar funciones como argumentos de otras funciones:
 * fun foo(bar: () -> Unit): Unit {...}
 *
 * Si el último argumento de una función es una función, entonces se puede poner fuera del paréntesis:
 * fun baz(start: Int, end: Int, step: (Int) -> Unit): Unit {...}
 * baz(23, 42) { println("¡Magnífico!") }
 *
 * Si el único argumento de una función es una función, entonces los paréntesis se pueden omitir por completo:
 * foo { println ("¡Kotlin sigue dando!") }
**/


/**
 * Higher order functions (HOFs)
 *Las funciones que toman otras funciones como argumentos se denominan funciones de orden superior.
 *
 * En Kotlin los encuentras frecuentemente cuando trabajas con colecciones:
 * list.partition { it % 2 == 0 } ó list.partition { x -> x % 2 == 0 }
 *
 * Todo lo que Kotlin te permite hacer con funciones, lo que significa que "las funciones en Kotlin son ciudadanos de primera clase".
 **/