package org.tempest.algorithms.divideAndConquer

fun <T: Comparable<T>> MutableList<T>.quickSortDyV() {
    fun MutableList<T>.partition(fromIndex: Int, toIndex: Int): Int {
        var pivote = this[toIndex]
        var small = fromIndex - 1

        for (k in fromIndex until toIndex) {
            if (this[k] <= pivote) {
                this[small + 1] = this[k].also { this[k] = this[small + 1] }
                small++
            }
        }
        this[small + 1] = this[toIndex].also { this[toIndex] = this[small + 1] }
        return small + 1
    }

    fun MutableList<T>.quickSortDyV(fromIndex: Int, toIndex: Int) {
        if (fromIndex < toIndex) {
            val pivot = partition(fromIndex, toIndex)

            quickSortDyV(fromIndex, pivot - 1)
            quickSortDyV(pivot + 1, toIndex)
        }
    }
    this.quickSortDyV(0, this.size - 1)
}