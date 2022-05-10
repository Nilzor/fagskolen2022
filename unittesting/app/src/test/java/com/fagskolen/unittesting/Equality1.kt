package com.fagskolen.unittesting

import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test

class Equality1 {

    @Test
    fun contentEquality_assertEquals() {
        val a = listOf("frode")
        val b = listOf("frode")
        assertEquals(a, b)
    }

    @Test
    fun contentEquality_manual() {
        val a = listOf("frode")
        val b = listOf("frode")
        assertTrue(a == b)
    }

    @Test
    fun referenceEquality_assertSame() {
        val a = listOf("frode")
        val b = listOf("frode")
        assertSame(a, b)
    }

    @Test
    fun referenceEquality_assertManually() {
        val a = listOf("frode")
        val b = listOf("frode")
        assertTrue(a === b)
    }
}