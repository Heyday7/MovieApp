package com.heyday7.movieapp.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import com.heyday7.movieapp.ui.search.SearchViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class RealSearchViewModel @Inject constructor(
) : ViewModel(), SearchViewModel {
    private val effectChannel = Channel<SearchViewModel.Effect>(Channel.UNLIMITED)
    override val effect: Flow<SearchViewModel.Effect> = effectChannel.receiveAsFlow()

    private val _state = MutableStateFlow(SearchViewModel.State())
    override val state: StateFlow<SearchViewModel.State> = _state

    init {

    }

    override fun event(event: SearchViewModel.Event) {
        TODO("Not yet implemented")
    }
}