package org.tempest.concepts

/**
 * INTERFACES
 *
 * PUEDEN CONTENER DECLARACIONES DE MÉTODOS ABSTRACTOS, ASÍ COMO IMPLEMENTACIONES,
 * LO QUE LAS HACE DIFERENTES DE LAS CLASES ABSTRACTAS ES QUE LAS INTERFACES NO PUEDEN ALMACENAR EL ESTADO
 *
 * En Kotlin, cuando una clase implementa una interfaz, cualquier objeto de esa clase también es un objeto
 * de la interfaz implementada.
 **/

interface MyInterface {
    val prop: Int
    val propertyWithImplementation: String
        get() = "foo"

    fun foo() {
        print(prop)
    }
}

class Child : MyInterface {
    override val prop: Int = 10
}

interface Ordenable {
    fun compareTo(other: Ordenable): Int
}

class Producto(val name: String, val price: Double) : Ordenable {
    override fun compareTo(other: Ordenable): Int {
        return when (other) {
            is Producto -> price.compareTo(other.price)
            else -> throw IllegalArgumentException("No se puede comparar con otro tipo")
        }
    }
}

interface Calculable {
    fun suma(vararg numbers: Int): Int

    fun resta(a: Int, b: Int): Int
}

class Calculadora : Calculable {
    override fun suma(vararg numbers: Int): Int {
        var result = 0

        for (num in numbers) {
            result += num
        }
        return result
    }

    override fun resta(a: Int, b: Int): Int = a - b
}

interface A {
    fun foo() {
        print("A")
    }

    // cualquier clase que implemete esta funcion debera proporicionar una implementacion
    fun bar() // // Sin implementación por defecto (abstracta)
}

interface B {
    fun foo() {
        print("B")
    }

    fun bar() {
        print("bar")
    }
}

class C : A {
    override fun bar() {
        print("bar")
    }
}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }
}