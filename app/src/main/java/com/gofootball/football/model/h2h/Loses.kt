package com.gofootball.football.model.h2h


import com.google.gson.annotations.SerializedName

data class Loses(
    @SerializedName("home")
    var home: Int,
    @SerializedName("away")
    var away: Int,
    @SerializedName("total")
    var total: Int
)