package org.tempest.algorithms.leetcode

import java.util.HashMap
import java.util.PriorityQueue

class Twitter {
    private var  tweets: MutableMap<Int, ArrayList<Tweet>> = HashMap()
    private var followers: MutableMap<Int, MutableSet<Int>> = HashMap()
    private var timestamp: Int = 0

    private data class Tweet(val tweetId: Int, val timestamp: Int)

    fun postTweet(userId: Int, tweetId: Int) {
        if (!tweets.contains(tweetId)) tweets[userId] = ArrayList<Tweet>()
        tweets[userId]?.add(Tweet(tweetId, timestamp++))
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val feeds = mutableListOf<Int>()
        val priorityFeeds = PriorityQueue<Tweet> { a, b -> b.timestamp - a.timestamp }
        val totalFeeds = 10

        // agregamos los tweets del mismo usuario
        tweets[userId]?.let { userTweets -> priorityFeeds.addAll(userTweets) }

        // agregamos los tweets de los usuarios que sigue un determinado usuario
        followers[userId]?.forEach { followee ->
            tweets[followee]?.let { followeeTweets ->
                priorityFeeds.addAll(followeeTweets)
            }
        }

        // recuperamos los primeros 10 tweets mas recientes
        while (feeds.size < totalFeeds && priorityFeeds.isNotEmpty())
            feeds.add(priorityFeeds.poll().tweetId)

        return feeds
    }

    fun follow(followerId: Int, followeeId: Int) {
        followers.putIfAbsent(followerId, HashSet())

        if (followerId != followeeId)
            followers[followerId]?.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        if (followers.containsKey(followerId))
            followers[followerId]?.remove(followeeId)
    }
}