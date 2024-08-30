package org.tempest.dataStructure.tree

class BSTNode(val data: Int, var left: BSTNode? = null, var right: BSTNode? = null) {}

interface IBST {
    fun insert(data: Int)
    fun search(key: Int): Boolean
    fun isleaf(node: BSTNode?): Boolean
    fun delete(key: Int): BSTNode?
    fun inOrderTraversal(node: BSTNode?)
    fun preOrderTraversal(node: BSTNode?)
    fun postOrderTraversal(node: BSTNode?)
}

class BinarySearchTree: IBST {
    var root: BSTNode? = null

    override fun isleaf(node: BSTNode?) = root != null && root?.left == null && root?.right == null

    override fun insert(data: Int) {
        root = insertNode(root, data)
    }

    private fun insertNode(node: BSTNode?, data: Int): BSTNode {
        if (node == null) {
            return BSTNode(data)
        }
        if (data < node.data) {
            // insert to left
            node.left = insertNode(node.left, data)
        } else {
            node.right = insertNode(node.right, data)
        }
        return node
    }

    override fun search(key: Int): Boolean {
        return searchNode(root, key)
    }

    private fun searchNode(node: BSTNode?, key: Int): Boolean {
        if (node == null) return false

        if (node.data == key) return true

        return if (node.data > key) {
            // buscar en el sub-árbol izquierdo
            searchNode(node.left, key)
        } else {
            // buscar en el sub-árbol derecho
            searchNode(node.right, key)
        }
    }

    override fun delete(key: Int): BSTNode? {
        return deleteNode(root, key)
    }

    private fun deleteNode(node: BSTNode?, key: Int): BSTNode? {
        if (node == null) return null

        if (key < node.data) {
            node.left = deleteNode(node.left, key)
        } else if (key > node.data) {
            node.right = deleteNode(node.right, key)
        } else {
            // CASE 1: IS LEAF
            if (isleaf(node)) {
                return null
            } else if (node.left == null) { // CASE 2: ONE CHILD
                return node.right
            } else if (node.right == null){
                return node.left
            } else { // CASE 3: TWO CHILDREN

            }
        }
        return null
    }

    fun minValue(node: BSTNode?): BSTNode? {
        if (node == null)  return null

        var min = node.data
        var curr = node
        while (curr != null) {
            curr.left?.let { min = it.data }
            curr = node.left
        }
        return null
    }

    override fun inOrderTraversal(node: BSTNode?) {
        if (node != null) {
            inOrderTraversal(node.left)
            print(node.data)
            inOrderTraversal(node.right)
        }
        return
    }

    override fun preOrderTraversal(node: BSTNode?) {
        if (node != null) {
            print(node.data)
            preOrderTraversal(node.left)
            preOrderTraversal(node.right)
        }
        return
    }

    override fun postOrderTraversal(node: BSTNode?) {
        if (node != null) {
            postOrderTraversal(node.left)
            postOrderTraversal(node.right)
            print(node.data)
        }
        return
    }
}
