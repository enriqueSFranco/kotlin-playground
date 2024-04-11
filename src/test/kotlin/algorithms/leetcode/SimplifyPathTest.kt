package algorithms.leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import org.tempest.algorithms.leetcode.simplifyPath

class SimplifyPathTest {

    @Test
    fun simplifyPathTest() {
        assertEquals("/home/foo", simplifyPath("/home//foo"))
        assertEquals("/a/b/c", simplifyPath("/a//b////c/d//././/.."))
        assertEquals("/home", simplifyPath("/home/"))
        assertEquals("/", simplifyPath("/../"))
    }
}