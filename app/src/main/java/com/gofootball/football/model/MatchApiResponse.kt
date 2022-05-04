package com.gofootball.football.model
import com.google.gson.annotations.SerializedName


 data class MatchApiResponse(
    @SerializedName("count")
    var count: Int,
    @SerializedName("filters")
    var filters: Filters,
    @SerializedName("matches")
    var matches: List<Match>
)

data class Filters(
    @SerializedName("dateFrom")
    var dateFrom: String,
    @SerializedName("dateTo")
    var dateTo: String,
    @SerializedName("permission")
    var permission: String
)

data class Match(
    @SerializedName("awayTeam")
    var awayTeam: AwayTeam,
    @SerializedName("competition")
    var competition: Competition,
    @SerializedName("group")
    var group: Any?,
    @SerializedName("homeTeam")
    var homeTeam: HomeTeam,
    @SerializedName("id")
    var id: Int,
    @SerializedName("lastUpdated")
    var lastUpdated: String,
    @SerializedName("matchday")
    var matchday: Int?,
    @SerializedName("odds")
    var odds: Odds,
    @SerializedName("referees")
    var referees: List<Referee>,
    @SerializedName("score")
    var score: Score,
    @SerializedName("season")
    var season: Season,
    @SerializedName("stage")
    var stage: String,
    @SerializedName("status")
    var status: String,
    @SerializedName("utcDate")
    var utcDate: String
)

data class AwayTeam(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String
)

data class Competition(
    @SerializedName("area")
    var area: Area,
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String
)

data class HomeTeam(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String
)

data class Odds(
    @SerializedName("msg")
    var msg: String
)

data class Referee(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("nationality")
    var nationality: String,
    @SerializedName("role")
    var role: String
)

data class Score(
    @SerializedName("duration")
    var duration: String,
    @SerializedName("extraTime")
    var extraTime: ExtraTime,
    @SerializedName("fullTime")
    var fullTime: FullTime,
    @SerializedName("halfTime")
    var halfTime: HalfTime,
    @SerializedName("penalties")
    var penalties: Penalties,
    @SerializedName("winner")
    var winner: Any?
)

data class Season(
    @SerializedName("currentMatchday")
    var currentMatchday: Int,
    @SerializedName("endDate")
    var endDate: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("startDate")
    var startDate: String,
    @SerializedName("winner")
    var winner: Any?
)

data class Area(
    @SerializedName("code")
    var code: String,
    @SerializedName("ensignUrl")
    var ensignUrl: String?,
    @SerializedName("name")
    var name: String
)

data class ExtraTime(
    @SerializedName("awayTeam")
    var awayTeam:  Int? = 0,
    @SerializedName("homeTeam")
    var homeTeam: Int? = 0
)

data class FullTime(
    @SerializedName("awayTeam")
    var awayTeam:  Int? = 0,
    @SerializedName("homeTeam")
    var homeTeam: Int? = 0
)

data class HalfTime(
    @SerializedName("awayTeam")
    var awayTeam:  Int? = 0,
    @SerializedName("homeTeam")
    var homeTeam: Int? = 0
)

data class Penalties(
    @SerializedName("awayTeam")
    var awayTeam: Any?,
    @SerializedName("homeTeam")
    var homeTeam: Any?
)