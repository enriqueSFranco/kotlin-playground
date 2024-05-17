package org.tempest.algorithms.leetcode

// https://leetcode.com/problems/spiral-matrix/

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val spiralMatrix = mutableListOf<Int>()
    if (matrix.isEmpty()) return spiralMatrix

    var colBegin = 0
    var colEnd = matrix[0].size - 1
    var rowBegin = 0
    var rowEnd = matrix.size - 1

    while (colBegin <= colEnd && rowBegin <= rowEnd) {
        for (col in colBegin .. colEnd) // Traverse right
            spiralMatrix.add(matrix[rowBegin][col])
        rowBegin++

        for (row in rowBegin .. rowEnd) // Traverse down
            spiralMatrix.add(matrix[row][colEnd])
        colEnd--

        if (rowBegin <= rowEnd) // Traverse left
            for (col in colEnd downTo colBegin)
                spiralMatrix.add(matrix[rowEnd][col])
        rowEnd--

        if (colBegin <= colEnd)  // Traverse up
            for (row in rowEnd downTo rowBegin)
                spiralMatrix.add(matrix[row][colBegin])
        colBegin++
    }

    return  spiralMatrix
}