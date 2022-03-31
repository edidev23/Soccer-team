package com.edisiswanto.core.data.source.local.room

import androidx.room.*
import com.edisiswanto.core.data.source.local.entity.TeamSoccerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {

    @Query("SELECT * FROM team")
    fun getAllTeam(): Flow<List<TeamSoccerEntity>>

    @Query("SELECT * FROM team where isFavorite = 1")
    fun getFavoriteTeam(): Flow<List<TeamSoccerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeam(teamList: List<TeamSoccerEntity>)

    @Update
    fun updateFavoriteTeam(team: TeamSoccerEntity)

    @Query("SELECT * FROM team where name LIKE '%' || :title || '%'")
    fun searchTeam(title: String): Flow<List<TeamSoccerEntity>>
}