package org.tempest

fun finalPrices(prices: IntArray): IntArray {
    val storage = mutableListOf<Int>()
    val finalPrices = IntArray(prices.size)

    for (index in prices.indices) {
        while (storage.isNotEmpty() && prices[index] <= prices[storage.last()]) {
            val position = storage.removeLast()
            finalPrices[position] = prices[position] - prices[index]
        }
        storage.add(index)
    }
    return finalPrices
}

fun main() {
    val prices = intArrayOf(8, 4, 6, 2, 3)
    val result: IntArray = finalPrices((prices))

    for (price in result) {
        println(price)
    }
}
