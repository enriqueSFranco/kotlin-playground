package org.tempest.algorithms.backtracking

// https://leetcode.com/problems/permutations/description/
// nPr=(n!)/(n-r)! <- FORMULA PARA CALCULAR EL TOTAL DE PERMUTACIONES
// nPr=(n!)/[(n-r)!xr!] <-  FORMULA PARA CALCULAR EL TOTAL DE COMBINACIONES

fun backtrack(
    result: MutableList<MutableList<Int>>,
    tmp: MutableList<Int>,
    nums: IntArray
) {
    if (tmp.size == nums.size) {
        result.add(ArrayList(tmp))
        return
    }

    for (num in nums) {
        if (tmp.contains(num)) continue

        tmp.add(num)

        backtrack(result, tmp, nums)

        tmp.removeAt(tmp.size - 1)
    }
}

fun permute(nums: IntArray): List<List<Int>> {
    // 3P3=(3!)/(3-3)! = 6/1 = 6 posibles permutaciones
    val result: MutableList<MutableList<Int>> = ArrayList()

    backtrack(result, ArrayList(), nums)

    return result
}