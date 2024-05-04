package algorithms.leetcode

import org.junit.jupiter.api.Test

import org.tempest.dataStructure.Stack

class StackTest {
    private val storage = Stack<Int>()

    @Test
    fun `push function test`() {
        storage.push(10)
        storage.push(11)
        storage.push(12)

        val expected = intArrayOf(12, 11, 10)
    }
}