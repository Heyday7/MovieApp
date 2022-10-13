package com.heyday7.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.heyday7.movieapp.ui.home.provideHomeViewModelFactory
import com.heyday7.movieapp.ui.main.viewmodel.RealHomeViewModel
import com.heyday7.movieapp.ui.theme.MovieAppTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel
import com.heyday7.movieapp.ui.home.HomeScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {

                CompositionLocalProvider(
                    provideHomeViewModelFactory { hiltViewModel<RealHomeViewModel>() }
                ) {
                    HomeScreen()
                }
            }
        }
    }
}
