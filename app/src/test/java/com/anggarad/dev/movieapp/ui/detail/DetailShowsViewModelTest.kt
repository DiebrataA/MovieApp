package com.anggarad.dev.movieapp.ui.detail

import com.anggarad.dev.movieapp.utils.MovieData
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailShowsViewModelTest {

    private lateinit var viewModel: DetailShowsViewModel
    private val dummyShows = MovieData.generateTvShowData()[0]
    private val showId = dummyShows.showId

    @Before
    fun setUp() {
        viewModel = DetailShowsViewModel()
        viewModel.setSelectedShows(showId)
    }

    @Test
    fun getShows() {
        viewModel.setSelectedShows(dummyShows.showId)
        val showEntity = viewModel.getShows()
        assertNotNull(showEntity)
        assertEquals(dummyShows.showId, showEntity.showId)
        assertEquals(dummyShows.posterPath, showEntity.posterPath)
        assertEquals(dummyShows.description, showEntity.description)
        assertEquals(dummyShows.title, showEntity.title)
        assertEquals(dummyShows.season, showEntity.season)
        assertEquals(dummyShows.duration, showEntity.duration)
        assertEquals(dummyShows.genre, showEntity.genre)
        assertEquals(dummyShows.rating, showEntity.rating)
        assertEquals(dummyShows.status, showEntity.status)
    }
}