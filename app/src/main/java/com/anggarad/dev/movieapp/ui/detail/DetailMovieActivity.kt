package com.anggarad.dev.movieapp.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.anggarad.dev.movieapp.R
import com.anggarad.dev.movieapp.data.MovieEntity
import com.anggarad.dev.movieapp.databinding.ActivityDetailMovieBinding
import com.anggarad.dev.movieapp.databinding.ContentDetailMovieBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var contentDetailMovieBinding: ContentDetailMovieBinding
    private lateinit var detailViewModel: DetailMovieViewModel

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val detailActivityBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        contentDetailMovieBinding = detailActivityBinding.detailContent
        setContentView(detailActivityBinding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = getString(R.string.details_title)

        detailViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                detailViewModel.setSelectedMovie(movieId)
                populateMovie(detailViewModel.getMovie())
            }
        }
    }

    private fun populateMovie(movie: MovieEntity) {
        with(contentDetailMovieBinding) {
            tvItemTitle.text = movie.title
            descContent.text = movie.description
            releaseYearContent.text = movie.year
            ratingContent.text = movie.rating
            duration.text = movie.duration
            genre.text = movie.genre
            directorContent.text = movie.director
        }

        Glide.with(this)
            .load(movie.posterPath)
            .transform(RoundedCorners(10))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(contentDetailMovieBinding.imageView)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}