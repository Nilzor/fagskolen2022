package com.fagskolen.mvvm

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FilmActivity : AppCompatActivity() {
    lateinit var filmViewModel: FilmViewModel

    private lateinit var progressBar: ProgressBar
    private lateinit var filmContent: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film)
        supportActionBar?.hide()

        progressBar = findViewById(R.id.progressBar)
        filmContent = findViewById(R.id.filmContent)

        filmViewModel = ViewModelProvider(this).get(FilmViewModel::class.java)
        loadDataIfNeeded()
    }

    private fun loadDataIfNeeded() {
        if (!filmViewModel.isLoaded()) {
            Log.d("Film1", "Preparing to load data")
            loadDataInBackground()
        } else {
            show(filmViewModel)
        }
    }

    private fun loadDataInBackground() {
        lifecycleScope.launch {
            Log.d("Film1", "Loading data on background thread")

            progressBar.visibility = View.VISIBLE
            filmContent.visibility = View.GONE

            delay(2000) // Vi later som om datakilden er treg

            val filmModel = DataStorage.loadFilm()
            Converters.filmModelToViewModel(filmModel, filmViewModel)

            progressBar.visibility = View.GONE
            filmContent.visibility = View.VISIBLE

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