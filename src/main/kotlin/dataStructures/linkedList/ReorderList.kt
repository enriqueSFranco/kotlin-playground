package org.tempest.dataStructure.linkedList

fun reorderList(head: ListNode<Int>?): Unit {
    // find middle
    var slow = head
    var fast = head

    while (slow != null && fast?.next?.next != null) {
        slow = slow.next
        fast = fast.next?.next
    }
    // reverse list
    var middleNode: ListNode<Int>? = slow
    var currNode = slow?.next

    while (currNode != null) {
        val nextNode = currNode.next
        currNode.next = currNode.next
        nextNode?.next = middleNode?.next
        middleNode?.next = nextNode
    }
    slow = head
    fast = middleNode?.next

    // join list

}