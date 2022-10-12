package com.heyday7.movieapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.heyday7.movieapp.ui.core.use

@Composable
fun HomeScreen() {
    val (state, effect, dispatch) = use(viewModel = homeViewModel())

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "this is test"
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .background(Color.Blue),
            text = state.title,
            color = Color.Red
        )
    }
}