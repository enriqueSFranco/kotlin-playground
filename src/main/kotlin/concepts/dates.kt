package org.tempest.concepts

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.Month
import java.time.format.DateTimeFormatter
import java.time.Duration
import kotlin.math.abs

fun dateAndTimeBasics() {
    // Fecha actual
    val currDate = LocalDate.now()
    // Fecha específica
    val christmas = LocalDate.of(2024, Month.DECEMBER, 24)
    // Hora actual
    val currTime = LocalTime.now()

    println("Fecha actual: $currDate\nNavidad: $christmas\nHora actual: $currTime")
}

fun formattingAndParsing() {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val dateTime = LocalDateTime.parse("2024-05-14 13:58:00", formatter)

    val formatted = dateTime.format(formatter)
    println(formatted)
}

fun dateArithmetic() {
    val currDate = LocalDate.now()
    val nextWeek = currDate.plusWeeks(1)
    val nextYear = currDate.plusYears(1)

    println("next week: $nextWeek\nnext year: $nextYear")
}


// Ejercicio
fun getTimeAgo(dateTimeString: String): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val dateTime = LocalDateTime.parse(dateTimeString, formatter)
    val now = LocalDateTime.now()

    val duration = Duration.between(dateTime, now)
    val seconds = abs(duration.seconds)

    return when {
        seconds < 60 -> "hace unos segundos"
        seconds < 3600 -> "hace ${seconds / 60} minutos"
        seconds < 86400 -> "hace ${seconds / 3600} horas"
        seconds < 2592000 -> "hace ${seconds / 86400} días"
        else -> "hace más de un mes"
    }
}