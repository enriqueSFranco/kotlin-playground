package org.tempest.algorithms.leetcode

data class Tweet(val userId: Int, val tweetId: Int)

class Twitter {
    private val tweets = hashMapOf<Int, ArrayList<Tweet>>()

    fun postTweet(userId: Int, tweetId: Int) {
        if (!tweets.contains(tweetId)) tweets[userId] = ArrayList<Tweet>()
        tweets[userId]?.add(Tweet(userId, tweetId))
    }

    fun getNewsFeed(userId: Int): List<Int> {
        return emptyList()
    }

    fun follow(followerId: Int, followeeId: Int) {

    }

    fun unfollow(followerId: Int, followeeId: Int) {

    }
}