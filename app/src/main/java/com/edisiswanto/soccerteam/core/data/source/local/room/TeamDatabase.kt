package com.edisiswanto.soccerteam.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.edisiswanto.soccerteam.core.data.source.local.entity.TeamSoccerEntity

@Database(entities = [TeamSoccerEntity::class], version = 1, exportSchema = false)
abstract class TeamDatabase : RoomDatabase() {

    abstract fun teamDao(): TeamDao

}