package com.fagskolen.mvvm

import java.util.*

object DataStorage {
    fun loadFilm(): FilmModel {
        return FilmModel(
            title = "Spider-Man: No Way Home",
            ageRating = "12A",
            releaseDate = Date(121, 11, 13),
            durationMinutes = 148,
            description = "Her er beskrivelsen"
        )
    }
}