package org.tempest.concepts

/**
 * CLASES DE DATOS
 * Se usan principalmente para contener datos
 *
 * 1.- El constructor primario debe tener al menos un parámetro.
 * 2.- Todos los parámetros del constructor primario deben marcarse como val o var.
 * 3.- Las clases de datos no pueden ser abstractas, abiertas, selladas o internas.
 **/

// DECLARACIÓN DE UNA DATA CLASS
data class Task(val id: Int = 0, val description: String = "", var isComplete: Boolean = false)

// USO
fun dataClassTest() {
    val task1 = Task(1001, "Replace Fuel Tank Filler Caps", false)

    print(task1.toString())

    // FUNCIÓN COPY -> Se crear para copiar un objeto y modificar alguna de sus propiedades y mantiene el resto sin cambios
    val copyTask1 = task1.copy(isComplete = true)
    print(task1.toString())

    // DESTRUCTURACÓN
    val (id, description, isComplete) = task1

    // CONSTRUCTOR VACIO
    val task2 = Task()
}