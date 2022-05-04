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
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {

    @Headers(Constant.GO_FOOTBALL_APP_KEY)
    @GET(Constant.GET_MATCHES)
    fun getMatchFixtures()  : Single<MatchApiResponse>



}