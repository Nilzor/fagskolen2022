package com.fagskolen.mvvm

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FilmActivity : AppCompatActivity() {
    lateinit var filmViewModel: FilmViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film)
        supportActionBar?.hide()

        filmViewModel = FilmViewModel()
        loadDataIfNeeded()
    }


    private fun loadDataIfNeeded() {
        if (!filmViewModel.isLoaded()) {
            loadDataInBackground()
        } else {
            show(filmViewModel)
        }
    }

    private fun loadDataInBackground() {
        lifecycleScope.launch {
            delay(2000) // Vi later som om datakilden er treg

            val filmModel = DataStorage.loadFilm()
            Converters.filmModelToViewModel(filmModel, filmViewModel)

            show(filmViewModel)
        }
    }

    private fun show(filmViewModel: FilmViewModel) {
        findViewById<TextView>(R.id.title).text = filmViewModel.title
        findViewById<TextView>(R.id.year).text = filmViewModel.releaseYear
        findViewById<TextView>(R.id.ageRating).text = filmViewModel.ageRating
        findViewById<TextView>(R.id.duration).text = filmViewModel.duration
        if (filmViewModel.posterResource != 0) {
            findViewById<ImageView>(R.id.posterImage).setImageResource(filmViewModel.posterResource)
        }
    }
}