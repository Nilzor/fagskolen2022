package com.fagskolen.mvvm

import java.util.*

class FilmModel(
    val title: String,
    val ageRating: String,
    val releaseDate: Date,
    val durationMinute: Long,
) {

    fun toViewModel(): FilmViewModel {
        val hours: Long = durationMinute / 60
        val minutes: Long = durationMinute % 60

        return FilmViewModel(
            title = this.title,
            releaseYear = releaseDate.year.toString(),
            ageRating = this.ageRating,
            duration = "${hours}h ${minutes}m"
        )
    }
}
