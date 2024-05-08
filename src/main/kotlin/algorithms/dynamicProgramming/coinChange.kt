package org.tempest.algorithms.dynamicProgramming

// https://leetcode.com/problems/coin-change/

fun coinChangeDP(coins: IntArray, amount: Int): Int {
    return 0
}

// SOLUCIÓN USANDO GREEDY
fun coinChange(coins: IntArray, amount: Int): Int {
    // intArrayOf(186,419,83,408), amount = 6249
    coins.sortDescending()
    var _amount = amount
    var change = IntArray(coins.size) { 0 }
    var i = 0

    while (_amount != 0 && i < coins.size) {
        while (coins[i] <= _amount) {
            //println("${coins[i]}, $_amount")
            _amount -= coins[i]
            change[i] += 1
        }
        i++
    }
    println(change.joinToString(" "))
    return if (_amount != 0) -1 else change.sum()
}