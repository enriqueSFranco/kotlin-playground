package org.tempest.roadmap.unitTest

import java.time.LocalDate

class Calculator {
    fun sum(a: Double = 0.0, b: Double = 1.0): Double = a + b

    fun subtract(a: Double = 0.0, b: Double = 1.0): Double = a - b

    fun multiply(a: Double = 0.0, b: Double = 1.0): Double = a * b

    fun division(a: Double = 0.0, b: Double = 1.0): Double {
        if (b == 0.0) {
            error("cannot be divided by zero")
        }
        return a / b
    }
}
