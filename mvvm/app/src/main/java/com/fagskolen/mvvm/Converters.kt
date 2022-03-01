package com.fagskolen.mvvm

object Converters {
    fun filmModelToViewModel(filmModel: FilmModel, filmViewModel: FilmViewModel) {
        val hours: Long = filmModel.durationMinutes / 60
        val minutes: Long = filmModel.durationMinutes % 60

        filmViewModel.title = filmModel.title
        filmViewModel.releaseYear = filmModel.releaseDate.year.toString()
        filmViewModel.ageRating = filmModel.ageRating
        filmViewModel.duration = "${hours}h ${minutes}m"
    }
}