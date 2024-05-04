package org.tempest.dataStructure.linkedList

data class DLLNode<T>(var prev: DLLNode<T>? = null, val data: T, var next: DLLNode<T>? = null )

class DoubleLinkedList<T> {
    private var head: DLLNode<T>? = null
    private var size = 0

    fun insertFront(item: T) {
        val newNode = DLLNode(data = item)
        newNode.next = head
        newNode.prev = null

        if (head != null)
            head?.prev = newNode

        head = newNode
    }
}