package org.tempest.designPatterns

/**
 * ============ Patron Singleton ============
 *
 * Un Singleton en Kotlin es una forma orientada a objetos que permite que una clase tenga
 * solo una instancia en el entorno de tiempo de ejecución. Eso significa que puede hacer un punto
 * de acceso global al objeto y controlar la vida útil de la clase.
 *
 * Una clase Singleton Kotlin sirve como un fuerte que controla el acceso a un objeto mientras se
 * asegura de que ningún otro objeto pueda instanciar su copia del objeto. En otras palabras, bloquea
 * otros objetos de usar la nueva palabra clave con la clase singleton.
 *
 * Un Kotlin Object Singleton tiene una característica interesante:
 * Es seguro para los hilos, lo que significa que el proceso de instanciación del Singleton
 * es seguro para ser utilizado en múltiples hilos.
 * Esta capacidad específica le permite realizar y entregar incluso en un entorno de subprocesos múltiples
 **/

/**
 * Kotlin Singleton con Constructor Privado
 *
 * ¿cómo controlas la instanciación de una clase?
 * La respuesta está en usar un 'constructor privado'. Una clase Kotlin Singleton con un
 * constructor privado evita la instanciación de otras clases, haciendo cumplir así la
 * propiedad Singleton.
 **/
class Singleton private constructor() {
    init {
        println("Singleton class invoked")
    }

    companion object {
        private var INSTANCE: Singleton? = null

        fun getInstance(): Singleton? {
            if (INSTANCE == null) {
                println("New instance is created")
                INSTANCE = Singleton()
            }
            return INSTANCE
        }
    }
}

object MySingleton {
    var variableName:String = "Hello! I am a Singleton Object in Kotlin"
    fun accessMe() = "Accessing: $variableName"
}

class DBConnection private constructor(var uri: String) {

    init {
        println("DBConnection class invoked.")
    }

    fun connect(): String {
        return "DB $uri has been connected!"
    }

    fun disconnect(): String {
        return "DB disconnected"
    }

    companion object {
        private var INSTANCE: DBConnection? = null
        fun getInstance(uri: String): DBConnection? {
            if (INSTANCE == null) {
                println("New instance is created!")
                INSTANCE = DBConnection(uri)
            }
            return INSTANCE
        }
    }
}

fun main(args: Array<String>) {
//    val a = MySingleton
//    val b = MySingleton
//    a.variableName = "Singleton in Koltin"
//
//    println(a.variableName)
//    println(b.variableName)
//    println(a)
//    print(b)

    val obj1 = Singleton.getInstance()
    val obj2 = Singleton.getInstance()
}