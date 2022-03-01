package com.fagskolen.mvvm

import android.util.Log
import android.view.View
import androidx.lifecycle.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.Serializable


class FilmViewModel() : ViewModel(), Serializable {
    var title: String = ""
    var duration: String = ""
    var ageRating: String = ""
    var releaseYear: String = ""
    var posterResource: Int = 0

    var progressBarVisibility: Int = View.GONE
    var filmContentVisibility: Int = View.GONE

    @Transient
    var onChange: ChangeListener? = null

    /** Returns true if the ViewModel is loaded and has data */
    fun isLoaded(): Boolean {
        return title != ""
    }

    fun loadDataIfNeeded() {
        if (!isLoaded()) {
            Log.d("Film1", "Preparing to load data")
            loadDataInBackground()
        }
    }

    private fun loadDataInBackground() {
        viewModelScope.launch {
            Log.d("Film1", "Loading data on background thread")

            progressBarVisibility = View.VISIBLE
            filmContentVisibility = View.GONE

            delay(2000) // Vi later som om datakilden er treg

            val filmModel = DataStorage.loadFilm()
            Converters.filmModelToViewModel(filmModel, this@FilmViewModel)

            progressBarVisibility = View.GONE
            filmContentVisibility = View.VISIBLE

            onChange?.onDataChanged()
        }
    }
}