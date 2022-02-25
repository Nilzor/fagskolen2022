package com.fagskolen.mvvm

object Converters {
    fun filmModelToViewModel(filmModel: FilmModel): FilmViewModel {
        val hours: Long = filmModel.durationMinute / 60
        val minutes: Long = filmModel.durationMinute % 60

        return FilmViewModel(
            title = filmModel.title,
            releaseYear = filmModel.releaseDate.year.toString(),
            ageRating = filmModel.ageRating,
            duration = "${hours}h ${minutes}m"
        )
    }
}