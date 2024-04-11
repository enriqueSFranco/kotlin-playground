package org.tempest.algorithms.leetcode

// https://leetcode.com/problems/sort-the-people/
data class People(val name: String, val height: Int)

fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
    val people = mutableListOf<People>()

    for (i in heights.indices) {
        val person = People(names[i], heights[i])
        people.add(person)
    }

    val sortedPeople = people.sortedByDescending { it.height }

    return sortedPeople.map { it.name }.toTypedArray()
}