package com.edisiswanto.soccerteam.core.data.source.remote

import android.util.Log
import com.edisiswanto.soccerteam.core.data.source.remote.network.ApiResponse
import com.edisiswanto.soccerteam.core.data.source.remote.network.ApiService
import com.edisiswanto.soccerteam.core.data.source.remote.response.TeamSoccerResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllTeam(): Flow<ApiResponse<List<TeamSoccerResponse>>> {
        //get data from remote api
        return flow {
            try {
                val response = apiService.getList()
                val dataArray = response.teams
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.teams))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}