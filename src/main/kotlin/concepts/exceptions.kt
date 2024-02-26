package org.tempest.concepts

// SINTAXIS
//    try {
//      some code
//    } catch (e: SomeException) {
//      catch error
//    } finally {
//
//    }

// try: es una expresion lo que significa que puede tener un valor de retorno

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}

fun excepciones() {
    val input = "foo"
    val a: Int? = try {
        input.toInt()
    } catch (e: NumberFormatException) {
        null
    }
    print(a) // null

    val s = input ?: fail("Name required")
    print(s)
}