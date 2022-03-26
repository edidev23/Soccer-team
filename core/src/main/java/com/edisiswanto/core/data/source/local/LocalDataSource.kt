package com.edisiswanto.core.data.source.local

import com.edisiswanto.core.data.source.local.entity.TeamSoccerEntity
import com.edisiswanto.core.data.source.local.room.TeamDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val teamDao: TeamDao) {

    fun getAllTeam(): Flow<List<TeamSoccerEntity>> = teamDao.getAllTeam()

    fun getFavoriteTeam(): Flow<List<TeamSoccerEntity>> = teamDao.getFavoriteTeam()

    suspend fun insertTeam(teamList: List<TeamSoccerEntity>) = teamDao.insertTeam(teamList)

    fun setFavoriteTeam(team: TeamSoccerEntity, newState: Boolean) {
        team.isFavorite = newState
        teamDao.updateFavoriteTeam(team)
    }
}