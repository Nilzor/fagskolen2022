package com.fagskolen.unittesting

data class Player(
    val playerName: String,
    val scores: List<Score>?
) {
    fun get18Scores(): List<Score> {
        val outList = mutableListOf<Score>()
        if (scores == null) {
            for (i in 1..18) {
                outList.add(Score(i, 0))
            }
        } else {
            for (i in 1..18) {
                val foundScore = scores.find { it.hole == i }
                if (foundScore != null) {
                    outList.add(foundScore)
                } else {
                    outList.add(Score(i, 0))
                }
            }
        }

        return outList
    }
}