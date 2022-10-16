package com.heyday7.movieapp.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.heyday7.movieapp.data.repository.MovieRepository
import com.heyday7.movieapp.navigator.ComposeNavigator
import com.heyday7.movieapp.ui.home.HomeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RealHomeViewModel @Inject constructor(
    movieRepository: MovieRepository,
    private val navigator: ComposeNavigator
) : ViewModel(), HomeViewModel {
    private val effectChannel = Channel<HomeViewModel.Effect>(Channel.UNLIMITED)
    override val effect: Flow<HomeViewModel.Effect> = effectChannel.receiveAsFlow()

    private val _state = MutableStateFlow(HomeViewModel.State())
    override val state: StateFlow<HomeViewModel.State> = _state

    init {
        viewModelScope.launch {
            kotlin.runCatching {
                movieRepository.getMovie(state.value.movieId).title
            }
                .onSuccess { title ->
                    _state.update {
                        it.copy(
                            title = title
                        )
                    }
                }
                .onFailure { e ->
                    e.printStackTrace()
                }
        }
    }

    override fun event(event: HomeViewModel.Event) {
        viewModelScope.launch {
            when (event) {
                HomeViewModel.Event.SearchButtonClicked -> {
                    navigator.navigate("search")
                }
            }
        }
    }
}