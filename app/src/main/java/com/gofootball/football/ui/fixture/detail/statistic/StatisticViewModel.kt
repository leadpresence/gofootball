package com.gofootball.football.ui.fixture.detail.statistic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gofootball.football.data.remote.ApiClient
import com.gofootball.football.model.statistic.Statistics
import com.gofootball.football.model.statistic.StatisticsResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class StatisticViewModel : ViewModel() {

    private val apiClient = ApiClient()
    private val disposable = CompositeDisposable()

    val fixtureStatic = MutableLiveData<Statistics>()

    fun getFixtureStatistics(fixtureId:Int){
        disposable.add(
            apiClient.getFixtureStatistics(fixtureId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<StatisticsResponse>(){
                    override fun onSuccess(t: StatisticsResponse) {
                        fixtureStatic.value = t.api.statistics
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
