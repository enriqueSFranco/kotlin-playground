package org.tempest.concepts

// EXTENSIÓN PARA LA CLASE MutableList<Int>
//fun MutableList<Int>.swap(index1: Int, index2: Int) {
//    val tmp = this[index1] // La palabra clave <<this>> dentro de una función de extensión corresponde al objeto receptor
//    this[index1] = this[index2]
//    this[index2] = tmp
//}

// EXTENSIÓN GENERICA PARA LA CLASE MutableList
fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // La palabra clave <<this>> dentro de una función de extensión corresponde al objeto receptor
    this[index1] = this[index2]
    this[index2] = tmp
}

fun extensionsTest() {
    val list = mutableListOf(1,2,3,4)
    list.swap(0,3)
    print(list)
}