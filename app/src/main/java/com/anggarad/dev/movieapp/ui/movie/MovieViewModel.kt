package com.anggarad.dev.movieapp.ui.movie

import androidx.lifecycle.ViewModel
import com.anggarad.dev.movieapp.data.MovieEntity
import com.anggarad.dev.movieapp.utils.MovieData

class MovieViewModel : ViewModel() {
    fun getMovies(): List<MovieEntity> = MovieData.generateMovieData()
}