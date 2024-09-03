package org.tempest.roadmap.unitTest

data class Data (
    val name: String,
    val age: Int,
    val birthdayDate: String,
    val programmingLanguages: List<String>
)

fun getData() = Data(
    name = "Enrique",
    age = 26,
    birthdayDate = "02/04/1998",
    programmingLanguages = listOf("javascript", "kotlin", "swift", "dart")
)