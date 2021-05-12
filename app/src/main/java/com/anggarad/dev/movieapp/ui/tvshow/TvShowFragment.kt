package com.anggarad.dev.movieapp.ui.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.anggarad.dev.movieapp.databinding.FragmentTvShowBinding

class TvShowFragment : Fragment() {
    private lateinit var fragmentShowsBinding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentShowsBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentShowsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[TvShowViewModel::class.java]
            val shows = viewModel.getShows()

            val showAdapter = TvShowAdapter()
            showAdapter.setShows(shows)

            with(fragmentShowsBinding.rvShows) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = showAdapter
            }
        }
    }
}