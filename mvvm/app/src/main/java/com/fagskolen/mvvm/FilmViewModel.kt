package com.fagskolen.mvvm

import androidx.lifecycle.ViewModel


class FilmViewModel() : ViewModel() {
    var title: String = ""
    var duration: String = ""
    var ageRating: String = ""
    var releaseYear: String = ""

}