package org.tempest

import org.tempest.algorithms.leetcode.BrowserHistory

// TEST
//println(simplifyPath("/a//b////c/d//././/.."))
//println(simplifyPath("/a/./b/../../c/"))
//println(simplifyPath("/home//foo/"))
//println(simplifyPath("/home/"))
//print(simplifyPath("/../"))

fun main() {
    val homepages = listOf<String>("google.com", "facebook.com", "youtube.com")
    val browserHistory = BrowserHistory("leetcode.com")

    for (homepage in homepages)
        browserHistory.visit(homepage)


    browserHistory.showBrowserHistory()
    //println(browserHistory.back(1))
}
