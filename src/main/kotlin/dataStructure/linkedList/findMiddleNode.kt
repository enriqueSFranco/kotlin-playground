package org.tempest.dataStructure.linkedList

fun findMiddleNode(head: ListNode<Int>?): ListNode<Int>? {
    var fast = head
    var slow = head

    while (fast != null && fast.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    return slow
}