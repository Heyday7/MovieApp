package com.heyday7.movieapp.data.api

import com.heyday7.movieapp.data.api.response.Movie
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KtorMovieApi @Inject constructor(
    private val networkService: NetworkService
) : MovieApi {
    override suspend fun getMovie(movieId: Int): Movie =
        networkService.get("https://api.themoviedb.org/3/movie/$movieId")
}