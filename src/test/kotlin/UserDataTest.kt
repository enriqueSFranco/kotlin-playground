import org.junit.jupiter.api.Test
import org.tempest.roadmap.unitTest.getData
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UserDataTest {
    private val data = getData()

    @Test
    fun `should have all the fields`() {
        assertEquals("Enrique", data.name)
        assertEquals("26", data.age.toString())
        assertEquals("02/04/1998", data.birthdayDate)
        assertTrue { data.programmingLanguages.contains("javascript") }
        assertTrue { data.programmingLanguages.contains("kotlin") }
        assertTrue { data.programmingLanguages.contains("swift") }
        assertTrue { data.programmingLanguages.contains("dart") }
    }
}