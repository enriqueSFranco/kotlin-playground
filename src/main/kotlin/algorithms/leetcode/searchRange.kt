package org.tempest.algorithms.leetcode

enum class Position {
    START, END
}

fun IntArray.findIndex(target: Int, position: Position = Position.START): Int {
    var l = 0
    var r = this.size - 1
    var index = -1

    // Búsqueda Binaria
    while (l <= r) {
        val m = l + (r - l) / 2
        when {
            this[m] == target -> {
                index = m
                if (position == Position.START) // busque en la submatriz izquierda
                    r = m - 1
                else l = m + 1 // busque en la submatriz derecha
            }
            this[m] < target -> l = m + 1
            else -> r = m - 1
        }
    }

    return index
}

fun searchRange(nums: IntArray, target: Int): IntArray {
    if (nums.isEmpty()) return intArrayOf(-1, -1)

    var positions = intArrayOf(nums.findIndex(target), nums.findIndex(target, Position.END))

    return positions
}