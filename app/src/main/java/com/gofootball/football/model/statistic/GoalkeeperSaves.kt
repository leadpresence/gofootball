package com.gofootball.football.model.statistic


import com.google.gson.annotations.SerializedName

data class GoalkeeperSaves(
    @SerializedName("home")
    var home: String,
    @SerializedName("away")
    var away: String
)