package com.heyday7.movieapp.ui.main.viewmodel

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
    private val movieRepository: MovieRepository,
    private val navigator: ComposeNavigator
) : ViewModel(), HomeViewModel {
    private val effectChannel = Channel<HomeViewModel.Effect>(Channel.UNLIMITED)
    override val effect: Flow<HomeViewModel.Effect> = effectChannel.receiveAsFlow()

    private val _state = MutableStateFlow(HomeViewModel.State())
    override val state: StateFlow<HomeViewModel.State> = _state

    init {
        viewModelScope.launch {
            kotlin.runCatching {
                movieRepository.getMovie(state.value.movieId)
            }
                .onSuccess { movie ->
                    _state.update {
                        it.copy(
                            title = movie.title
                        )
                    }
                }
                .onFailure { e ->
                    e.printStackTrace()
                }
        }
        movieRepository.getMovieNowPlaying(page = 1, language = "ko")
            .onStart {
                _state.update {
                    it.copy(
                        nowPlayingPaginationState = HomeViewModel.NowPlayingPaginationState(
                            isLoading = true,
                            page = 1
                        )
                    )
                }
            }
            .onEach { pagination ->
                _state.update {
                    it.copy(
                        nowPlayingPaginationState = it.nowPlayingPaginationState.copy(
                            results = pagination.results,
                            totalPages = pagination.totalPages
                        )
                    )
                }
            }
            .onCompletion {
                _state.update {
                    it.copy(
                        nowPlayingPaginationState = it.nowPlayingPaginationState.copy(
                            isLoading = false
                        )
                    )
                }
            }
            .catch { e -> e.printStackTrace() }
            .launchIn(viewModelScope)
    }

    private suspend fun loadMoreNowPlaying() {
        val targetPage = _state.value.nowPlayingPaginationState.page + 1

        _state.update {
            it.copy(
                nowPlayingPaginationState = it.nowPlayingPaginationState.copy(
                    isLoadingMore = true
                )
            )
        }

        kotlin.runCatching {
            movieRepository.getMovieNowPlaying(targetPage).single()
        }
            .onSuccess { paginationResult ->
                _state.update {
                    it.copy(
                        nowPlayingPaginationState = it.nowPlayingPaginationState.copy(
                            results = it.nowPlayingPaginationState.results + paginationResult.results,
                            page = paginationResult.page,
                            totalPages = paginationResult.totalPages
                        )
                    )
                }
            }
            .onFailure { e -> e.printStackTrace() }

        _state.update {
            it.copy(
                nowPlayingPaginationState = it.nowPlayingPaginationState.copy(
                    isLoadingMore = false
                )
            )
        }
    }

    override fun event(event: HomeViewModel.Event) {
        viewModelScope.launch {
            when (event) {
                is HomeViewModel.Event.SearchButtonClicked -> {
                    navigator.navigate("search")
                }
                is HomeViewModel.Event.NowPlayingEndReached -> {
                    loadMoreNowPlaying()
                }
            }
        }
    }
}