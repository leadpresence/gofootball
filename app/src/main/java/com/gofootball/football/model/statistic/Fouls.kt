package com.gofootball.football.model.statistic


import com.google.gson.annotations.SerializedName

data class Fouls(
    @SerializedName("home")
    var home: String,
    @SerializedName("away")
    var away: String
)