package com.fagskolen.unittesting.sideeffect

class Logger {
    val loggedText = mutableListOf<String>()

    fun log(text: String) {
        loggedText.add(text)
    }
}