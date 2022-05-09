package com.fagskolen.unittesting

class StringUtils {
    val vowels = "aeiouyæøå"

    fun cleanUpNameList(names: List<String>): List<String> {
        return names
    }

    fun toAlternatingCase(input: String): String {
        var result = ""
        for (i in input.indices) {
            val c: Char = input[i]
            if (i % 2 == 0) result += c.uppercase()
            else result += c.lowercase()
        }
        return result
    }

    fun isVowel(input: Char): Boolean {
        return vowels.contains(input)
    }

    /**
     * The numbers must be separated by + sign and contain no other characters
     * Letters or other symbols will throw exception
     *
     * Example: addIntegerNumbers("1+5+14") // will return 20
     */
    fun addIntegerNumbers(input: String): Int {
        if (input.isEmpty()) return 0
        val elements = input.split("+")
        var result = 0
        for (numberAsString in elements) {
            val numberAsInt = numberAsString.toInt()
            result += numberAsInt
        }
        return result
    }

    fun rot13(input: String): String {
        var result = "" // 65 - 90
        for (i in input.indices) {
            val c = input[i]
            if (c.code < 65 || c.code > 90) {
                throw IllegalArgumentException("Character '$c' is not accepted input")
            }
            var resCode = c.code + 13
            if (resCode > 90) resCode -= 26
            result += Char(resCode)
        }
        return result
    }
}