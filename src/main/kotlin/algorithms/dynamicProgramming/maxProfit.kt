package org.tempest.algorithms.dynamicProgramming

import kotlin.math.max

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
fun maxProfitBF(prices: IntArray): Int {
    var profit = 0

    for (i in 0 until prices.size) {
        for (j in i + 1 until prices.size) {
            println("${prices[j]} - ${prices[i]} = ${prices[j] - prices[i]}")
            if (prices[j] - prices[i] > profit) {
                profit = prices[j] - prices[i]
            }
        }
    }
    return profit
}

fun maxProfit(prices: IntArray): Int {
    var buyPrice = prices[0]
    var profit = 0

    for (i in 1 ..< prices.size) {
        if (prices[i]  < buyPrice) {
            buyPrice = prices[i]
        } else {
            var currProfit = prices[i] - buyPrice
            profit = max(currProfit, profit)
        }
    }

    return profit
}