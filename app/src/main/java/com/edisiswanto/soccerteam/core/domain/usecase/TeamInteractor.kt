package com.edisiswanto.soccerteam.core.domain.usecase

import com.edisiswanto.soccerteam.core.domain.model.TeamSoccer
import com.edisiswanto.soccerteam.core.domain.repository.ITeamRepository

class TeamInteractor(private val teamRepository: ITeamRepository): TeamUseCase {

    override fun getAllTeam() = teamRepository.getAllTeam()

    override fun getFavoriteTeam() = teamRepository.getFavoriteTeam()

    override fun setFavoriteTeam(team: TeamSoccer, state: Boolean) = teamRepository.setFavoriteTeam(team, state)

}