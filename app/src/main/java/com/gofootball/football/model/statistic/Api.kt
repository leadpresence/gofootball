package com.gofootball.football.model.statistic


import com.google.gson.annotations.SerializedName

data class Api(
    @SerializedName("results")
    var results: Int,
    @SerializedName("statistics")
    var statistics: Statistics
)