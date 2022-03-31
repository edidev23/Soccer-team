package com.edisiswanto.soccerteam.di

import com.edisiswanto.core.domain.usecase.TeamInteractor
import com.edisiswanto.core.domain.usecase.TeamUseCase
import com.edisiswanto.soccerteam.ui.detailPage.DetailTeamViewModel
import com.edisiswanto.soccerteam.ui.homePage.HomeViewModel
import com.edisiswanto.soccerteam.ui.searchPage.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TeamUseCase> { TeamInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { DetailTeamViewModel(get()) }
}