package com.edisiswanto.soccerteam.core.data.source.remote.network

import com.edisiswanto.soccerteam.core.data.source.remote.response.ListTeamResponse
import retrofit2.http.GET

interface ApiService {

    @GET("search_all_teams.php?l=English%20Premier%20League")
    suspend fun getList(): ListTeamResponse
}