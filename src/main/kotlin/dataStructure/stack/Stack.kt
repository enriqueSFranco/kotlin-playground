package org.tempest.dataStructure

import org.tempest.concepts.isNull

data class StackNode<T>(val value: T, var next: StackNode<T>? = null)

interface OurStack<T> {
    fun push(item: T): Unit
    fun pop(): T?
    fun peek(): T?
    fun isEmpty(): Boolean
    fun size(): Int
    fun showStack(): Unit
}

class Stack<T>: OurStack<T> {
    private var head: StackNode<T>? = null
    private var stackSize = 0

    override fun push(item: T) {
        val newNode = StackNode(item)
        newNode.next = head
        head = newNode
        stackSize++
    }

    override fun pop(): T? {
        if (this.isEmpty()) return null

        val poppedData = head?.value
        head = head?.next
        stackSize--
        return poppedData
    }

    override fun peek(): T? = head?.value

    override fun isEmpty(): Boolean = this.head.isNull()

    override fun size(): Int = stackSize

    override fun showStack() {
        var currNode = head

        if(currNode == null) print("stack empty")

        while (currNode != null) {
            print(currNode.value)
            if (currNode.next != null)
                print("->")
            currNode = currNode.next
        }
    }
}