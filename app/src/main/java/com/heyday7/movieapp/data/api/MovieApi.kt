package com.heyday7.movieapp.data.api

import com.heyday7.movieapp.data.api.response.Movie

interface MovieApi {
    suspend fun getMovie(movieId: Int): Movie
}