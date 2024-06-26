package org.tempest.concepts

/**
 * LAS SEALED CLASS SE USAN MEJOR EN ESTOS ESCENARIOS
 *
 * 1.- Se desea una herencia de clase limitada
 * 2.- Se requiere un diseño seguro para los tipos
 * 3.- Trabajar con API cerradas
 **/

// Manejando diferentes status de respuesta
sealed class Result {
    data class Success(val data: String): Result()
    data class Error(val message: String): Result()
}

fun handleErro(result: Result) {
    when(result) {
        is Result.Success -> println(result.data)
        is Result.Error -> println(result.message)
    }
}

// Manejando diferentes estados de una maquina de estados
sealed class GameState {
    data object Initial: GameState() // el data object mejora la representacion de cadenas de un objeto
    data object Running: GameState()
    data object Pause: GameState()
    object Finish: GameState() { // sin data object se tiene que sobre-escribir el método toString()
        override fun toString() = "Finish"
    }
}

fun handleGameState(gameState: GameState) {
    when(gameState) {
        is GameState.Initial -> println("The game is starting...")
        is GameState.Running -> println("The game is running...")
        is GameState.Pause -> println("The game is paused...")
        is GameState.Finish -> println("The game is finished...")
    }
}

// Manejo de diferentes estados de la UI en aplicaciones de android
sealed class ViewState {
    object Loading: ViewState()
    data class Succes(val data: List<String>): ViewState()
    data class Error(val message: String): ViewState()
}

fun showLoadingIndicator() {
    println("loading...")
}

fun showData(data: List<String>) {
    for(it in data) {
        println(it)
    }
}

fun showError(message: String) {
    println(message)
}

fun handleViewState(viewState: ViewState) {
    when(viewState) {
        is ViewState.Loading -> showLoadingIndicator()
        is ViewState.Succes -> showData(viewState.data)
        is ViewState.Error -> showError(viewState.message)
    }
}

// SEALED CLASS PARA PLANETAS
sealed class Planet(val id: Int) {
    class BasicPlanet(id: Int): Planet(id)
    class PlanetWithSatellites(id: Int, val satellites: List<String>): Planet(id)
}

fun fooPlanet() {
    val mercury = Planet.BasicPlanet(0)
    val earth = Planet.PlanetWithSatellites(2, listOf("Moon"))

}
