package com.heyday7.movieapp.ui.search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import com.heyday7.movieapp.ui.core.UnidirectionalViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface SearchViewModel :
    UnidirectionalViewModel<
            SearchViewModel.Event,
            SearchViewModel.Effect,
            SearchViewModel.State> {

    data class State(
        val title: String = ""
    )

    sealed class Effect {}

    sealed class Event {}

    override val state: StateFlow<State>
    override val effect: Flow<Effect>
    override fun event(event: Event)

}

private val LocalSearchViewModelFactory =
    compositionLocalOf<@Composable () -> SearchViewModel> {
        {
            error("Not view model provided")
        }
    }

fun provideSearchViewModelFactory(viewModelFactory: @Composable () -> SearchViewModel) =
    LocalSearchViewModelFactory provides viewModelFactory

@Composable
fun searchViewModel() = LocalSearchViewModelFactory.current()