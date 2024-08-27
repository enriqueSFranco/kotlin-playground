package org.tempest.algorithms.dynamicProgramming

import kotlin.math.min

// https://leetcode.com/problems/coin-change/
fun coinChange(coins: IntArray, amount: Int): Int {
    if (amount < 1) return 0

    val minCoinsDP = IntArray(amount + 1)

    for (i in 1..amount) {
        minCoinsDP[i] = Int.MAX_VALUE // indica que inicialmente no se ha encontrado ninguna forma de alcanzar el monto.

        for (coin in coins) {
            if (coin <= i && minCoinsDP[i - coin] != Int.MAX_VALUE) {
                minCoinsDP[i] = min(minCoinsDP[i], 1 + minCoinsDP[i - coin])
            }
        }
    }
    if (minCoinsDP[amount] == Int.MAX_VALUE)
        return -1

    return minCoinsDP[amount]
}