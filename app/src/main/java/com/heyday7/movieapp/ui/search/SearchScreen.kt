package com.heyday7.movieapp.ui.search

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.heyday7.movieapp.ui.core.component.CustomTopBar

@Composable
fun SearchScreen() {
    Column() {
        CustomTopBar(
            titleContent = {
                Text(
                    text = "search",
                    style = MaterialTheme.typography.h3
                )
            }
        )
    }
}