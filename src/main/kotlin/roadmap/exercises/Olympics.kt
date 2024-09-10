package org.tempest.roadmap.exercises

import io.github.oshai.kotlinlogging.KotlinLogging

val logger = KotlinLogging.logger {}

const val MINIMUM_PARTICIPANTS = 3

enum class Medal {
    GOLD, SILVER, BRONZE
}

val MEDALS = mapOf<Medal, String>(
    Medal.GOLD to "🥇",
    Medal.SILVER to "🥈",
    Medal.BRONZE to "🥉"
)

data class Participant(val name: String, val country: String)

typealias ListOfParticipants = MutableList<Participant>
typealias MapOfEvents = MutableMap<String, SportingEvent>

class SportingEvent(val name: String) {
    private val _participants: ListOfParticipants
    val participants: ListOfParticipants
        get() = _participants
    private val _results: MutableMap<Medal, Participant>
    val results: MutableMap<Medal, Participant>
        get() = _results

    init {
        _participants = mutableListOf()
        _results = mutableMapOf()
    }

    fun addParticipant(participant: Participant) {
        logger.info { "Agregando participante" }
        _participants.add(participant)
    }

    fun simulateSportingEvent() {
        if (_participants.size < MINIMUM_PARTICIPANTS) {
            logger.warn { "No hay sufientes participantes para iniciar el evento" }
            return
        }
        val shuffledParticipants = _participants.shuffled()
        val winners = shuffledParticipants.subList(0, 3)
        val medals = Medal.entries.sortedBy { it.ordinal }

        for (i in medals.indices) {
            _results.put(medals[i], winners[i])
            // println("${MEDALS[medals[i]]}: ${winners[i]}")
        }
    }
}

class Olympics {
    private val sportingEvents: MapOfEvents = mutableMapOf()

    fun registerParticipant(eventName: String, participant: Participant): Boolean {
        val (name) = participant

        if (name.isBlank() || eventName.isBlank()) {
            logger.warn { "Faltan campos por llenar" }
            return false
        }
        val event: SportingEvent? = sportingEvents[eventName]
        if (event != null) {
            if (event.participants.contains(participant)) {
                logger.warn { "El participante ${participant.name} ya existe en el evento '${event.name}'" }
                return false
            }
            event.addParticipant(participant)
            logger.info { "Participante ${participant.name} ha sido registrado correctamente" }
            return true
        }
        logger.warn { "El evento '$eventName' no se econtro, por lo que no se pudo registrar al participante ${participant.name}" }
        return false
    }

    fun registerSportingEvent(eventName: String): Boolean {
        if (eventName.isBlank()) {
            logger.warn { "El evento '$eventName' no puede ir en blanco" }
            return false
        }
        if (sportingEvents.containsKey(eventName)) {
            logger.info { "El evento '$eventName' ya existe, por lo que no se puede crear nuevamente" }
            return false
        }
        sportingEvents.put(eventName, SportingEvent(eventName))
        logger.info { "El evento '$eventName' ha sido registrado correctamente" }
        return true
    }

    fun runAllSportingEvents() {
        for (event in sportingEvents.values)
            event.simulateSportingEvent()
    }

    private fun getResultBySportingEvent() {
        for (event in sportingEvents.values) {
            logger.info { "Evento: ${event.name}" }
            event.results.forEach { (medal, participant) ->
                logger.info { "${MEDALS[medal]} ${participant.country} ${participant.name}" }
            }
        }
    }

    private fun getRankingCountry() {
        val medalsByCountry: MutableMap<String, MutableMap<Medal, Int>> = mutableMapOf()

        for (event in sportingEvents.values) {
            event.results.forEach { medal, winners ->
                val (_, country) = winners
                // obtener o inicializar medallas por pais
                val medals = medalsByCountry.getOrPut(country) {
                    mutableMapOf(Pair(Medal.GOLD, 0), Pair(Medal.SILVER, 0), Pair(Medal.BRONZE, 0))
                }

                when (medal) {
                    Medal.GOLD, Medal.SILVER, Medal.BRONZE  -> {
                        medals[medal] = medals.getOrDefault(medal, 0) + 1
                    }
                    else -> logger.warn { "Error: La medalla '$medal' no esta registrada" }
                }
            }
        }
        val sortedMedalsByCountry = medalsByCountry.toSortedMap()
        logger.info { ">>> $sortedMedalsByCountry" }
    }

    fun generateReport() {
        logger.info { "============ Generando reporte de los juegos olimplicos ============" }

        logger.info { "Resultados de cada evento " }
        getResultBySportingEvent()

        logger.info { "Ranking por pais 🌎" }
        getRankingCountry()
    }
}
