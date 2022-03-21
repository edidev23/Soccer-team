package com.edisiswanto.soccerteam.di

import com.edisiswanto.soccerteam.core.domain.usecase.TeamInteractor
import com.edisiswanto.soccerteam.core.domain.usecase.TeamUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<TeamUseCase> { TeamInteractor(get()) }
}