package org.tempest.algorithms.recursividad

import org.tempest.dataStructure.linkedList.ListNode

fun log(x: Int) {
    if (x <= 10) {
        println(x)
        log(x + 1)
    }
}

fun iterativeFactorial(n: Int): Int {
    var r = 1
    var i = 2

    while (i <= n) {
        r *= i
        i += 1
    }
    return r
}

fun recursiveFactorial(n: Int): Int {
    if (n == 0) return 1

    return n * recursiveFactorial(n - 1)
}

fun reverseList(head: ListNode<Int>?): ListNode<Int>? {
    if (head == null || head.next == null) return head

    var newHead = reverseList(head.next)
    head.next?.next = head
    newHead?.next = null

    return newHead
}

fun recursiveFibonacci(n: Int): Int {
    // 1, 1, 2, 3, 5, 8, 13, ...
    return when {
        n <= 1 -> n
        else -> recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2)
    }
}

fun recursivePrintNumbers(from: Int, to: Int) {
    if (from > to) return
    print(from)
    recursivePrintNumbers(from + 1, to)
}

fun isPowerOfFour(n: Int): Boolean {
    if (n <= 0 || (n and (n - 1) != 0)) return false
    return (n and 0x55555555.toInt()) != 0
}

fun recursiveIsPowerOfFour(n: Int): Boolean {
    if (n <= 0) return false
    if (n == 1) return true
    return recursiveIsPowerOfFour(n / 4)
}

fun isPowerOfThree(n: Int): Boolean {
//    if (n < 1) return false
//    var _n = n
//    while (_n % 3 == 0) _n /= 3
//
//    return _n == 1
    if (n < 1) return false
    if (n == 1) return true
    return n % 3 == 0 && isPowerOfThree(n / 3)
}

fun zeros(n: Int): Int {
//    var count = 0
//    var divisor = 5
//
//    while (n >= 0) {
//        count += n / divisor
//        divisor *= 5
//    }
//    return count
    return if (n > 0) n / 5 + zeros(n / 5) else 0
}