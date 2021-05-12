package com.anggarad.dev.movieapp.ui.tvshow

import androidx.lifecycle.ViewModel
import com.anggarad.dev.movieapp.data.ShowEntity
import com.anggarad.dev.movieapp.utils.MovieData

class TvShowViewModel : ViewModel() {
    fun getShows(): List<ShowEntity> = MovieData.generateTvShowData()
}