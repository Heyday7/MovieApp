package com.heyday7.movieapp.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import com.heyday7.movieapp.ui.core.UnidirectionalViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface HomeViewModel :
    UnidirectionalViewModel<
        HomeViewModel.Event,
        HomeViewModel.Effect,
        HomeViewModel.State> {

    data class State(
        val movieId: Int = 76431,
        val title: String = ""
    )

    sealed class Effect {}

    sealed class Event {
        object SearchButtonClicked : Event()
    }

    override val state: StateFlow<State>
    override val effect: Flow<Effect>
    override fun event(event: Event)

}

private val LocalMovieViewModelFactory =
    compositionLocalOf<@Composable () -> HomeViewModel> {
        {
            error("Not view model provided")
        }
    }

fun provideHomeViewModelFactory(viewModelFactory: @Composable () -> HomeViewModel) =
    LocalMovieViewModelFactory provides viewModelFactory

@Composable
fun homeViewModel() = LocalMovieViewModelFactory.current()