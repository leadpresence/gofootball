package com.gofootball.football.util

object Constant {
    const val BASE_URL = "https://api-football-v1.p.rapidapi.com/v2/"
    const val   GO_FOOTBALL_BASE_URL ="https://api.football-data.org/v2/"
    const val  GO_FOOTBALL_APP_KEY ="X-Auth-Token: 0018080f230a448188df0a227b4c50f4"
    const val GET_MATCHES = "matches/"


    const val API_KEY = "x-rapidapi-key: 47141ae9bdmshe17613535a3c8cap10199cjsndef2dcecc7d1"
    const val GET_LEAGUE_TABLE = "leagueTable/{league_id}"
    const val GET_TOP_SCORERS = "topscorers/{league_id}"
    const val GET_ALL_TEAMS_OF_LEAGUE = "teams/league/{league_id}"
    const val GET_ALL_PLAYERS_OF_TEAM = "players/squad/{team_id}/2019"
    const val GET_ALL_TRANSFERS_OF_TEAM = "transfers/team/{team_id}"
    const val GET_ALL_FIXTURE_OF_LEAGUE = "fixtures/league/{league_id}"
    const val GET_ALL_H2H_ITEMS = "fixtures/h2h/{home_team_id}/{away_team_id}"
    const val GET_FIXTURE_STATISTICS = "statistics/fixture/{fixture_id}"

    const val TEAM_ID = "team_id"
    const val FIXTURE_TEAM_IDS = "h2h_team_ids"
}