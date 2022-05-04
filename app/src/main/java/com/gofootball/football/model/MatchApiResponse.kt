package com.gofootball.football.model
import com.google.gson.annotations.SerializedName


 data class MatchApiResponse(
    @SerializedName("count")
    var count: Int=0,
    @SerializedName("filters")
    var filters: Filters,
    @SerializedName("matches")
    var matches: List<Match>
)

data class Filters(
    @SerializedName("dateFrom")
    var dateFrom: String="",
    @SerializedName("dateTo")
    var dateTo: String="",
    @SerializedName("permission")
    var permission: String=""
)

data class Match(
    @SerializedName("awayTeam")
    var awayTeam: AwayTeam=AwayTeam(),
    @SerializedName("competition")
    var competition: Competition=Competition(),
    @SerializedName("group")
    var group: Any?=Any(),
    @SerializedName("homeTeam")
    var homeTeam: HomeTeam,
    @SerializedName("id")
    var id: Int=0,
    @SerializedName("lastUpdated")
    var lastUpdated: String="",
    @SerializedName("matchday")
    var matchday: Int?=0,
    @SerializedName("odds")
    var odds: Odds=Odds(),
    @SerializedName("referees")
    var referees: List<Referee>  = ArrayList(),
    @SerializedName("score")
    var score: Score=Score(),
    @SerializedName("season")
    var season: Season= Season(),
    @SerializedName("stage")
    var stage: String="",
    @SerializedName("status")
    var status: String="",
    @SerializedName("utcDate")
    var utcDate: String=""
)

data class AwayTeam(
    @SerializedName("id")
    var id: Int=0,
    @SerializedName("name")
    var name: String=""
)

data class Competition(
    @SerializedName("area")
    var area: Area=Area(),
    @SerializedName("id")
    var id: Int=0,
    @SerializedName("name")
    var name: String=""
)

data class HomeTeam(
    @SerializedName("id")
    var id: Int=0,
    @SerializedName("name")
    var name: String=""
)

data class Odds(
    @SerializedName("msg")
    var msg: String=""
)

data class Referee(
    @SerializedName("id")
    var id: Int=0,
    @SerializedName("name")
    var name: String="",
    @SerializedName("nationality")
    var nationality: String="",
    @SerializedName("role")
    var role: String=""
)

data class Score(
    @SerializedName("duration")
    var duration: String="",
    @SerializedName("extraTime")
    var extraTime: ExtraTime=ExtraTime(),
    @SerializedName("fullTime")
    var fullTime: FullTime=FullTime(),
    @SerializedName("halfTime")
    var halfTime: HalfTime=HalfTime(),
    @SerializedName("penalties")
    var penalties: Penalties=Penalties(),
    @SerializedName("winner")
    var winner: Any?=Any()
)

data class Season(
    @SerializedName("currentMatchday")
    var currentMatchday: Int=0,
    @SerializedName("endDate")
    var endDate: String="",
    @SerializedName("id")
    var id: Int=0,
    @SerializedName("startDate")
    var startDate: String="",
    @SerializedName("winner")
    var winner: Any?=Any()
)

data class Area(
    @SerializedName("code")
    var code: String="",
    @SerializedName("ensignUrl")
    var ensignUrl: String="",
    @SerializedName("name")
    var name: String=""
)

data class ExtraTime(
    @SerializedName("awayTeam")
    var awayTeam:  Int?=0,
    @SerializedName("homeTeam")
    var homeTeam: Int?=0 ,
)

data class FullTime(
    @SerializedName("awayTeam")
    var awayTeam:  Int?=0,
    @SerializedName("homeTeam")
    var homeTeam: Int?=0
)

data class HalfTime(
    @SerializedName("awayTeam")
    var awayTeam:  Int?=0 ,
    @SerializedName("homeTeam")
    var homeTeam: Int?=0)

data class Penalties(
    @SerializedName("awayTeam")
    var awayTeam: Any?=Any(),
    @SerializedName("homeTeam")
    var homeTeam: Any?=Any()
)