package org.tempest.algorithms.backtracking

fun backtrackII(result: MutableList<MutableList<Int>>, tmp: MutableList<Int>, nums: IntArray, used: Array<Boolean>) {
    if (tmp.size == nums.size) {
        result.add(tmp)
        return
    }

    for (i in nums.indices) {
       if (used[i]) continue

        val num = nums[i]
        used[i] = true
        tmp.add(num)

        backtrackII(result, tmp, nums, used)

        used[i] = false
        tmp.removeAt(tmp.size - 1)
    }
}

fun permuteUnique(nums: IntArray): List<List<Int>> {
    val result: MutableList<MutableList<Int>> = ArrayList()

    backtrackII(result, ArrayList(), nums, Array(nums.size) { false })

    return result
}