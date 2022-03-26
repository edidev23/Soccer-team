package com.edisiswanto.soccerteam.di

import com.edisiswanto.core.domain.usecase.TeamInteractor
import com.edisiswanto.core.domain.usecase.TeamUseCase
import com.edisiswanto.soccerteam.ui.detailPage.DetailTeamViewModel
import com.edisiswanto.soccerteam.ui.favoritePage.FavoriteViewModel
import com.edisiswanto.soccerteam.ui.homePage.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TeamUseCase> { TeamInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailTeamViewModel(get()) }
}