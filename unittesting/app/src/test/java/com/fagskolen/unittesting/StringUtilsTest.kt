package com.fagskolen.unittesting


import org.junit.Assert.*
import org.junit.Test
import org.junit.rules.ExpectedException
import java.lang.Exception
import java.lang.IndexOutOfBoundsException
import java.lang.NumberFormatException

internal class StringUtilsTest {

    @Test
    fun `uppercase when already upper case`() {
        val input = "HEI DU"
        val result = input.uppercase()
        assertEquals("HEI DU", result)
    }

    @Test
    fun `uppercase when lower case`() {
        val input = "hei du"
        val result = input.uppercase()
        assertEquals("HEI DU", result)

    }

    @Test
    fun `uppercase when mixed case`() {
        val input = "Hei Du"
        val result = input.uppercase()
        assertEquals("HEI DU", result)
    }

    @Test
    fun `alternatingcase - long text`() {
        val input = "god dag på deg"
        val result = StringUtils().toAlternatingCase(input)
        assertEquals("GoD DaG På dEg", result)
    }

    @Test
    fun `alternatingcase - empty string`() {
        val input = ""
        val result = StringUtils().toAlternatingCase(input)
        assertEquals("", result)
    }

    @Test
    fun `isVowel - a`() {
        val result = StringUtils().isVowel('a')
        assertTrue(result)
    }

    @Test
    fun `isVowel - b`() {
        val result = StringUtils().isVowel('b')
        assertFalse(result)
    }

    @Test
    fun `addIntegerNumbers - one number`() {
        val res = StringUtils().addIntegerNumbers("4")
        assertEquals(4, res)
    }

    @Test
    fun `addIntegerNumbers - two numbers`() {
        val res = StringUtils().addIntegerNumbers("4+1")
        assertEquals(5, res)
    }

    @Test
    fun `addIntegerNumbers - three numbers`() {
        val res = StringUtils().addIntegerNumbers("11+5+17")
        assertEquals(33, res)
    }

    @Test(expected = Exception::class)
    fun `addIntegerNumbers - one number and some text`() {
        StringUtils().addIntegerNumbers("11+kake")
    }

    @Test(expected = Exception::class)
    fun `addIntegerNumbers - two number separated by minus`() {
        StringUtils().addIntegerNumbers("11-4")
    }

    @Test
    fun `addIntegerNumbers - empty string`() {
        val res = StringUtils().addIntegerNumbers("")
        assertEquals(0, res)
    }

    @Test
    fun `rot13 - KAKE`() {
        val input = listOf(1.0, 2.0)
        val result = input.average()
        assertEquals(1.5, result, 0.1)
    }

    @Test
    fun cleanUpNames() {
        val list = listOf<String>(
            "Roger",
            "Hans",
            "Mina",
            "Fredrik",
            "Lene",
            "Lene",
            "Jakob",
            "",
            "Fredrik",
        )
    }
}