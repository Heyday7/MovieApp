package com.heyday7.movieapp.navigator

import androidx.navigation.NavOptionsBuilder
import androidx.navigation.navOptions
import javax.inject.Inject


class MovieAppNavigator @Inject constructor() : ComposeNavigator() {
    override fun navigate(route: String, optionsBuilder: (NavOptionsBuilder.() -> Unit)?) {
        val options = optionsBuilder?.let { navOptions(it) }
        navigationCommands.tryEmit(ComposeNavigationCommand.NavigateToRoute(route, options))
    }
}