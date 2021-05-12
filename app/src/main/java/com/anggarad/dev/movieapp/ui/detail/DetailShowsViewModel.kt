package com.anggarad.dev.movieapp.ui.detail

import androidx.lifecycle.ViewModel
import com.anggarad.dev.movieapp.data.ShowEntity
import com.anggarad.dev.movieapp.utils.MovieData

class DetailShowsViewModel : ViewModel() {
    private lateinit var showId: String

    fun setSelectedShows(showId: String) {
        this.showId = showId
    }

    fun getShows(): ShowEntity {
        lateinit var show: ShowEntity
        val showEntities = MovieData.generateTvShowData()
        for (showEntity in showEntities) {
            if (showEntity.showId == showId) {
                show = showEntity
            }
        }
        return show
    }
}