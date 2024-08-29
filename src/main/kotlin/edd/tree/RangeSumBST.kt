package org.tempest.dataStructure.tree

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */



fun rangeSumBST(root: BSTNode?, low: Int, high: Int): Int {
    return root?.let { node ->
        var sum = 0

        if (root.data < low) sum += rangeSumBST(root.left, low, high)

        if (root.data in low .. high) sum += root.data

        if (root.data > high) sum += rangeSumBST(root.right, low, high)
        sum
    } ?: 0
}