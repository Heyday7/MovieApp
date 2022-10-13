package com.heyday7.movieapp.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.heyday7.movieapp.navigator.ComposeNavigator
import com.heyday7.movieapp.ui.home.HomeScreen
import com.heyday7.movieapp.ui.home.provideHomeViewModelFactory
import com.heyday7.movieapp.ui.main.viewmodel.RealHomeViewModel
import com.heyday7.movieapp.ui.main.viewmodel.RealSearchViewModel
import com.heyday7.movieapp.ui.search.SearchScreen
import com.heyday7.movieapp.ui.search.provideSearchViewModelFactory

@Composable
fun AppContent(
    composeNavigator: ComposeNavigator
) {

    val navController = rememberNavController()

    LaunchedEffect(Unit) {
        composeNavigator.handleNavigationCommands(navController)
    }

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(
            route = "home"
        ) {
            CompositionLocalProvider(
                provideHomeViewModelFactory { hiltViewModel<RealHomeViewModel>() }
            ) {
                HomeScreen()
            }
        }
        composable(
            route = "search"
        ) {
            CompositionLocalProvider(
                provideSearchViewModelFactory { hiltViewModel<RealSearchViewModel>() }
            ) {
                SearchScreen()
            }
        }
    }
}