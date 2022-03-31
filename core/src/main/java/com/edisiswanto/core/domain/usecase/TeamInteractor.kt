package com.edisiswanto.core.domain.usecase

import com.edisiswanto.core.domain.model.TeamSoccer
import com.edisiswanto.core.domain.repository.ITeamRepository

class TeamInteractor(private val teamRepository: ITeamRepository): TeamUseCase {

    override fun getAllTeam() = teamRepository.getAllTeam()

    override fun getFavoriteTeam() = teamRepository.getFavoriteTeam()

    override fun setFavoriteTeam(team: TeamSoccer, state: Boolean) = teamRepository.setFavoriteTeam(team, state)

    override fun searchTeam(title: String) = teamRepository.searchTeam(title)

}