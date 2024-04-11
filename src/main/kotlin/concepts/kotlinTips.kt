package org.tempest.concepts

// kotlin tips 🚀

data class Fruit(val name: String, val sugar: Int)

fun tipCollectionOne() {
    val fruitsBaskey = listOf<Fruit>(
        Fruit("Apple", 12),
        Fruit("Banana", 11),
        Fruit("Cherry", 9),
        Fruit("Durian", 5),
        Fruit("Lemon", 2)
    ).sortedBy(Fruit::sugar)

    for ((_, fruit) in fruitsBaskey.withIndex()) {
        println("name: ${fruit.name} - sugar: ${fruit.sugar}")
    }

    fruitsBaskey.take(3) // [lemon, durian, cherry]
    fruitsBaskey.takeLast(2) // [banana, apple]

    fruitsBaskey.drop(2) // [cherry, banana, apple]
    fruitsBaskey.dropLast(3) // [lemon, durian]

    // USAR LA FUNCION "PARTITION" PARA DIVIDIR UNA COLECCIÓN DE LISTAS
    val (sweet, superSweet) = fruitsBaskey.partition { it.sugar < 10 }
    // sweet = [lemon, durian, cherry]
    // superSweet = [apple, banana]

    // MÉTODOS DE COLLECTIONS
    val emojis = listOf("🚀", "🎮", "🏀", "🎲", "🚒", "🛸", "🚁")
    val chunkEmojis = emojis.chunked(3) { it.reversed() }

    println(chunkEmojis)

    val windowedEmojis = emojis.windowed(3, 2, true) // chunkSize, step, partialWindow
    println(windowedEmojis)


    val windowedEmojisFlatten = emojis.windowed(3, 2, true).flatten()
    println(windowedEmojisFlatten)

    val namesList = listOf("low", "mel", "cyn").flatMap {
        it.toList()
    }
    println(namesList)

    val countries = listOf("Mexico", "United State", "Spain", "Argentina")
    val capitals = listOf("CDMX", "USA", "Madrid", "Buenos Aires")

    val countryCapitalPairs = countries.zip(capitals) { country, capital ->
        country.uppercase() to capital.lowercase()
    }
    println(countryCapitalPairs)
}

data class Runner(val name: String, val age: Int, val driversLicense: Boolean = false)

fun tipCollectionSecond() {
    val runners = listOf<Runner>(
        Runner("Alice", 25, true),
        Runner("Bob", 30),
        Runner("Charlie", 28, true),
        Runner("David", 22),
        Runner("Eve", 27)
    )

    runners.any { it.driversLicense } // true

    runners.none { it.age < 20 } // false

    runners.all { it.name.length < 10 } // true

    // LISTAS VACIAS
    val nobody = emptyList<Runner>()
    nobody.none { it.driversLicense } // false, no hay elementos que cumplan la condición
    nobody.any { it.age < 20 } // true
    nobody.all { it.name.length < 10 } // true

    // CHUNKS
    val emojis = listOf("🚀", "🎮", "🏀", "🎲", "✈️", "🛸", "🚁")
    val chunkEmojis = emojis.chunked(3) // [[🚀, 🎮, 🏀], [🎲, ✈️, 🛸], [🚁]]
}

fun tipLoopsInKotlin() {
    val fruitsBasket = listOf("apple", "banana", "cherry", "durian")

    for (index in 0..<fruitsBasket.size) {
        val fruit = fruitsBasket[index]
        println("$index: $fruit")
    }

    for (index in 0..fruitsBasket.size - 1) {
        val fruit = fruitsBasket[index]
        println("$index: $fruit")
    }

    for (index in 0..fruitsBasket.lastIndex) {
        val fruit = fruitsBasket[index]
        println("$index: $fruit")
    }

    for ((index, fruit) in fruitsBasket.withIndex()) {
        println("$index: $fruit")
    }

    for (index in 0 until fruitsBasket.size) {
        val fruit = fruitsBasket[index]
        println("$index: $fruit")
    }
}


// PARA UNA DATA CLASS EL COMPILAR DE KOTLIN GENERA UNA COMPONENT_N FUNCTION PARA CADA PROPIEDAD DECLARADA EN EL CONSTRUCTOR PRIMARIO
class Vector(val x: Double, val y: Double) {
    operator fun component1(): Double = x

    operator fun component2(): Double = y
}

data class People(val name: String, val hobby: String)

fun tipDestructuringDeclarations() {
    val pair = "gold" to 1
    val (metal, placement) = pair

    // DESTRUCTURANDO UNA LISTA
    val fruitsBasket = listOf("apple", "banana", "cherry")
    val (fistt, second, third) = fruitsBasket

    // DESTRUCTURANDO UN MAPA
    val medals = mapOf(
        1 to "GOLD",
        2 to "SILVER",
        3 to "BRONZE"
    )

    for ((key, value) in medals) {
        print("$key: $value")
    }

    for ((_, value) in medals) {
        print("value: $value")
    }

    for (value in medals.values) {
        print("value: $value")
    }

    // DESTRUCTURANDO UNA DATA CLASE
    val kirito = People("kirito", "gamer")
    val (name, hobby) = kirito // USA LA POSICIÓN PARA DESTRUCTURAR EL OBJETO

    // DESTRUCTURAR UNA CLASE
    val vec1 = Vector(5.0, 10.0)
    val (x, y) = vec1
}

