package org.tempest.concepts

// ******** STRINGS ********
val textOne = "hello world"
val textOnerUpperCase = textOne.uppercase()

// STRING MULTI-LINEA
var paragraphOne = """
        for (c in paragraph) {
            println(c)
        }
    """

// TEMPLATE STRING
val paragraphTwo = "hello"
// $ -> imprime el valor de la variable
// ${} -> sirve para operaciones y mostar su valor
// print("longitud de $paragraphTwo es: ${paragraphTwo.length}")

// FORMATO DE STRINGS
// Formats to add zeroes and make a length of seven
val integerNumber = String.format("%07d", 31416)
// 0031416

// Formats with four decimals and sign
val floatNumber = String.format("%+.4f", 3.141592)
// +3.1416

// Formats with uppercase for two placeholders
val helloString = String.format("%S %S", "hello", "world")
// HELLO WORLD

fun String.isPalindrome(): Boolean {
    var stringLowerCase = this.lowercase()
    var l = 0
    var r = stringLowerCase.length - 1

    while (l <= r) {
        if (stringLowerCase[l] != stringLowerCase[r]) {
            return false
        }
        l++
        r--
    }
    return true
}

infix fun String.isAnagram(s: String): Boolean {
    val thisLowerCase = this.lowercase()
    val otherLowerCase = s.lowercase()

    if (thisLowerCase.length != otherLowerCase.length) return false

    var charCountMap = mutableMapOf<Char, Int>()

    for (char in thisLowerCase) {
        if (charCountMap.containsKey(char))
            charCountMap[char] = charCountMap.getOrDefault(char, 0) + 1
    }

    for (char in otherLowerCase) {
        if (charCountMap.containsKey(char)) {
            charCountMap[char] = charCountMap.getOrDefault(char, 0) - 1
        }
    }
    return charCountMap.values.all { it == 0 }
}

fun String.isIsogram(): Boolean {
    val lowerCaseString = this.lowercase()
    val seenCharacters = mutableSetOf<Char>()

    for (letter in lowerCaseString) {
        if (letter.isLetter()) {
            if (letter in seenCharacters) return false
            seenCharacters.add(letter)
        }
    }

    return true
}

fun analyzeString(s1: String, s2: String) {
    // palindromo
    if (s1.isPalindrome()) { print("$s1 es un palidromo") }
    if (s2.isPalindrome()) { print("$s2 es un palindromo") }

    // anagrama
    if (s1 isAnagram s2) { print("$s1 es un anagrama de $s2") }

    // isograma
    if (s1.isIsogram()) { print("$s1 es un isograma") }
    if (s2.isIsogram()) { print("$s2 es un isograma") }
}