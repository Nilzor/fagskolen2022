package com.fagskolen.mvvm

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.fagskolen.mvvm.databinding.ActivityFilmBinding

class FilmActivity : AppCompatActivity(), ChangeListener {

    private lateinit var filmViewModel: FilmViewModel
    private lateinit var binding: ActivityFilmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val loadedFilmViewModel = savedInstanceState?.getSerializable("viewmodel") as? FilmViewModel?
        Log.d("Film1", "viewModel loaded: $loadedFilmViewModel")
        filmViewModel = loadedFilmViewModel ?: FilmViewModel()

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

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("Film1", "Saving viewmodel $filmViewModel")
        outState.putSerializable("viewmodel", filmViewModel)
        super.onSaveInstanceState(outState)
        Log.d("Film1", "viewmodel saved")
    }
}