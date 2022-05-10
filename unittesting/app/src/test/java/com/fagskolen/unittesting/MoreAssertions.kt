package com.fagskolen.unittesting

import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test

class MoreAssertions {
    @Test
    fun assertWithMessage() {
        val resultList: List<String> = produceList()
        for ((ix, element) in resultList.withIndex()) {
            assertTrue(
                "Element nr $ix starter ikke med 'a': $element",
                element.startsWith("a")
            )
        }
    }

    private fun produceList(): List<String> {
        return listOf("ape", "arnested", "løve")
    }
}