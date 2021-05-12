package com.anggarad.dev.movieapp.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.anggarad.dev.movieapp.R
import com.anggarad.dev.movieapp.data.ShowEntity
import com.anggarad.dev.movieapp.databinding.ActivityDetailShowBinding
import com.anggarad.dev.movieapp.databinding.ContentDetailTvShowBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class DetailShowsActivity : AppCompatActivity() {

    private lateinit var contentDetailTvShowBinding: ContentDetailTvShowBinding
    private lateinit var detailShowsViewModel: DetailShowsViewModel

    companion object {
        const val EXTRA_SHOW = "extra_show"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val detailActivityBinding = ActivityDetailShowBinding.inflate(layoutInflater)
        contentDetailTvShowBinding = detailActivityBinding.detailContentShows
        setContentView(detailActivityBinding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = getString(R.string.show_detail_title)

        detailShowsViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailShowsViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val showId = extras.getString(EXTRA_SHOW)
            if (showId != null) {
                detailShowsViewModel.setSelectedShows(showId)
                populateShow(detailShowsViewModel.getShows())
            }
        }
    }

    private fun populateShow(shows: ShowEntity) {
        with(contentDetailTvShowBinding) {
            tvItemTitle.text = shows.title
            descContent.text = shows.description
            releaseYearContent.text = shows.year
            ratingContent.text = shows.rating
            seasons.text = shows.season.toString() + getString(R.string.seasons_text)
            genre.text = shows.genre
            statusContent.text = shows.status
        }

        Glide.with(this)
            .load(shows.posterPath)
            .transform(RoundedCorners(10))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(contentDetailTvShowBinding.imageView)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}