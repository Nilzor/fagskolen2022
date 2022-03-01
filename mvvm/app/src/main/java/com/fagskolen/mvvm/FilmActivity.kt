package com.fagskolen.mvvm

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.fagskolen.mvvm.databinding.ActivityFilmBinding

class FilmActivity : AppCompatActivity(), ChangeListener {
    private val filmViewModel: FilmViewModel by viewModels()

    private lateinit var binding: ActivityFilmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        filmViewModel.onChange = this
        filmViewModel.loadDataIfNeeded()
        show(filmViewModel)
    }

    private fun show(filmViewModel: FilmViewModel) {
        binding.title.text = filmViewModel.title
        binding.year.text = filmViewModel.releaseYear
        binding.ageRating.text = filmViewModel.ageRating
        binding.duration.text = filmViewModel.duration
        if (filmViewModel.posterResource != 0) {
            binding.posterImage.setImageResource(filmViewModel.posterResource)
        }
        binding.progressBar.visibility = filmViewModel.progressBarVisibility
        binding.filmContent.visibility = filmViewModel.filmContentVisibility
    }

    override fun onDataChanged() {
        show(filmViewModel)
    }
}