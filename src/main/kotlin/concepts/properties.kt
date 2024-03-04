package org.tempest.concepts

import kotlin.random.Random

class Address {
    // PROPIEDADES MUTABLES
    var name: String = "Holmes, Sherlock"
    var street: String = "Baker"
    var city: String = "London"
    var state: String? = null

    // PROPIEDAD DE SOLO LECTURA
    val zip: String = "123456" // NO TIENE SETTER
}

class Text(val content: String) {
    // PROPIEDAD CALCULADA
    val upperCase get() = this.content.uppercase() // SE PUEDE OMITIR EL TIPO SIEMPRE Y CUANDO SE PUEDA INFERIR DEL GETTER
    val lowerCase get() = this.content.lowercase()
}

class Dado {
    val value: Int
        get() = Random.nextInt(1, 7)
}

/**
 * Backed Properties
 * EL IDENTIFICADOR FIELD SOLO SE PUEDE USAR EN LAS PROPIEDADES DE RESPALDO
 **/

var counter = 0 // EL COMPILADOR CREAR AUTOMATICAMENTE UN CAMPO DE RESPALDO
    set(value) {
        if (value >= 0)
            field = value
    }


val total: Int // NO ES NECESARIO UN CAMPO DE RESPALDO YA QUE LA PROPIEDAD ES DE SOLO LECTURA
    get() = 10

// FORMA DE SUMULAR UNA PROPIEDAD DE RESPALDO
private var _table: Map<String, Int>? = null
public val table: Map<String, Int>
    get() {
        if (_table == null) {
            _table = HashMap() // Type parameters are inferred
        }
        return _table ?: throw AssertionError("Set to null by another thread")
    }

/**
 * CONSTANTES EN TIEMPO DE COMPILACIÓN
 *
 * Si el valor de una propiedad de solo lectura se conoce en el momento de la compilación,
 * márquelo como compilar constante de tiempo usando el modificador const
 *
 * REQUISITOS
 *
 * 1.- Valor Literal: La constante debe ser un valor literal conocido en tiempo de compilación, como un número, una cadena de texto o un booleano.
 * 2.- Tipo de Datos Primitivo o String: Las constantes en tiempo de compilación solo pueden ser de tipo de datos primitivo (Int, Long, Double, etc.) o String.
 * 3.- Contexto de Definición: Las constantes en tiempo de compilación deben ser definidas en el nivel superior del archivo, es decir, fuera de cualquier función, clase o bloque de código.
 */
const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"

// Late-initialized properties and variables
class TestSubject {
    fun method() {
        print("init test...")
    }
}

class MyTest {
    private lateinit var subject: TestSubject

    fun setup() {
        subject = TestSubject()
    }

    fun test() {
        subject.method()
    }
}