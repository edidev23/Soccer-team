package com.edisiswanto.soccerteam.ui.searchPage

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.edisiswanto.core.domain.usecase.TeamUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

class SearchViewModel (teamUseCase: TeamUseCase) : ViewModel() {

    val queryChannel = BroadcastChannel<String>(Channel.CONFLATED)

    val searchResult = queryChannel.asFlow()
        .debounce(100)
        .filter {
            it.trim().isNotEmpty()
        }
        .flatMapLatest {
            teamUseCase.searchTeam(it).flowOn(Dispatchers.Default).conflate()
        }
        .asLiveData()
}