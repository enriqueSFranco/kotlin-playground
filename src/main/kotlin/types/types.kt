package org.tempest.types

// TIPOS ENTEROS
val one = 1 // Int
val threeBillion = 3000000000 // Long
val oneLong = 1L // Long -32768 a 32767
val oneByte: Byte = 1 // -128 a 127

// TIPOS CON DECIMALES
val pi = 3.14 // Double
// val one: Double = 1 // Error: type mismatch
val oneDouble = 1.0 // Double
val e = 2.7182818284 // Double
val eFloat = 2.7182818284f // Float, actual value is 2.7182817

// Puede usar guiones bajos para hacer que las constantes numéricas sean más legibles:
val oneMillion = 1_000_000
val creditCardNumber = 1234_5678_9012_3456L
val socialSecurityNumber = 999_99_9999L
val hexBytes = 0xFF_EC_DE_5E
val bytes = 0b11010010_01101001_10010100_10010010

// caching de enteros
val a: Int = 100
val boxedA: Int? = a
val anotherBoxedA: Int? = a

val b: Int = 10000
val boxedB: Int? = b
val anotherBoxedB: Int? = b
// Comparamos la referencia de los objetos de los enteros en memoria
// println(boxedA === anotherBoxedA) // true
// println(boxedB === anotherBoxedB) // false

// Conversiones de numeros explícitos
val x : Byte = 1
//val y : Int = x ERROR
val i1 : Int = b.toInt()

val textOne = "hello world"
val textOnerUpperCase = textOne.uppercase()

// STRING MULTI-LINEA
var paragraphOne = """
    for (c in paragraph) {
        println(c)
    }
"""

// TEMPLATE STRING
val paragraphTwo = "hello"
// $ -> imprime el valor de la variable
// ${} -> sirve para operaciones y mosrtar su valor
// print("longitud de $paragraphTwo es: ${paragraphTwo.length}")


// FORMATO DE STRINGS
// Formats to add zeroes and make a length of seven
val integerNumber = String.format("%07d", 31416)
// 0031416

// Formats with four decimals and sign
val floatNumber = String.format("%+.4f", 3.141592)
// +3.1416

// Formats with uppercase for two placeholders
val helloString = String.format("%S %S", "hello", "world")
// HELLO WORLD

// ARRAYS
val goldenSaint = arrayOf(
    "mu",
    "aldebaran",
    "saga",
    "mascara de muerte",
    "aioria",
    "shaka",
    "dohko",
    "milo",
    "aioros",
    "shura",
    "camus",
    "afrodida"
)

// ARRAY DE NULLS
val nullArray: Array<Int?> = arrayOfNulls(4) // [null, null, null, null]
// ARRAY DE STRING
val emptyArrayString = emptyArray<String>()
// ARRAY VACIO
val emptyArrayInteger: Array<Int> = emptyArray()

// USANDO EL CONSTRUCTOR ARRAY(size) { callback }
val initialArray = Array<Int>(5) {0}
// ARRAY DE INTEGERS EN UN RANGO DE 0..9
val rangeValues = Array(10) { it -> it}
// ITERAR SOBRE EL ARRAY RANGE_VALUES
// rangeValues.forEach { println(it)}

// ARRAY ANIDADOS -> Los arrays anidados no tienen porque ser del mismo tipo
val twoArray = Array(2) { Array<Int>(2) {0} } // [[0,0], [0,0]]
// IMPRIMIR EL ARRAY ANIDADO
//twoArray.forEach { row -> row.forEach { element -> print(element) } }

// USANDO EL ARGUMENTO vararg -> si no se sabe de antemano cuantos parametros va a recibir la función
fun printAllString(vararg strings: String) {
    for (s in strings) {
        print(s)
    }
}
// USANDO LA FUNCION printAllStrings()
val lettersArray = arrayOf<String>("c", "d")
//printAllString("a", "b", *lettersArray, "e", "f")

// COMPRAR ARRAYS CON LOS MÉTODOS contentEquals() y contentDeepEquls()
val notes = arrayOf(8,9,10)
val notesCopy = arrayOf(8,9,10)
// print(notes.contentEquals(notesCopy)) compara el contenido y el orden de los elementos del array
// USANDO LA NOTACION DEL INFIJO
//notes[0] = 10
// val result = notes contentEquals notesCopy

// TRANSFORMAR MATRICES
val sumArray = arrayOf(1,2,3,4)
// sumArray.sum() -> 10
// simpleArray.shuffle() -> barajea aleatoriamente los elementos

// TRANSFORMAR UN ARRAY A UNA COLECCIÓN
val sumList = sumArray.toList()
val sumSet = sumArray.toSet()
// TRANSFORMAR UN ARRAY A UN MAP
// Solamente un array de clave-valor puede ser transformado a un map
val fruits = arrayOf("manzana" to 35, "pera" to 40, "sandia" to 100, "fresa" to 90)
val fruitsMap = fruits.toMap()