package com.gofootball.football.ui.fixture

import android.app.Activity
import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gofootball.football.data.remote.ApiClient
import com.gofootball.football.model.Match
import com.gofootball.football.model.MatchApiResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class FixtureViewModel (private val activity: Activity, application: Application): ViewModel() {

    private val apiClient = ApiClient()
    private val disposable = CompositeDisposable()


    var matchesList = MutableLiveData<List<Match>>()
    val loadingFixture = MutableLiveData<Boolean>()

    init {
        getAllMatchFixture()
    }


    fun getAllMatchFixture() {
        loadingFixture.value = true

        disposable.add(
            apiClient.getMatchFixtures()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<MatchApiResponse>() {
                    override fun onSuccess(t: MatchApiResponse) {
                        matchesList.value = t. matches
                        Log.e("MATCH_RESPONSE_::","${t.matches}")

                        loadingFixture.value = false
                    }

                    override fun onError(e: Throwable) {

                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}