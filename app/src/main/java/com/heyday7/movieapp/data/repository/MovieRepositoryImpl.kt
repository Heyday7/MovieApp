package com.heyday7.movieapp.data.repository

import com.heyday7.movieapp.data.api.MovieApi
import com.heyday7.movieapp.data.api.response.Movie
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi
) : MovieRepository {
    override suspend fun getMovie(movieId: Int): Movie =
        movieApi.getMovie(movieId)
}