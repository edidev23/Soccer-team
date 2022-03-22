package com.edisiswanto.soccerteam.ui.homePage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.edisiswanto.soccerteam.core.domain.usecase.TeamUseCase

class HomeViewModel(teamUseCase: TeamUseCase) : ViewModel() {
    val team = teamUseCase.getAllTeam().asLiveData()
}