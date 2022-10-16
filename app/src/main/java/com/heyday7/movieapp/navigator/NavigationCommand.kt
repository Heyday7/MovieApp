package com.heyday7.movieapp.navigator

import androidx.navigation.NavOptions

sealed class NavigationCommand {
    object NavigateUp : NavigationCommand()
}

sealed class ComposeNavigationCommand : NavigationCommand() {
    data class NavigateToRoute(val route: String, val options: NavOptions? = null) :
        ComposeNavigationCommand()
}