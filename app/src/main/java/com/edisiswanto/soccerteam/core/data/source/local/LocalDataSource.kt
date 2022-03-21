package com.edisiswanto.soccerteam.core.data.source.local

import com.edisiswanto.soccerteam.core.data.source.local.entity.TeamSoccerEntity
import com.edisiswanto.soccerteam.core.data.source.local.room.TeamDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val teamDao: TeamDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(teamDao: TeamDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(teamDao)
            }
    }

    fun getAllTeam(): Flow<List<TeamSoccerEntity>> = teamDao.getAllTeam()

    fun getFavoriteTeam(): Flow<List<TeamSoccerEntity>> = teamDao.getFavoriteTeam()

    suspend fun insertTeam(teamList: List<TeamSoccerEntity>) = teamDao.insertTeam(teamList)

    fun setFavoriteTeam(team: TeamSoccerEntity, newState: Boolean) {
        team.isFavorite = newState
        teamDao.updateFavoriteTeam(team)
    }
}