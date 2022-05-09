package com.fagskolen.unittesting

import org.junit.Assert.assertEquals
import org.junit.Test


internal class PlayerTest {

    @Test
    fun get18Scores_null_list() {
        val player = Player(
            "Frode",
            scores = null
        )
        val result = player.get18Scores()
        assertEquals(18, result.size)
    }

    @Test
    fun get18Scores_two_and_five_whole_two_correct() {
        val player = Player(
            "Frode",
            scores = listOf(
                Score(2, 3),
                Score(5, 7)
            )
        )

        val result = player.get18Scores()

        assertEquals(3, result[1].score)
    }

    @Test
    fun get18Scores_two_and_five_hole_five_correct() {
        val player = Player(
            "Frode",
            scores = listOf(
                Score(2, 3),
                Score(5, 7)
            )
        )

        val result = player.get18Scores()

        assertEquals(7, result[4].score)
    }

    @Test
    fun get18Scores_two_and_five_hole_size_correct() {
        val player = Player(
            "Frode",
            scores = listOf(
                Score(2, 3),
                Score(5, 7)
            )
        )

        val result = player.get18Scores()

        assertEquals(18, result.size)
    }

    @Test
    fun get18Scores_hole_seven_is_zero() {
        val player = Player(
            "Frode",
            scores = listOf(
                Score(2, 3),
                Score(5, 7)
            )
        )

        val result = player.get18Scores()

        assertEquals(0, result[6].score)
    }
}