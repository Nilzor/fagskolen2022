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
}