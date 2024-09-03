package org.tempest.concepts

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


fun main() {
    val date = LocalDate.parse("2024-08-30")
    println(date)

    // Obtener fecha actual
    val today = LocalDate.now()
    println("Fecha actual: $today")

    val tomorrow = today.plusDays(1)
    println("Mañana: $tomorrow")

    val yesterday = today.minusDays(1)
    println("Ayer: $yesterday")

    // Crear una fecha especifica
    val specificDate = LocalDate.of(2024, 8, 30)
    println("Fecha especifica: $specificDate")

    // Formatear una fecha
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val formattedDate = specificDate.format(formatter)
    println("Fecha formateada: $formattedDate")

    // Fecha y hora actual
    val now = LocalDateTime.now()
    println("Fecha y hora actual: $now")


    // Extraccion de partes de fechas
    val dayOfMonth = date.dayOfMonth
    println("Dial del mes: $dayOfMonth")
    val month = date.month
    println("Mes: $month")

    // Manejo de zona horaria
    val parisTime = ZonedDateTime.now(ZoneId.of("Europe/Paris"))
    println("Hora en Paris: $parisTime")
    val newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"))
    println("Hora en New York: $newYorkTime")

    // Conversion entre zona horaria
    // 1.- Definimos zona horaria
    val zoneIdFrom = ZoneId.of("America/New_York")
    val zoneIdTo = ZoneId.of("Europe/London")

    // 2.- Obtener la hora actual en la zona horaria de origen
    val nowInSourceZone = ZonedDateTime.now(zoneIdFrom)

    // 3.- Convertir la hora actual a la zona horaria de destino
    val nowInTargetZone = nowInSourceZone.withZoneSameLocal(zoneIdTo)

    // 4.- Formatear
    val f = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss z")
    println("Hora en la zona horaria de origen ($zoneIdFrom): ${nowInSourceZone.format(f)}")
    println("Hora en la zona horaria de destino ($zoneIdTo): ${nowInTargetZone.format(f)}")

    // Duracion y Periodos
    val birthday = LocalDate.of(1996, 4, 2)
    println("Cumpleaños: $birthday")

    val currentDate = LocalDate.now()
    println("Fecha actual: $currentDate")

    val period = Period.between(birthday, currentDate)
    println("Han transcurrido ${period.years} años")

    val formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss")
    val formatter3 = DateTimeFormatter.ofPattern("DDD yyyy") // Día del año y año
    val formatter4 = DateTimeFormatter.ofPattern("EEEE") // Día de la semana
    val formatter5 = DateTimeFormatter.ofPattern("MMMM yyyy") // Nombre del mes y año
    val formatter6 = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val formatter7 = DateTimeFormatter.ofPattern("dd MMM yyyy")
    val formatter8 = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy")
    val formatter9 = DateTimeFormatter.ofPattern("MM/dd/yyyy")
    val formatter10 = DateTimeFormatter.ofPattern("yyyy/MM/dd")

    val separator = "=".repeat(10)
    println("$separator Formatos de fechas $separator")
    println("Formato 1: ${birthday.format(formatter1)}")
    println("Formato 2: ${birthday.atStartOfDay().format(formatter2)}")
    println("Formato 3: ${birthday.format(formatter3)}")
    println("Formato 4: ${birthday.format(formatter4)}")
    println("Formato 5: ${birthday.format(formatter5)}")
    println("Formato 6: ${birthday.format(formatter6)}")
    println("Formato 7: ${birthday.format(formatter7)}")
    println("Formato 8: ${birthday.format(formatter8)}")
    println("Formato 9: ${birthday.format(formatter9)}")
    println("Formato 10: ${birthday.format(formatter10)}")
}