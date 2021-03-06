package com.edisiswanto.soccerteam.core.data

import com.edisiswanto.soccerteam.core.data.source.local.LocalDataSource
import com.edisiswanto.soccerteam.core.data.source.remote.RemoteDataSource
import com.edisiswanto.soccerteam.core.data.source.remote.network.ApiResponse
import com.edisiswanto.soccerteam.core.data.source.remote.response.TeamSoccerResponse
import com.edisiswanto.soccerteam.core.domain.model.TeamSoccer
import com.edisiswanto.soccerteam.core.domain.repository.ITeamRepository
import com.edisiswanto.soccerteam.core.utils.AppExecutors
import com.edisiswanto.soccerteam.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TeamRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ITeamRepository {

    companion object {
        @Volatile
        private var instance: TeamRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): TeamRepository =
            instance ?: synchronized(this) {
                instance ?: TeamRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllTeam(): Flow<Resource<List<TeamSoccer>>> =
        object : NetworkBoundResource<List<TeamSoccer>, List<TeamSoccerResponse>>() {
            override fun loadFromDB(): Flow<List<TeamSoccer>> {
                return localDataSource.getAllTeam().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<TeamSoccer>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<TeamSoccerResponse>>> =
                remoteDataSource.getAllTeam()

            override suspend fun saveCallResult(data: List<TeamSoccerResponse>) {
                val teamList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTeam(teamList)
            }
        }.asFlow()

    override fun getFavoriteTeam(): Flow<List<TeamSoccer>> {
        return localDataSource.getFavoriteTeam().map { DataMapper.mapEntitiesToDomain(it) }

    }

    override fun setFavoriteTeam(team: TeamSoccer, state: Boolean) {
        val teamEntity = DataMapper.mapDomainToEntity(team)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTeam(teamEntity, state) }
    }
}