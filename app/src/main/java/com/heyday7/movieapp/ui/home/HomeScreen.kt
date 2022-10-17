package com.heyday7.movieapp.ui.home

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.heyday7.movieapp.model.SimpleMovie
import com.heyday7.movieapp.ui.core.component.NetworkImage
import com.heyday7.movieapp.ui.core.use

@Composable
fun HomeScreen() {
    val (state, effect, dispatch) = use(viewModel = homeViewModel())

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "현재 상영장")
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(start = 12.dp, end = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(
                items = state.nowPlayingPaginationState.results,
                key = {_, item -> "movie_${item.id}"}
            ) { index, movie ->
                NowPlayingMovieItem(
                    modifier = Modifier
                        .size(width = 150.dp, height = 400.dp),
                    movie = movie
                )

                if (
                    index == state.nowPlayingPaginationState.results.lastIndex &&
                    state.nowPlayingPaginationState.paginationEnabled
                ) {
                    LaunchedEffect(Unit) {
                        dispatch(HomeViewModel.Event.NowPlayingEndReached)
                    }
                }
            }
            if (state.nowPlayingPaginationState.isLoadingMore) {
                item {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

@Composable
fun NowPlayingMovieItem(
    modifier: Modifier,
    movie: SimpleMovie
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
    ) {
        NetworkImage(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp)),
            imageUrl = movie.posterPath ?: "",
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = movie.title)
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = movie.releaseDate)
    }
}