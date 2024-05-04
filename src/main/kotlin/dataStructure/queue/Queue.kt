package org.tempest.dataStructure

data class QueueNode<T>(val value: T, var next: QueueNode<T>? = null)

interface OurQueue<T> {
    fun enqueue(item: T): Unit
    fun dequeue(): T?
    fun queueIsEmpty(): Boolean
    fun peek(): T?
    fun getTail(): T?
    fun size(): Int
    fun showQueue(): Unit
}

class Queue<T>: OurQueue<T> {
    private var head: QueueNode<T>? = null
    private var tail: QueueNode<T>? = null
    private var size = 0

    override fun enqueue(item: T) {
        val newNode = QueueNode(item)
        if (head == null) {
            head = newNode
            tail = newNode
        }

        tail?.next = newNode
        tail = newNode
        size++
    }

    override fun dequeue(): T? {
        if (this.queueIsEmpty()) return null

        val deletedItem = head?.value
        head = head?.next

        if (head == null)
            tail = null
        size--

        return  deletedItem
    }

    override fun queueIsEmpty(): Boolean = head == null

    override fun peek(): T? = head?.value

    override fun getTail(): T? = tail?.value

    override fun size(): Int = size

    override fun showQueue() {
        var curr = head

        while (curr != null) {
            print(curr.value)
            if (curr.next != null)
                print("->")
            curr = curr.next
        }
    }
}