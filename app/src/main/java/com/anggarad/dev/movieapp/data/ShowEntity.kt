package com.anggarad.dev.movieapp.data

data class ShowEntity(
        var showId: String,
        var title: String,
        var year: String,
        var description: String,
        var season: Int,
        var posterPath: String,
        var rating: String,
        var genre: String,
        var duration: String,
        var status: String
)
