import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.tempest.roadmap.unitTest.Calculator
import kotlin.test.assertFailsWith


class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun `should correctly add two positive numbers`() {
        assertEquals(2.0, calculator.sum(1.0, 1.0), "Sum of 1.0 and 1.0 should be 2.0")
    }

    @Test
    fun `should correctly subtract one number from another`() {
        assertEquals(9.0, calculator.subtract(10.0, 1.0), "Subtraction of 1.0 from 1.0 should be 0.0")
    }

    @Test
    fun `should correctly multiply two numbers`() {
        assertEquals(100.0, calculator.multiply(10.0, 10.0), "Multiplication of 2.0 and 2.0 should be 4.0")
    }

    @Test
    fun `should correctly divide one number by another`() {
        assertEquals(2.0, calculator.division(4.0, 2.0), "Division of 4.0 by 2.0 should be 2.0")
    }

    @Test
    fun `should throw an exception when dividing by zero`() {
        assertFailsWith<ArithmeticException> { calculator.division(4.0, 0.0) }
    }
}