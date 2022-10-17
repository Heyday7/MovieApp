package com.heyday7.movieapp.data.repository

import com.heyday7.movieapp.data.api.MovieApi
import com.heyday7.movieapp.model.Movie
import com.heyday7.movieapp.model.Pagination
import com.heyday7.movieapp.model.SimpleMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi
) : MovieRepository {

    override suspend fun getMovie(movieId: Int): Movie =
        movieApi.getMovie(movieId).toMovie()

    override fun getMovieNowPlaying(
        page: Int,
        region:String,
        language: String
    ): Flow<Pagination<SimpleMovie>> = flow {
        emit(
            movieApi.getMovieNowPlaying(page, region, language).toPagination { it.toSimpleMovie() }
        )
    }.flowOn(Dispatchers.IO)
}
