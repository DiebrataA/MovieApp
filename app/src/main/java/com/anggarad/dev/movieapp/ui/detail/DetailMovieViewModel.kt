package com.anggarad.dev.movieapp.ui.detail

import androidx.lifecycle.ViewModel
import com.anggarad.dev.movieapp.data.MovieEntity
import com.anggarad.dev.movieapp.utils.MovieData

class DetailMovieViewModel : ViewModel() {
    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovie(): MovieEntity {
        lateinit var movie: MovieEntity
        val movieEntities = MovieData.generateMovieData()
        for (movieEntity in movieEntities) {
            if (movieEntity.movieId == movieId) {
                movie = movieEntity
            }
        }
        return movie
    }
}