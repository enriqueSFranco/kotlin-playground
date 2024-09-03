package org.tempest.algorithms.dynamicProgramming

import kotlin.math.max

@OptIn(ExperimentalStdlibApi::class)
fun maxProduct(nums: IntArray): Int {
    val N = nums.size
    var leftProduct = 1
    var rightProduct = 1
    var ans = nums[0]

    for (i in 0..<N) {
        leftProduct = if (leftProduct == 0) 1 else leftProduct
        rightProduct = if (rightProduct == 0) 1 else rightProduct

        leftProduct *= nums[i]
        rightProduct *= nums[N - 1 - i]

        ans = max(ans, max(leftProduct, rightProduct))
    }

    return ans
}