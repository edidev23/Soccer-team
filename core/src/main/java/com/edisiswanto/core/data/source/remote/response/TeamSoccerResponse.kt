package com.edisiswanto.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TeamSoccerResponse(

    @field:SerializedName("idTeam")
    val idTeam: String,

    @field:SerializedName("strTeam")
    val name: String,

    @field:SerializedName("strLeague")
    val league: String,

    @field:SerializedName("strSport")
    val sport: String,

    @field:SerializedName("strCountry")
    val country: String,

    @field:SerializedName("strDescriptionEN")
    val description: String,

    @field:SerializedName("strTeamBadge")
    val teamBadge: String,

    @field:SerializedName("strTeamJersey")
    val teamJersey: String,

    @field:SerializedName("strTeamLogo")
    val teamLogo: String,

    @field:SerializedName("strTeamBanner")
    val teamBanner: String,

    @field:SerializedName("strStadium")
    val stadium: String,

    @field:SerializedName("strStadiumThumb")
    val stadiumThumb: String,

    @field:SerializedName("strStadiumLocation")
    val stadiumLocation: String



)