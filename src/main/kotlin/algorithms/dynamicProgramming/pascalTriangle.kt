package org.tempest.algorithms.dynamicProgramming

fun generate(n: Int): List<List<Int>> {
    val rows = mutableListOf<List<Int>>()

    if (n == 0) return rows

    val firstRow = listOf(1)
    rows.add(firstRow)

    if (n == 1) return rows

    for (i in 1 until n) {
        val prevRow = rows[i - 1]
        val row = mutableListOf(1)

        for (j in 0 until i - 1) row.add(prevRow[j] + prevRow[j + 1])

        row.add(1)

        rows.add(row)
    }

    return rows
}