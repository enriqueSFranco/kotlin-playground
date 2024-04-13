package org.tempest

import org.tempest.dataStructure.LinkedList

fun main() {
    val myList = LinkedList<Int>()

    myList.add(1)
   myList.add(2)
    myList.add(3)
    myList.add(5)
    myList.addAt(2, 4)
    myList.addAt(0, 0)
    myList.showList()
    println()
    myList.removeLast()
    myList.removeFirst()

    myList.showList()
    println()
    println("esta vacia? ${myList.isEmptyList()}")
    println("size: ${myList.size()}")
}
