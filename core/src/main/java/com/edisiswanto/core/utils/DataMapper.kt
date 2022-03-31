package com.edisiswanto.core.utils

import com.edisiswanto.core.data.source.local.entity.TeamSoccerEntity
import com.edisiswanto.core.data.source.remote.response.TeamSoccerResponse
import com.edisiswanto.core.domain.model.TeamSoccer

object DataMapper {
    fun mapResponsesToEntities(input: List<TeamSoccerResponse>): List<TeamSoccerEntity> {
        val teamList = ArrayList<TeamSoccerEntity>()
        input.map {
            val team = TeamSoccerEntity(
                idTeam = it.idTeam,
                name = it.name,
                league = it.league,
                league2 = it.league2,
                league3 = it.league3,
                sport = it.sport,
                country = it.country,
                description = it.description,
                teamBadge = it.teamBadge,
                teamJersey = it.teamJersey,
                teamLogo = it.teamLogo,
                teamBanner = it.teamBanner,
                stadium = it.stadium,
                stadiumThumb = it.stadiumThumb,
                stadiumLocation = it.stadiumLocation,
                isFavorite = false
            )
            teamList.add(team)
        }
        return teamList
    }

    fun mapEntitiesToDomain(input: List<TeamSoccerEntity>): List<TeamSoccer> =
        input.map {
            TeamSoccer(
                idTeam = it.idTeam,
                name = it.name,
                league = it.league,
                league2 = it.league2,
                league3 = it.league3,
                sport = it.sport,
                country = it.country,
                description = it.description,
                teamBadge = it.teamBadge,
                teamJersey = it.teamJersey,
                teamLogo = it.teamLogo,
                teamBanner = it.teamBanner,
                stadium = it.stadium,
                stadiumThumb = it.stadiumThumb,
                stadiumLocation = it.stadiumLocation,
                isFavorite = it.isFavorite
            )
        }

    fun mapEntitiesToDomainObject(input: TeamSoccerEntity): TeamSoccer =
        TeamSoccer(
            idTeam = input.idTeam,
            name = input.name,
            league = input.league,
            league2 = input.league2,
            league3 = input.league3,
            sport = input.sport,
            country = input.country,
            description = input.description,
            teamBadge = input.teamBadge,
            teamJersey = input.teamJersey,
            teamLogo = input.teamLogo,
            teamBanner = input.teamBanner,
            stadium = input.stadium,
            stadiumThumb = input.stadiumThumb,
            stadiumLocation = input.stadiumLocation,
            isFavorite = input.isFavorite
        )

    fun mapDomainToEntity(input: TeamSoccer) = TeamSoccerEntity(
        idTeam = input.idTeam,
        name = input.name,
        league = input.league,
        league2 = input.league2,
        league3 = input.league3,
        sport = input.sport,
        country = input.country,
        description = input.description,
        teamBadge = input.teamBadge,
        teamJersey = input.teamJersey,
        teamLogo = input.teamLogo,
        teamBanner = input.teamBanner,
        stadium = input.stadium,
        stadiumThumb = input.stadiumThumb,
        stadiumLocation = input.stadiumLocation,
        isFavorite = input.isFavorite
    )
}