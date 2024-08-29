package org.tempest.roadmap.fileManagement

import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

const val FILE_NAME = "src/resources/my_file.txt"

fun createFile(fileName: String) {
   val file = File(fileName)

   if (file.createNewFile()) {
      println("Archivo creado: ${file.name}")
   } else {
      println("El archivo ya existe.")
   }
}

fun writeToFile(fileName: String, content: String) {
   val file = File(fileName)
   file.writeText(content)
}

fun readFromFile() {
   val path: Path = Paths.get(FILE_NAME)
   try {
       if (Files.exists(path)) {
         val content = Files.readString(path)
          println("Contenido del archivo:\n$content")

          // leer linea por linea
          Files.lines(path).use { lines ->
             println("Contenido línea por línea:")
             lines.forEach { println(it) }
          }
       } else {
          println("El archivo no existe en la ruta especificada: $path")
       }
   } catch (e: IOException) {
      println("Error al leer el archivo: ${e.message}")
   }
}

fun deleteFile(fileName: String) {
   val file = File(fileName)

   if (file.delete()) {
      println("Archivo eliminado: ${file.name}")
   } else {
      println("No se pudo eliminar el archivo")
   }
}

/**
 * Ejemplo Práctico
 * Crea un archivo con el nombre de usuario de GitHub.
 * Escribe en el archivo.
 * Imprime el contenido del archivo.
 * Elimina el archivo.
 **/

fun createFileInformation() {
   val file = File("enriqueSFranco.txt")
   val username = "enriqueSFranco"
   val age = 26
   val programmingLanguages = arrayOf("javascript", "kotlin", "swift", "dart")
   val programmingTanguagesText = programmingLanguages.joinToString(separator = ", ")
   val content = """
      Username: $username
      Edad: $age
      Lenguaje(s) de programación favorito(s): $programmingTanguagesText
   """.trimIndent()

   file.writeText(content)
   println("Archivo creado con éxito en ${file.absolutePath}")
}