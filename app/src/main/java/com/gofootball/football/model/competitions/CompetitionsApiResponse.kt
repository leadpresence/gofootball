package com.gofootball.football.model.competitions
import com.google.gson.annotations.SerializedName


data class CompetitionsApiResponse(
    @SerializedName("competitions")
    var competitions: List<Competition>,
    @SerializedName("count")
    var count: Int=0,
    @SerializedName("filters")
    var filters: Filters
)

data class Competition(
    @SerializedName("area")
    var area: Area= Area(),
    @SerializedName("code")
    var code: String?="",
    @SerializedName("currentSeason")
    var currentSeason: CurrentSeason=CurrentSeason(),
    @SerializedName("emblemUrl")
    var emblemUrl: Any?=Any(),
    @SerializedName("id")
    var id: Int=0,
    @SerializedName("lastUpdated")
    var lastUpdated: String="",
    @SerializedName("name")
    var name: String="",
    @SerializedName("numberOfAvailableSeasons")
    var numberOfAvailableSeasons: Int=0,
    @SerializedName("plan")
    var plan: String=""
)

class Filters

data class Area(
    @SerializedName("countryCode")
    var countryCode: String="",
    @SerializedName("ensignUrl")
    var ensignUrl: Any?=Any(),
    @SerializedName("id")
    var id: Int=0,
    @SerializedName("name")
    var name: String=""
)

data class CurrentSeason(
    @SerializedName("currentMatchday")
    var currentMatchday: Int?=0,
    @SerializedName("endDate")
    var endDate: String="",
    @SerializedName("id")
    var id: Int=0,
    @SerializedName("startDate")
    var startDate: String="",
    @SerializedName("winner")
    var winner: Any?=Any()
)