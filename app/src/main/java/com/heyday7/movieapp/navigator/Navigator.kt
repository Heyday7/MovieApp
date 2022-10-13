package com.heyday7.movieapp.navigator

import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.flow.*

abstract class Navigator {
    val navigationCommands = MutableSharedFlow<NavigationCommand>(extraBufferCapacity = Int.MAX_VALUE)

    val navControllerFlow = MutableStateFlow<NavController?>(null)

    fun navigateUp() {
        navigationCommands.tryEmit(NavigationCommand.NavigateUp)
    }
}

abstract class ComposeNavigator : Navigator() {
    abstract fun navigate(route: String, optionsBuilder: (NavOptionsBuilder.() -> Unit)? = null)

    suspend fun handleNavigationCommands(navController: NavController) {
        navigationCommands
            .onSubscription { this@ComposeNavigator.navControllerFlow.value = navController }
            .onCompletion { this@ComposeNavigator.navControllerFlow.value = null }
            .collect { navController.handleComposeNavigationCommand(it)}
    }

    private fun NavController.handleComposeNavigationCommand(navigationCommand: NavigationCommand) {
        when (navigationCommand) {
            is ComposeNavigationCommand.NavigateToRoute -> {
                navigate(navigationCommand.route, navigationCommand.options)
            }
            is NavigationCommand.NavigateUp -> navigateUp()
        }
    }
}
