package org.tempest

import org.tempest.dataStructure.queue.MyStack

fun main() {
    val myStack = MyStack()

    myStack.push(1)
    myStack.push(2)
    myStack.push(3)

    println("top: ${myStack.top()}")

}
