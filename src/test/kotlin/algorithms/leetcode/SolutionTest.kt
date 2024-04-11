package algorithms.leetcode

import org.junit.jupiter.api.Test
import org.tempest.algorithms.leetcode.Solution
import kotlin.test.assertEquals

class SolutionTest {
    private val solution = Solution()

    @Test
    fun test() {
        assertEquals("/home/foo", solution.simplifyPath("/home//foo"))
        assertEquals("/a/b/c", solution.simplifyPath("/a//b////c/d//././/.."))
        assertEquals("/home", solution.simplifyPath("/home/"))
        assertEquals("/", solution.simplifyPath("/../"))
    }
}