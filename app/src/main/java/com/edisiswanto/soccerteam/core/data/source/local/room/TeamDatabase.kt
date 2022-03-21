package com.edisiswanto.soccerteam.core.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.edisiswanto.soccerteam.core.data.source.local.entity.TeamSoccerEntity

@Database(entities = [TeamSoccerEntity::class], version = 1, exportSchema = false)
abstract class TeamDatabase : RoomDatabase() {

    abstract fun teamDao(): TeamDao

    companion object {
        @Volatile
        private var INSTANCE: TeamDatabase? = null

        fun getInstance(context: Context): TeamDatabase =
            INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TeamDatabase::class.java,
                    "Soccer.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
    }
}