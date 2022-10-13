package com.heyday7.movieapp.data.repository

import com.heyday7.movieapp.data.api.response.Movie

interface MovieRepository {
    suspend fun getMovie(movieId: Int): Movie
}