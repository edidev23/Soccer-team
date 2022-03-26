package com.edisiswanto.core.domain.repository

import com.edisiswanto.core.data.Resource
import com.edisiswanto.core.domain.model.TeamSoccer
import kotlinx.coroutines.flow.Flow

interface ITeamRepository {

    fun getAllTeam(): Flow<Resource<List<TeamSoccer>>>

    fun getFavoriteTeam(): Flow<List<TeamSoccer>>

    fun setFavoriteTeam(team: TeamSoccer, state: Boolean)

}