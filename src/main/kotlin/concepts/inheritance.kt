package org.tempest.concepts

/**
 * HERENCIA
 *
 * PARA QUE UNA CLASE SEA HEREDADA SE DEBE USAR LA PALABRA RESERVADA OPEN
 *
 * Si la clase derivada tiene un constructor primario, la clase base puede (y debe) inicializarse
 * en ese constructor primario de acuerdo con sus parámetros.
 *
 * Si la clase derivada no tiene un constructor primario, entonces cada constructor secundario tiene que inicializar
 * el tipo base usando la palabra clave (super) o tiene que delegar a otro constructor que lo hace.
 *
 * Si se requiere que un método de la clase padre sea sobre-escrito en la clase hija se debe poner la palabra reservada
 * (open)
 *
 * Si el método de la clase hija ya no se requiere que sea modificado en alguna clase hija se pone final
 *
 * Si se requiere que una propiedad de la clase padre sea sobre-escrito en la clase hija se debe poner la palabra reservada
 * (open)
 *
 * Tambien es posible anular una propiedad val con var, pero no al contrario
 * */


open class Animal(val name: String) {
    open val gender: Char = 'F' // propiedad abierta a modificacion en la clase hija
    open val color: String = "negro"

    open fun makeSound() {
        println("Some generic sound")
    }
}

class Dog(name: String) : Animal(name) {
    override val gender: Char = 'M'
    override var color: String = "blanco"

    final override fun makeSound() {
        println("woof!")
    }
}

// LLAMANDO A LA IMPLEMENTACION DE LAS SUPER-CLASES
open class Rectangle {
    open fun draw() {
        println("Drawing a rectangle")
    }

    val borderColor: String get() = "black"
}

class FilledRectangle : Rectangle() {
    override fun draw() {
        // EJEMPLO CON LA CLASE RECTANGLE
        //super.draw() -> llamando al método draw de la clase Rectangle
        //println("Filling the rectangle")

        // EJEMPLO CON LA CLASE INTERNA
        val fill = Filler()
        fill.drawAndFill()
    }

    private val fillColor: String get() = super.borderColor // fillColor = "black"

    // CLASES INTERNAS
    inner class Filler {
        private fun fill() {
            println("Filling")
        }

        fun drawAndFill() {
            //super<Class>.nameMethod() -> esto se usa cundo hay herencia multiple y quieres llamar un método de una super clase en especifico
            super@FilledRectangle.draw() // llama al método de la super clase Rectangle, si se quiere llamar al método draw() de la clase FilledRectangle se usa this@FilledRectangle.draw()
            fill()
            println("Drawn a filled rectangle with color ${super@FilledRectangle.borderColor}")
        }
    }
}