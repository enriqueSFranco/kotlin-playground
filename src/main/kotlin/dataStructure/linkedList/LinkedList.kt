package org.tempest.dataStructure

data class ListNode<T>(val value: T, var next: ListNode<T>? = null)

interface OutLinkedList<T> {
    fun add(item: T)
    fun addFirst(item: T)
    fun addLast(item: T)
    fun addAt(item: T, index: Int)
    fun removeFirst(item: T)
    fun removeLast(item: T)
    fun removeAt(item: T)
    fun removeAll(item: T)
    fun size(): Int
    fun isEmptyList(): Boolean
    fun showList()
}

class LinkedList<T>: OutLinkedList<T> {
    private var head: ListNode<T>? = null
    private var tail: ListNode<T>? = null
    private var sizeList = 0

    override fun isEmptyList(): Boolean = head == null

    override fun add(item: T) {
        var node = ListNode(item)
        if (head == null) {
            head = node
            tail = node
        }
        tail?.next = node
        tail = node
        sizeList++
    }

    override fun addFirst(item: T) {
        val node = ListNode(item)
        if (head == null) {
            head = node
            tail = node
        }
        node.next = head
        head = node
    }

    override fun addLast(item: T) {
        val node = ListNode(item)
        if (head == null) {
            head = node
            tail = node
        }
        tail?.next = node
        tail = node
    }

    override fun addAt(item: T, index: Int) {
        TODO("Not yet implemented")
    }

    override fun removeAll(item: T) {
        TODO("Not yet implemented")
    }

    override fun removeLast(item: T) {
        TODO("Not yet implemented")
    }

    override fun removeFirst(item: T) {
        TODO("Not yet implemented")
    }

    override fun removeAt(item: T) {
        TODO("Not yet implemented")
    }

    override fun size(): Int = sizeList

    override fun showList() {
        var curr = head
        while(curr != null) {
            print(curr.value)
            if (curr.next != null) print("->")
            curr = curr.next
        }
    }
}