package org.tempest.dataStructure

data class ListNode<T>(val value: T, var next: ListNode<T>? = null)

interface OutLinkedList<T> {
    fun add(item: T)
    fun addFirst(item: T)
    fun addLast(item: T)
    fun addAt(index: Int, item: T)
    fun removeFirst(): T?
    fun removeLast(): T?
    fun removeAt(index: Int): T?
    fun removeAll()
    fun size(): Int
    fun isEmptyList(): Boolean
    fun showList()
}

class LinkedList<T>: OutLinkedList<T> {
    private var head: ListNode<T>? = null
    private var tail: ListNode<T>? = null
    private var listSize = 0

    private inline fun withInitializedList(item: T, callback: (ListNode<T>) -> Unit) {
        var node = ListNode(item)
        if (head == null) {
            head = node
            tail = node
        } else {
            callback(node)
        }
        listSize++
    }

    override fun isEmptyList(): Boolean = head == null

    override fun add(item: T) {
        withInitializedList(item) { node ->
            tail?.next = node
            tail = node
        }
    }

    override fun addFirst(item: T) {
        withInitializedList(item) { node ->
            node.next = head
            head = node
        }
    }

    override fun addLast(item: T) {
        withInitializedList(item) { node ->
            tail?.next = node
            tail = node
        }
    }

    override fun addAt(index: Int, item: T) {
        if (index < 0) return

        if (index == 0) {
            addFirst(item)
            return
        }

        withInitializedList(item) { node ->
            var prev = head
            for (i in 0 until index) {
                prev = prev?.next
                if (prev == null) return
            }

            println("prev node: ${prev?.value}")
            node.next = prev?.next
            prev?.next = node
        }
    }

    override fun removeAll() {
        head = null
        tail = null
        listSize = 0
    }

    override fun removeLast(): T? {
        if (this.isEmptyList()) return null

        if (head?.next == null) {
            val removedItem = head?.value
            removeAll()
            return  removedItem
        }

        var prev = head
        var curr = head?.next

        while (curr?.next != null) {
            prev = curr
            curr = curr.next
        }

        val removedItem = curr?.value

        prev?.next = null
        tail = prev
        listSize--

        return removedItem
    }

    override fun removeFirst(): T?  {
        if (this.isEmptyList()) return null

        if (head?.next == null) {
            val removedItem = head?.value
            removeAll()
            return removedItem
        }
        val removedItem = head?.value
        head = head?.next
        listSize--

        return removedItem
    }

    override fun removeAt(index: Int): T? {
        if (this.isEmptyList() || index < 0 || index > listSize) return null

        if (index == 0) return removeFirst()

        var prev: ListNode<T>? = null
        var curr = head
        var currIdx = 0

        while (currIdx < index) {
            prev = curr
            curr = curr?.next
            currIdx++
        }

        prev?.next = curr?.next

        if (tail == null) tail = prev
        listSize--

        return curr?.value
    }

    override fun size(): Int = listSize

    override fun showList() {
        var curr = head
        while(curr != null) {
            print(curr.value)
            if (curr.next != null) print("->")
            curr = curr.next
        }
    }
}