package com.anggarad.dev.movieapp.ui.tvshow

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp(){
        viewModel = TvShowViewModel()
    }

    @Test
    fun getShows() {
        val showsEntities = viewModel.getShows()
        assertNotNull(showsEntities)
        assertEquals(10, showsEntities.size)
    }
}