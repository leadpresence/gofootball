package com.gofootball.football.data.remote

import com.gofootball.football.model.MatchApiResponse
import com.gofootball.football.model.fixture.FixtureResponse
import com.gofootball.football.model.leaguetable.LeagueTableResponse
import com.gofootball.football.model.player.PlayerResponse
import com.gofootball.football.model.statistic.StatisticsResponse
import com.gofootball.football.model.team.TeamResponse
import com.gofootball.football.model.topscorer.TopScorerResponse
import com.gofootball.football.model.transfer.TransferResponse
import com.gofootball.football.util.Constant
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient {

    private val api = Retrofit.Builder()
        .baseUrl(Constant.GO_FOOTBALL_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(ApiService::class.java)

    fun getMatchFixtures():Single<MatchApiResponse> = api.getMatchFixtures()
}