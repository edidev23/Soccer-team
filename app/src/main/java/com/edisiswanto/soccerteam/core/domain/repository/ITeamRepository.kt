package com.edisiswanto.soccerteam.core.domain.repository

import com.edisiswanto.soccerteam.core.data.Resource
import com.edisiswanto.soccerteam.core.domain.model.TeamSoccer
import kotlinx.coroutines.flow.Flow

interface ITeamRepository {

    fun getAllTeam(): Flow<Resource<List<TeamSoccer>>>

    fun getFavoriteTeam(): Flow<List<TeamSoccer>>

    fun setFavoriteTeam(team: TeamSoccer, state: Boolean)

}