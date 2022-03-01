package com.fagskolen.mvvm

import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class FilmActivity : AppCompatActivity(), ChangeListener {
    private val filmViewModel: FilmViewModel by viewModels()

    private lateinit var progressBar: ProgressBar
    private lateinit var filmContent: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film)
        supportActionBar?.hide()

        progressBar = findViewById(R.id.progressBar)
        filmContent = findViewById(R.id.filmContent)

        filmViewModel.onChange = this
        filmViewModel.loadDataIfNeeded()
        show(filmViewModel)
    }

    private fun show(filmViewModel: FilmViewModel) {
        findViewById<TextView>(R.id.title).text = filmViewModel.title
        findViewById<TextView>(R.id.year).text = filmViewModel.releaseYear
        findViewById<TextView>(R.id.ageRating).text = filmViewModel.ageRating
        findViewById<TextView>(R.id.duration).text = filmViewModel.duration
        if (filmViewModel.posterResource != 0) {
            findViewById<ImageView>(R.id.posterImage).setImageResource(filmViewModel.posterResource)
        }
        progressBar.visibility = filmViewModel.progressBarVisibility
        filmContent.visibility = filmViewModel.filmContentVisibility
    }

    override fun onDataChanged() {
        show(filmViewModel)
    }
}