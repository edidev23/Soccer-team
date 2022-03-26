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
                sport = it.sport,
                country = it.country,
                description = it.description,
                teamBadge = it.teamBadge,
                teamJersey = it.teamJersey,
                teamLogo = it.teamLogo,
                teamBanner = it.teamBanner,
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
                sport = it.sport,
                country = it.country,
                description = it.description,
                teamBadge = it.teamBadge,
                teamJersey = it.teamJersey,
                teamLogo = it.teamLogo,
                teamBanner = it.teamBanner,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: TeamSoccer) = TeamSoccerEntity(
        idTeam = input.idTeam,
        name = input.name,
        league = input.league,
        sport = input.sport,
        country = input.country,
        description = input.description,
        teamBadge = input.teamBadge,
        teamJersey = input.teamJersey,
        teamLogo = input.teamLogo,
        teamBanner = input.teamBanner,
        isFavorite = input.isFavorite
    )
}