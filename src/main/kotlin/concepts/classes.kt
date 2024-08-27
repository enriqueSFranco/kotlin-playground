package org.tempest.concepts

import kotlin.math.pow

/**
 * Si una clase no tiene construcor primario, se crea uno vacio y la visivilidad sera public
 * Si una clase no tiene constructor pero se requiere de un constructor privado lo que se hace es lo siguiente
 * class Person private constructor() {}
 * Las clases en kotlin por defecto son final, lo que significa que no se pueden heredar
 *
 * LAS CLASES PUEDEN CONTENER
 * Constructores y bloques inizializadores
 * Funciones
 * Propiedades
 * Clases anidadas e internas
 * Declaracion de objetos
 *
 * */


/**
 * CONSTRUCTORES SECUNDARIOS
 *
 * Clase con dos constructores, uno primario y otro secundario
 * Constructore primario -> Person(val name: String)
 * Constructor secundario -> constructor(name: String, parent: Person)
 * Si la clase tiene un constructor primario, cada constructor secundario necesita delegar al constructor primario
 * ya sea directa o indirectamente a través de otro constructor secundario(s).
 * La delegación a otro constructor de la misma clase se realiza utilizando la palabra clave this
 **/
class Person(val name: String) {
    val children: MutableList<Person> = mutableListOf()

    constructor(name: String, parent: Person) : this(name) {
        parent.children.add(this)
    }
}

// 2do EJEMPLO DE CONSTRUCTORES SECUNDARIOS
class Device(val brand: String, val model: String, val price: Double) {
    constructor(brand: String, model: String) : this(brand, model, 0.0)

    constructor(brand: String) : this(brand, "Unknown", 0.0)
}

// 3er EJEMPLO DE CONSTRUCTORES SECUNDARIOS
class Libro(val title: String, val autor: String) {
    constructor(title: String) : this(title, "Desconocido")
}

/**
 * Clase con constructor primario
 * Las propiedades en el constructor primario son: firstName, lastName y age
 * Las propiedades firstName y lastName tienes valores por defecto y son de lectura
 * Contiene dos propiedades de clase y dos inicializadores
 **/
class SuperHero constructor(
    val name: String = "Batman",
    val secretIdentity: String = "Bruce Wayne",
    var age: Int,  // trailing comma
) {
    // some code
    val superHeroData = "My name is $name ($secretIdentity)".also(::println)

    init {
        println("first initializer block that prints $name")
    }

    val superHeroNameSize = "firstName size is ${name.length}"

    init {
        println("Second initializer block that name size is: ${name.length}")
    }
}

// 2do Ejemplo de constructor primario
class Employee(val name: String = "Anonymous", var salary: Double) {
    fun giveRise(amount: Double) {
        salary += amount
    }

    fun displayInfo() {
        println("Employee Name: $name, Salary: $salary")
    }
}

/**
 * CLASES ABSTRACTAS
 *
 * No pueden ser instanciadas directamente, se debe crear una clase que herede de la clase abstracta y asi poder instanciar
 * Se usa como clase base (plantillas) para que sea usada con otras clases
 * Puede contener: metodos sin implementacion y propiedades abstractos
 * */
abstract class Polygon {
    abstract fun draw()
}

class Hexagon : Polygon() {
    override fun draw() {
        // some code
    }
}

/**
 * Para permitir que un método sea sobre-escrito por clases hijas debemos marcarlo con la palabra clave open. Esnecesario
 * porque, por defecto, los métodos en Kotlin son finales y no pueden ser sobrescritos.
 *
 * La palabra clave (open) permite que la función sea sobreescrita por las subclases.
 *
 * Por otro lado, las clases también necesitan ser marcadas como open si quieres que puedan ser heredadas.
 **/
abstract class Shape {
    open fun area(): Double {
        return 0.0
    }
}

open class Circle(val r: Double) : Shape() {
    override fun area(): Double {
        // TODO("Not yet implemented")
        return Math.PI * r.pow(2.0)
    }
}

open class Triangle(val base: Double, val height: Double) : Shape() {
    override fun area(): Double {
        return base * height / 2
    }
}

open class Square(val l: Double) : Shape() {
    override fun area(): Double {
        return l.pow(2.0)
    }
}

// CREANDO INSTANCIAS DE CLASES
val superHeroeOne = SuperHero("super man", "clark", 32)
val iphone15 = Device("apple", "iphone 15", 32500.00)

open class PaymentGateway {
    open fun processPayment(amount: Double): Boolean {
        print("Procesando el pago de $amount en la pasarela de pago.")
        return true
    }
}

class CreditCardPaymentGateway : PaymentGateway() {
    override fun processPayment(amount: Double): Boolean {
        print("Procesando el pago de $amount con tarjeta de credito.")
        return true
    }
}

class PaypalPaymentGateway : PaymentGateway() {
    override fun processPayment(amount: Double): Boolean {
        print("Procesando el pago de $amount con Paypal.")
        return true
    }
}

fun processPayment(gateway: PaymentGateway, amount: Double) {
    gateway.processPayment(amount)
}

fun testingClasses() {
    val paymentGateways = arrayOf(CreditCardPaymentGateway(), PaypalPaymentGateway())
    val amounts = arrayOf(5_000.00, 25_000.00)

    for ((index, gateway) in paymentGateways.withIndex()) {
        val amount = amounts[index]
        gateway.processPayment(amount)
    }
}