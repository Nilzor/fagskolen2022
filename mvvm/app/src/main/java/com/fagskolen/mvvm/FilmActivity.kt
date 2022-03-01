package com.fagskolen.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import org.w3c.dom.Text

class FilmActivity : AppCompatActivity() {
    lateinit var filmViewModel: FilmViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film)
        supportActionBar?.hide()

        val filmModel = DataStorage.loadFilm()
        filmViewModel = FilmViewModel()
        Converters.filmModelToViewModel(filmModel, filmViewModel)
        show(filmViewModel)
    }

    private fun show(filmViewModel: FilmViewModel) {
        findViewById<TextView>(R.id.title).text = filmViewModel.title
        findViewById<TextView>(R.id.year).text = filmViewModel.releaseYear
        findViewById<TextView>(R.id.ageRating).text = filmViewModel.ageRating
        findViewById<TextView>(R.id.duration).text = filmViewModel.duration
    }
}