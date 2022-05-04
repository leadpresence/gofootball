package com.gofootball.football.ui

import android.app.Activity
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gofootball.football.ui.fixture.FixtureViewModel


@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val activity: Activity, private val application: Application) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(FixtureViewModel::class.java) ->
                FixtureViewModel(activity, application) as T

            else ->throw IllegalArgumentException("Unknown class")
        }
    }
}