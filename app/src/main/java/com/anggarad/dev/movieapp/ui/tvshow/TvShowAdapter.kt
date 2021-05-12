package com.anggarad.dev.movieapp.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anggarad.dev.movieapp.R
import com.anggarad.dev.movieapp.data.ShowEntity
import com.anggarad.dev.movieapp.databinding.ItemsShowsBinding
import com.anggarad.dev.movieapp.ui.detail.DetailShowsActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.ShowsViewHolder>() {
    private var listShows = ArrayList<ShowEntity>()

    fun setShows(show: List<ShowEntity>?) {
        if (show == null) return
        this.listShows.clear()
        this.listShows.addAll(show)
    }

    class ShowsViewHolder(private val binding: ItemsShowsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(shows: ShowEntity) {
            with(binding) {
                tvItemTitle.text = shows.title
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailShowsActivity::class.java)
                    intent.putExtra(DetailShowsActivity.EXTRA_SHOW, shows.showId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(shows.posterPath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowsViewHolder {
        val itemsShowBinding =
            ItemsShowsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShowsViewHolder(itemsShowBinding)
    }

    override fun onBindViewHolder(holder: ShowsViewHolder, position: Int) {
        val show = listShows[position]
        holder.bind(show)
    }

    override fun getItemCount(): Int {
        return listShows.size
    }
}