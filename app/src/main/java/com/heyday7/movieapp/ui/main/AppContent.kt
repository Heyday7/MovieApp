package com.heyday7.movieapp.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.heyday7.movieapp.ui.home.HomeScreen
import com.heyday7.movieapp.ui.home.provideHomeViewModelFactory
import com.heyday7.movieapp.ui.main.viewmodel.RealHomeViewModel

@Composable
fun AppContent() {
    val navController = rememberNavController()

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
    }
}