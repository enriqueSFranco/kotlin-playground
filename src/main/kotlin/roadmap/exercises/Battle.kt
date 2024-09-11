package org.tempest.roadmap.exercises

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.coroutines.delay
import kotlin.random.Random

val loggerBattle = KotlinLogging.logger {}

class Superhero(
    val name: String = "Anonymous",
    var health: Int = 100,
    val minDamage: Int = 10,
    val maxDamage: Int = 100,
    val chanceToEvade: Double = 0.25,
    var activatingRegeneration: Boolean = false
) {
    companion object RandomUtils {
        fun generateRandomInt(min: Int, max: Int): Int = Random.nextInt(min, max + 1)

        fun generateRandomBoolean(probability: Double): Boolean = Math.random() < probability

    }
    fun receiveDamage(damage: Int) {
        if (damage >= health) {
            activatingRegeneration = true
            health = 0
            return
        }
        health -= damage
    }

    fun attack(): Int = generateRandomInt(minDamage, maxDamage)

    fun canEvade(): Boolean = generateRandomBoolean(chanceToEvade)

    fun isAlive(): Boolean = health > 0

    fun displayStatus(): String = "$name tiene $health de vida"
}

class Battle(val superheroOne: Superhero, val superheroTwo: Superhero) {
    private var turn = 1

    suspend fun simulate() {
        while (superheroOne.isAlive() && superheroTwo.isAlive()) {
            loggerBattle.info { "Turno $turn" }
            delay(1000)

            executeTurn(superheroOne, superheroTwo)
            if (superheroTwo.isAlive())
                executeTurn(superheroTwo, superheroOne)

            loggerBattle.info { superheroOne.displayStatus() }
            loggerBattle.info { superheroTwo.displayStatus() }

            turn++
        }
        loggerBattle.info { declareWinner() }
    }

    fun executeTurn(attacker: Superhero, defender: Superhero) {
        if (attacker.isAlive()) {
            val damage = attacker.attack()
            loggerBattle.info { "${attacker.name} ataco con un daño de $damage pts" }
            if (defender.canEvade()) {
                loggerBattle.info { "${defender.name} ha esquivado el ataque" }
                return
            }
            if (defender.isAlive())
                defender.receiveDamage(damage)
            if (defender.activatingRegeneration) {
                loggerBattle.info { "Se ha activado el factor de curacion de ${defender.name}" }
                return
            }
        }
    }

    fun declareWinner(): String {
        return when {
            superheroOne.isAlive() -> "¡${superheroOne.name} es el ganador!"
            superheroTwo.isAlive() -> "¡${superheroTwo.name} es el ganador!"
            else -> "¡Hay un empate!"

        }
    }
}