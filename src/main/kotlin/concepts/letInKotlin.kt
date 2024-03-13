package org.tempest.concepts

data class Employee(val name: String, val job: String?)

fun testEmployee() {
    val e = Employee("Toby", "software engineer")

    // let evita hacer este tipo de cosas
    // val name = e.name
    // name.length
    // name.uppercase()
    // name.trim()

    e.name.let { name ->
        println(name.length)
        println(name.trim())
        println(name.uppercase())
    }
}