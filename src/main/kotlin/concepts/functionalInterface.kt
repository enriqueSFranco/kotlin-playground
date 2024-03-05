package org.tempest.concepts

/**
 * INTERFACES FUNCIONALES (SAM: Single Abstract Method)
 *
 **/

fun interface KRunnable {
    fun invoke()
}

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

// USANDO UNA CLASE PARA IMPLEMENTAR LA INTERFAZ IntPredicate
class Bar: IntPredicate {
    override fun accept(i: Int): Boolean = i % 2 == 0
}


// USAR LA INTERFAZ SIN UNA CLASE DE POR MEDIO
val isEven = object : IntPredicate {
    override fun accept(i: Int): Boolean = i % 2 == 0
}

// USAR LA INTERFAZ CON UNA LAMDA
val is_even = IntPredicate { it % 2 == 0}

fun foo() {
    val bar = Bar()
    bar.accept(10)

    is_even.accept(10)
}