package com.fagskolen.unittesting

data class Player(
    val playerName: String,
    val scores: List<Score>?
) {
    fun get18Scores(): List<Score> {
        return scores!!
    }
}