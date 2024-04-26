package org.tempest

class Node(val data: Int, var left: Node? = null, var right: Node? = null) {}

class BST {
    var root: Node? = null

    fun insert(data: Int) {
        root = insertNode(root, data)
    }

    private fun insertNode(node: Node?, data: Int): Node {
        if (node == null) {
            return Node(data)
        }
        if (data < node.data) {
            // insert to left
            node.left = insertNode(node.left, data)
        } else {
            node.right = insertNode(node.right, data)
        }
        return node
    }
}

fun main() {
    val values = listOf(5, 1, 3, 4, 2, 7)
    val bst = BST()
    var root: Node? = null

    for (data in values) {
        bst.insert(data)
    }
}
