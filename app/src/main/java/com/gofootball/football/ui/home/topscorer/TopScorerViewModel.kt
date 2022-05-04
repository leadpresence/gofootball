package com.gofootball.football.ui.home.topscorer

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.gofootball.football.base.BaseViewModel
import com.gofootball.football.data.local.FootballDatabase
import com.gofootball.football.data.remote.ApiClient
import com.gofootball.football.model.topscorer.TopScorerResponse
import com.gofootball.football.model.topscorer.Topscorer
import com.gofootball.football.util.CustomSharedPreferences
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class TopScorerViewModel(application: Application) : BaseViewModel(application) {

    private val apiClient =  ApiClient()
    private val disposable = CompositeDisposable()

    private var customPreferences = CustomSharedPreferences(getApplication())
    private var refreshTime = 24 * 60 * 60 * 1000 * 1000 * 1000L

    val topScorerList = MutableLiveData<List<Topscorer>>()
    val loadingTopScorer = MutableLiveData<Boolean>()

    fun getTopScorers(leagueId: Int){

        val updateTime = customPreferences.getTime()
        if (updateTime != null && updateTime != 0L && System.nanoTime() - updateTime < refreshTime) {
            var temp = arrayListOf(0)
            temp.add(542)
            temp.add(leagueId)
            if (temp[(temp.lastIndex)-1]==leagueId){
                getDataFromSQLite()
            }else{
                getTopScorersFromApi(leagueId)
            }
        } else {
            getTopScorersFromApi(leagueId)
        }
    }

    private fun getDataFromSQLite() {
        loadingTopScorer.value = true
        launch {
            val countries = FootballDatabase(getApplication()).footballDao().getTopscorer()
            showLayout(countries)
        }
    }

    fun getTopScorersFromApi(leagueId: Int){
        loadingTopScorer.value = true
        disposable.add(
            apiClient.getTopScorers(leagueId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<TopScorerResponse>(){
                    override fun onSuccess(t: TopScorerResponse) {
                        saveDataInSQLite(t.api.topscorers)
                    }
                    override fun onError(e: Throwable) {
                    }
                })
        )
    }

    private fun showLayout(topscorerList: List<Topscorer>) {
        topScorerList.value = topscorerList
        loadingTopScorer.value = false
    }

    private fun saveDataInSQLite(list: List<Topscorer>) {
        launch {
            val dao = FootballDatabase(getApplication()).footballDao()
            dao.deleteTopscorer()
            val listLong = dao.insertAllTopscorer(*list.toTypedArray())
            var i = 0
            while (i < list.size) {
                list[i].playerİd = listLong[i].toInt()
                i = i + 1
            }
            showLayout(list)
        }
        customPreferences.saveTime(System.nanoTime())
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}