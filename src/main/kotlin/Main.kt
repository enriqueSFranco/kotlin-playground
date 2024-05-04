package org.tempest

import org.tempest.desingPatterns.EmployeeBuilder

fun main() {
   val employee = EmployeeBuilder.Builder("1", "", 28).build()

    print(employee)
}
