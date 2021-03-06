package com.edisiswanto.soccerteam.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListTeamResponse(

    @field:SerializedName("teams")
    val teams: List<TeamSoccerResponse>

)