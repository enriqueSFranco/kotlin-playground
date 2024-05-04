package org.tempest.algorithms.leetcode

// https://leetcode.com/problems/koko-eating-bananas/
fun minEatingSpeed(piles: IntArray, h: Int): Int {
    fun canEatInTime(piles: IntArray, k: Int): Boolean {
        var hours = 0
        for (bananas in piles) {
            hours += (bananas + k - 1) / k
        }
        return  hours <= h
    }

    var minSpeed = 1
    var maxSpeed = piles.maxOrNull() ?: 0

    while (minSpeed <= maxSpeed) {
        val middle = minSpeed + (maxSpeed - minSpeed) / 2

        if(canEatInTime(piles, middle))
            maxSpeed = middle - 1
        else minSpeed = middle + 1

    }
    return minSpeed
}