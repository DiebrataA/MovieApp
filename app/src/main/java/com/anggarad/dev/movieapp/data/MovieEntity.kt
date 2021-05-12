package com.anggarad.dev.movieapp.data

data class MovieEntity(
        var movieId: String,
        var title: String,
        var year: String,
        var description: String,
        var posterPath: String,
        var rating: String,
        var genre: String,
        var duration: String,
        var director: String,
        var season: Int,
        var status: String
)
