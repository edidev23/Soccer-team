package com.edisiswanto.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team")
data class TeamSoccerEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idTeam")
    var idTeam: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "league")
    var league: String,

    @ColumnInfo(name = "sport")
    var sport: String,

    @ColumnInfo(name = "country")
    var country: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "teamBadge")
    var teamBadge: String,

    @ColumnInfo(name = "teamJersey")
    var teamJersey: String,

    @ColumnInfo(name = "teamLogo")
    var teamLogo: String,

    @ColumnInfo(name = "teamBanner")
    var teamBanner: String,

    @ColumnInfo(name = "stadium")
    var stadium: String,

    @ColumnInfo(name = "stadiumThumb")
    var stadiumThumb: String,

    @ColumnInfo(name = "stadiumLocation")
    var stadiumLocation: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)