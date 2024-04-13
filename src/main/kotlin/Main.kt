package org.tempest

import org.tempest.dataStructure.LinkedList

fun main() {
    val myList = LinkedList<Int>()

    myList.addFirst(8)
    myList.addFirst(9)
    myList.add(10)
    myList.add(11)
    myList.add(12)
    myList.add(100)
    myList.add(2000)
    myList.addLast(1000)

    myList.showList()
    println()
    println("esta vacia? ${myList.isEmptyList()}")
    println("size: ${myList.size()}")
}
