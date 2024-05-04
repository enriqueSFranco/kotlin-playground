package org.tempest.dataStructure.tree

class Node(val data: Int, var left: Node? = null, var right: Node? = null) {}

interface IBST {
    fun insert(data: Int)
    fun search(key: Int): Boolean
    fun isleaf(node: Node?): Boolean
    fun delete(key: Int): Node?
    fun inOrderTraversal(node: Node?)
    fun preOrderTraversal(node: Node?)
    fun postOrderTraversal(node: Node?)
}

class BinarySearchTree: IBST {
    var root: Node? = null

    override fun isleaf(node: Node?) = root != null && root?.left == null && root?.right == null

    override fun insert(data: Int) {
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

    override fun search(key: Int): Boolean {
        return searchNode(root, key)
    }

    private fun searchNode(node: Node?, key: Int): Boolean {
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

    override fun delete(key: Int): Node? {
        return deleteNode(root, key)
    }

    private fun deleteNode(node: Node?, key: Int): Node? {
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

    fun minValue(node: Node?): Node? {
        if (node == null)  return null

        var min = node.data
        var curr = node
        while (curr != null) {
            curr.left?.let { min = it.data }
            curr = node.left
        }
        return null
    }

    override fun inOrderTraversal(node: Node?) {
        if (node != null) {
            inOrderTraversal(node.left)
            print(node.data)
            inOrderTraversal(node.right)
        }
        return
    }

    override fun preOrderTraversal(node: Node?) {
        if (node != null) {
            print(node.data)
            preOrderTraversal(node.left)
            preOrderTraversal(node.right)
        }
        return
    }

    override fun postOrderTraversal(node: Node?) {
        if (node != null) {
            postOrderTraversal(node.left)
            postOrderTraversal(node.right)
            print(node.data)
        }
        return
    }
}
