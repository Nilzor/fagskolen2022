package com.fagskolen.mvvm

import androidx.lifecycle.ViewModel

class FilmViewModel(
    val title: String,
    val releaseYear: String,
    val ageRating: String,
    val duration: String,
) : ViewModel()