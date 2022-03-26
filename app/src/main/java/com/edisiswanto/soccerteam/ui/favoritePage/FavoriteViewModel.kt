package com.edisiswanto.soccerteam.ui.favoritePage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.edisiswanto.core.domain.usecase.TeamUseCase

class FavoriteViewModel(teamUseCase: TeamUseCase) : ViewModel() {
    val favoriteTeam = teamUseCase.getFavoriteTeam().asLiveData()
}