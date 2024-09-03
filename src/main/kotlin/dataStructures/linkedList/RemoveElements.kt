package org.tempest.dataStructure.linkedList


fun removeElements(head: ListNode<Int>?, value: Int): ListNode<Int>? {
    val dummy = ListNode(-1)
    dummy.next = head

    var curr: ListNode<Int>? = dummy

    while (curr?.next != null) {
        if (curr.next?.value == value) {
            curr.next = curr.next?.next
        } else curr = curr.next
    }
    return dummy.next
}