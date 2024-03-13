package org.tempest.concepts

enum class BeerBrand(val alcoholLevel: Double) {
    CORONA(4.53), // -> ordinal = 0
    NEGRA_MODELO(5.25), // -> ordinal = 1
    MODELO_ESPECIAL(5.25), // -> ordinal = 2
    VICTORIA(3.91), // -> ordinal = 3
    BARRILITO(3.56), // -> ordinal = 4
    INDIO(4.05), // -> ordinal = 5
    TECATE_LAGER(4.64); // -> ordinal = 6

    val mexicanBeers = "Mexican"
}

val brand: Double = BeerBrand.CORONA.alcoholLevel
val brandIndex = BeerBrand.VICTORIA.ordinal // devuelve la posición en la que se encuentra la key
val brandStr = BeerBrand.BARRILITO.name // devuelve el valor de la key en string
fun describe(beerBrand: BeerBrand) = when (beerBrand) {
    BeerBrand.CORONA -> "Corona"
    BeerBrand.INDIO -> "Indio"
    BeerBrand.TECATE_LAGER -> "Tecate Lager"
    BeerBrand.BARRILITO -> "Barrilito"
    BeerBrand.VICTORIA -> "Victoria"
    BeerBrand.NEGRA_MODELO -> "Negra Modelo"
    BeerBrand.MODELO_ESPECIAL -> "Modelo Especial"
}