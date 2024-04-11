package org.tempest.concepts

class CoffieReviwe(
    val name: String,
    val comment: String,
    val stars: Int? // valor nulable
)

val jhonReviwe = CoffieReviwe("Jhon", "Loved the coffee!", 5)
val lucyReview = CoffieReviwe("Lucy", "Pretty good!", 4)
val tobyReview = CoffieReviwe("Toby", "Will buy this again!", 0)
val charlyReview = CoffieReviwe("Charly", "Will buy this again!", null)


fun IntoToLong(x: Int? = null): Long? {
    if (x.isNull()) {
        val l: Long? = x?.toLong()
        return l
    }
    return 0L
}