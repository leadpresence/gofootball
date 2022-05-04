package com.gofootball.football.model.statistic


import com.google.gson.annotations.SerializedName

data class StatisticsResponse(
    @SerializedName("api")
    var api: Api
)