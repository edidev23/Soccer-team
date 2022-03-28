package com.edisiswanto.soccerteam.favorite.di

import com.edisiswanto.soccerteam.favorite.ui.FavoriteViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModules = module {
    viewModel { FavoriteViewModel(get()) }
}