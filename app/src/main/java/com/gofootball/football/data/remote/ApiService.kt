package com.gofootball.football.data.remote

import com.gofootball.football.model.MatchApiResponse
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