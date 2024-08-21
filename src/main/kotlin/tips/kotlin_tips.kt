package org.tempest.tips

import kotlin.random.Random

fun kotlinListTip() {
    List(5) {idx -> "No. $idx"} // [No. 0, No. 1, No. 2, No. 3, No. 4]

    val arrarCharacters = "hello-world".toList() // [h, e, l, l, o, -, w, o, r, l, d]

    val medals = mapOf(
        1 to "gold",
        2 to "silver",
        3 to "bronze"
    ).toList() // [(1, gold), (2, silver), (3, bronze)]

    generateSequence {
        Random.nextInt(100).takeIf { it > 30 }
    }

    val food = listOf("🍔", "🌭", "🌮")
    val taco = food[2] // 🌮
    val lastTaco = food.last() // 🌮
    val hotdog = food.get(1) // 🌭
    val getPizza = food.getOrNull(4) // null
    val getSoda = food.getOrElse(4) { println("No se encuentra el indice $it") }

    val m = mutableListOf(1,2,3,3,3,4,4,4)
    // ADD
    m.add(4) // 1,2,3,3,3,4,4,4,4
    m += 10 // 1,2,3,3,3,4,4,4, 4, 10
    m.add(0, 100) // 100, 1,2,3,3,3,4,4,4, 4, 10
    m += listOf(200, 300, 400) // 100, 1,2,3,3,3,4,4,4, 4, 10, 200, 300, 400

    // REMOVE
    m.remove(3) // 100, 1,2,3,3,4,4,4, 4, 10, 200, 300, 400
    m -= 3 // 100, 1,2,3,4,4,4, 4, 10, 200, 300, 400

    // ELIMINAR TODAS LAS INSTANCIAS DEL LOS NUMERO 4
    m -= listOf(4) // 100, 1,2,3, 10, 200, 300, 400

    // ELIMINAR POR INDICE
    m.removeAt(4) // removed = 10
}