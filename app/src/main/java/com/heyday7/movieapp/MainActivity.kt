package com.heyday7.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.heyday7.movieapp.navigator.ComposeNavigator
import com.heyday7.movieapp.ui.main.AppContent
import com.heyday7.movieapp.ui.core.theme.MovieAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var composeNavigator: ComposeNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                AppContent(composeNavigator)
            }
        }
    }
}
