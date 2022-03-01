package com.fagskolen.mvvm

import androidx.lifecycle.ViewModel


class FilmViewModel() : ViewModel() {
    var title: String = ""
    var duration: String = ""
    var ageRating: String = ""
    var releaseYear: String = ""
    var posterResource: Int = 0

    /** Returns true if the ViewModel is loaded and has data */
    fun isLoaded(): Boolean {
        return title != ""
    }
}