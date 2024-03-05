package org.tempest.concepts

/**
 * Las clases pueden tener parametros de tipo generico
 **/
class Box<T>(t: T) {
    val value = t
}

// Creando una instancia de la clase Box
val boxInteger = Box<Int>(10)
val boxString = Box("hola") // inferencia de tipos
