package com.heyday7.movieapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
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
        Button(
            onClick = {
                dispatch(HomeViewModel.Event.SearchButtonClicked)
            }
        ) {
            Text(text = "Go To Search")
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(
                items = state.moviesNowPlaying
            ) { title ->
                Text(
                    text = title
                )
            }
        }
    }
}