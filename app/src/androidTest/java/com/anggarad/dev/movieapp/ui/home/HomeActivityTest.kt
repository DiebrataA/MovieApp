package com.anggarad.dev.movieapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.anggarad.dev.movieapp.R
import com.anggarad.dev.movieapp.utils.MovieData
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = MovieData.generateMovieData()
    private val dummyShows = MovieData.generateTvShowData()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_item_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.genre)).check(matches(isDisplayed()))
        onView(withId(R.id.genre)).check(matches(withText(dummyMovie[0].genre)))
        onView(withId(R.id.duration)).check(matches(isDisplayed()))
        onView(withId(R.id.duration)).check(matches(withText(dummyMovie[0].duration)))
        onView(withId(R.id.rating_content)).check(matches(isDisplayed()))
        onView(withId(R.id.rating_content)).check(matches(withText(dummyMovie[0].rating)))
        onView(withId(R.id.release_year_content)).check(matches(isDisplayed()))
        onView(withId(R.id.release_year_content)).check(matches(withText(dummyMovie[0].year)))
        onView(withId(R.id.director_content)).check(matches(isDisplayed()))
        onView(withId(R.id.director_content)).check(matches(withText(dummyMovie[0].director)))
        onView(withId(R.id.desc_content)).check(matches(isDisplayed()))
        onView(withId(R.id.desc_content)).check(matches(withText(dummyMovie[0].description)))
    }

    @Test
    fun loadShows() {
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_shows)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyShows.size
            )
        )
    }

    @Test
    fun loadDetailShows() {
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_shows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_item_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_title)).check(matches(withText(dummyShows[0].title)))
        onView(withId(R.id.genre)).check(matches(isDisplayed()))
        onView(withId(R.id.genre)).check(matches(withText(dummyShows[0].genre)))
        onView(withId(R.id.seasons)).check(matches(isDisplayed()))
        onView(withId(R.id.seasons)).check(matches(withText("${dummyShows[0].season}Seasons")))
        onView(withId(R.id.rating_content)).check(matches(isDisplayed()))
        onView(withId(R.id.rating_content)).check(matches(withText(dummyShows[0].rating)))
        onView(withId(R.id.release_year_content)).check(matches(isDisplayed()))
        onView(withId(R.id.release_year_content)).check(matches(withText(dummyShows[0].year)))
        onView(withId(R.id.status_content)).check(matches(isDisplayed()))
        onView(withId(R.id.status_content)).check(matches(withText(dummyShows[0].status)))
        onView(withId(R.id.desc_content)).check(matches(isDisplayed()))
        onView(withId(R.id.desc_content)).check(matches(withText(dummyShows[0].description)))
    }
}