package org.tempest.algorithms.recursividad

import org.tempest.dataStructure.linkedList.ListNode

fun log(x: Int) {
    if (x <= 10) {
        println(x)
        log(x + 1)
    }
}

fun factorial(n: Int): Int {
    if (n == 0) return 1

    return n * factorial(n - 1)
}

fun reverseList(head: ListNode<Int>?): ListNode<Int>? {
    if (head == null || head.next == null) return head

    var newHead = reverseList(head.next)
    head.next?.next = head
    newHead?.next = null

    return newHead
}