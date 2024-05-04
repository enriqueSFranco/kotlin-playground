package org.tempest.dataStructure.stack

fun largestRectangleArea(heights: IntArray): Int {
    // [2,1,5,6,2,3]
    var maxArea = 0
    for (i in heights.indices) {
        for (j in i until heights.size) {
            var minHeight = Int.MAX_VALUE
            for (k in i..j) {
                minHeight = Math.min(minHeight, heights[k])
            }
            maxArea = Math.max(maxArea, ((j - i + 1) * minHeight))
        }
    }
    return maxArea
}