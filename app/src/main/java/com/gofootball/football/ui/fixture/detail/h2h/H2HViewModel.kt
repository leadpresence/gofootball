package com.gofootball.football.ui.fixture.detail.h2h

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gofootball.football.data.remote.ApiClient
import com.gofootball.football.model.h2h.Fixture
import com.gofootball.football.model.h2h.H2HResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class H2HViewModel : ViewModel() {

    private val apiClient = ApiClient()
    private val disposable = CompositeDisposable()

    val h2hList = MutableLiveData<List<Fixture>>()
    val loadingH2h = MutableLiveData<Boolean>()


    fun getAllH2hItems(homeTeamId:Int, awayTeamId:Int){
        loadingH2h.value = true
        disposable.add(
            apiClient.getAllH2hItems(homeTeamId, awayTeamId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<H2HResponse>(){
                    override fun onSuccess(t: H2HResponse) {
                        h2hList.value = t.api.fixtures
                        loadingH2h.value = false
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
