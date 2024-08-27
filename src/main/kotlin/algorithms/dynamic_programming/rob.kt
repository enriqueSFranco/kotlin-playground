package org.tempest.algorithms.dynamicProgramming

import kotlin.math.max

// https://leetcode.com/problems/house-robber/
fun rob(nums: IntArray): Int {
    if (nums.size < 2) return nums[0]

    val dp = IntArray(nums.size)
    dp[0] = nums[0]
    dp[1] = max(nums[0], nums[1])

    for (i in 2 until nums.size) {
        dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
    }
    return dp[nums.size - 1]
}


// https://leetcode.com/problems/house-robber-ii/
fun rob2(nums: IntArray): Int {
    val skipLastHouse = IntArray(nums.size - 1)
    val skipFirstHouse = IntArray(nums.size - 1)

    for (i in 0 until nums.size - 1) {
        skipLastHouse[i] = nums[i]
        skipFirstHouse[i] = nums[i + 1]
    }

    val lootSkipLastHouse = rob(skipLastHouse)
    val lootSkipFirstHouse = rob(skipFirstHouse)

    return max(lootSkipLastHouse, lootSkipFirstHouse)
}


// https://leetcode.com/problems/house-robber-iii/
class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun travel(root: TreeNode?): Pair<Int, Int> {
    if (root == null)
        return Pair(0,0)

    val leftNodesChoices = travel(root.left)
    val rightNodesChoices = travel(root.right)

    // steal the root
    val withRoot = root.value + leftNodesChoices.second + rightNodesChoices.second

    // skip the root
    val withOutRoot = max(leftNodesChoices.first, leftNodesChoices.second) + max(rightNodesChoices.first , rightNodesChoices.second)

    return Pair(withRoot, withOutRoot)
}

fun rob3(root: TreeNode?): Int {
    val options = travel(root)

    return max(options.first, options.second)
}