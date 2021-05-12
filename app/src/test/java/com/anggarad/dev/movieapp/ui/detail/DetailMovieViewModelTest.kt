package com.anggarad.dev.movieapp.ui.detail

import com.anggarad.dev.movieapp.utils.MovieData
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = MovieData.generateMovieData()[0]
    private val movieId = dummyMovie.movieId

    @Before
    fun setUp(){
        viewModel = DetailMovieViewModel()
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(dummyMovie.movieId)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.posterPath, movieEntity.posterPath)
        assertEquals(dummyMovie.description, movieEntity.description)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.director, movieEntity.director)
        assertEquals(dummyMovie.duration, movieEntity.duration)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.rating, movieEntity.rating)
        assertEquals(dummyMovie.year, movieEntity.year)
    }
}