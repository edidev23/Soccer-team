package com.edisiswanto.soccerteam.ui.detailPage

import androidx.lifecycle.ViewModel
import com.edisiswanto.soccerteam.core.domain.model.TeamSoccer
import com.edisiswanto.soccerteam.core.domain.usecase.TeamUseCase

class DetailTeamViewModel(private val teamUseCase: TeamUseCase) : ViewModel() {
    fun setFavoriteTeam(team: TeamSoccer, newStatus:Boolean) =
        teamUseCase.setFavoriteTeam(team, newStatus)
}