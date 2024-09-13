package org.tempest.roadmap.exercises

import kotlin.system.exitProcess
import io.github.oshai.kotlinlogging.KotlinLogging

/*
 * EJERCICIO:
 * ¡Disney ha presentado un montón de novedades en su D23!
 * Pero... ¿Dónde está Mickey?
 * Mickey Mouse ha quedado atrapado en un laberinto mágico
 * creado por Maléfica.
 * Desarrolla un programa para ayudarlo a escapar.
 * Requisitos:
 * 1. El laberinto está formado por un cuadrado de 6x6 celdas.
 * 2. Los valores de las celdas serán:
 *    - ⬜️ Vacío
 *    - ⬛️ Obstáculo
 *    - 🐭 Mickey
 *    - 🚪 Salida
 * Acciones:
 * 1. Crea una matriz que represente el laberinto (no hace falta
 * que se genere de manera automática).
 * 2. Interactúa con el usuario por consola para preguntarle hacia
 * donde se tiene que desplazar (arriba, abajo, izquierda o derecha).
 * 3. Muestra la actualización del laberinto tras cada desplazamiento.
 * 4. Valida todos los movimientos, teniendo en cuenta los límites
 * del laberinto y los obtáculos. Notifica al usuario.
 * 5. Finaliza el programa cuando Mickey llegue a la salida.
 */

val loggerMickeyEscapeLabyrinth = KotlinLogging.logger {}

// Typesalias
typealias LabyrinthType = Array<Array<String>>

// enums
enum class Command {
    UP,
    RIGHT,
    DOWN,
    LEFT,
    EXIT
}

// Constantes
const val MICKEY = "🐭"
const val EMPTY_CELL = "⬜️"
const val OBSTACLE = "⬛️"
const val EXIT = "🚪"
const val MENU_OPTIONS = """
[w] Move up
[d] Move right
[s] Move down
[a] Move left
[e] Exit
"""

// Definicion del laberinto
var labyrinth: LabyrinthType = arrayOf(
    arrayOf(MICKEY, EMPTY_CELL, OBSTACLE, EMPTY_CELL, EMPTY_CELL, OBSTACLE),
    arrayOf(OBSTACLE, EMPTY_CELL, OBSTACLE, OBSTACLE, EMPTY_CELL, OBSTACLE),
    arrayOf(OBSTACLE, EMPTY_CELL, EMPTY_CELL, OBSTACLE, OBSTACLE, EMPTY_CELL),
    arrayOf(EMPTY_CELL, OBSTACLE, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL),
    arrayOf(EMPTY_CELL, OBSTACLE, OBSTACLE, OBSTACLE, EMPTY_CELL, EMPTY_CELL),
    arrayOf(OBSTACLE, OBSTACLE, EXIT, EMPTY_CELL, EMPTY_CELL, OBSTACLE),
)

// Posicion inicial de MICKEY
var positionMickey = Pair(0,0)

class MickeyEscapeLabyrinth {

    fun displayLabyrinth(labyrinth: LabyrinthType) {
        labyrinth.forEach { line ->
            println(line.joinToString(" "))
        }
    }

    fun isValidMove(row: Int, col: Int): Boolean {
        return row >= 0 && row < labyrinth.size && col >= 0 && col < labyrinth.size && labyrinth[row][col] != OBSTACLE
    }

    fun moveMickey(command: Command) {
        var (row, col) = positionMickey
        var newRow = row
        var newCol = col

        when(command) {
            Command.UP -> newRow--
            Command.LEFT -> newCol--
            Command.DOWN -> newRow++
            Command.RIGHT -> newCol++
            Command.EXIT -> exitProcess(0)
        }

        if (isValidMove(newRow, newCol)) {
            labyrinth[row][col] = EMPTY_CELL
            var newMickeyPosition = Pair(newRow, newCol)
            positionMickey = newMickeyPosition
            if (labyrinth[newRow][newCol] == EXIT) {
                loggerMickeyEscapeLabyrinth.debug {"Congratulations 🥳"}
                exitProcess(0)
            }
            labyrinth[newRow][newCol] = MICKEY
        } else {
            loggerMickeyEscapeLabyrinth.info { "Invalid move" }
        }
    }

    fun startGame() {
        while (true) {
            displayLabyrinth(labyrinth)
            println(MENU_OPTIONS)
            print("Enter a command: ")
            val input = readln().trim().lowercase()

            val command = when(input) {
                "w" -> Command.UP
                "d" -> Command.RIGHT
                "s" -> Command.DOWN
                "a" -> Command.LEFT
                "e" -> Command.EXIT
                else -> {
                    loggerMickeyEscapeLabyrinth.info { "Invalid command" }
                    continue
                }
            }
            moveMickey(command)
        }
    }
}