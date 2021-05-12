package com.anggarad.dev.movieapp.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anggarad.dev.movieapp.R
import com.anggarad.dev.movieapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        activityHomeBinding.viewPager.adapter = sectionsPagerAdapter
        activityHomeBinding.tabs.setupWithViewPager(activityHomeBinding.viewPager)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = getString(R.string.title_app)

    }
}