package org.tempest.dataStructure.queue

import java.util.LinkedList
import java.util.Queue

// https://leetcode.com/problems/implement-stack-using-queues/

data class MyStackNode<T>(val data: T, val next: MyStackNode<T>?)

class MyStack: Queue<Int> by LinkedList() {

    fun push(x: Int) {
        add(x)
        repeat(size - 1) { add(pop()) }
    }

    fun pop(): Int = remove()

    fun top(): Int = first()

    fun empty(): Boolean = isEmpty()
}