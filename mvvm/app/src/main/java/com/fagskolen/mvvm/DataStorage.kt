package com.fagskolen.mvvm

import java.util.*

object DataStorage {
    fun loadFilm(): FilmModel {
        return FilmModel(
            title = "Spider-Man: No Way Home",
            ageRating = "12",
            releaseDate = Date(2021, 11, 13),
            durationMinute = 148
        )
    }
}