package org.tempest.algorithms.dynamicProgramming

// https://leetcode.com/problems/climbing-stairs/
fun countStairs(n: Int, current: Int): Int {
    if (current == n) return 1
    if (current > n) return 0 // Si el escalón actual es mayor que el número total de escalones (n), significa que hemos excedido el tope y no hay forma de subir más, por lo que devuelve 0.

    return countStairs(n, current + 1) + countStairs(n, current + 2)
}

fun climbStairsBF(n: Int): Int {
    return countStairs(n, 0)
}

// usando dp
fun climbStairs(n: Int): Int {
    if (n == 1) return 1

    val dp = IntArray(n + 1)
    dp[1] = 1
    dp[2] = 2

    for (i in 3..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    return dp[n]
}