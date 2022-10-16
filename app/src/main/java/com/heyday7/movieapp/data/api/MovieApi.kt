package com.heyday7.movieapp.data.api

import com.heyday7.movieapp.data.api.response.MovieDTO
import com.heyday7.movieapp.data.api.response.PaginationDTO
import com.heyday7.movieapp.data.api.response.SimpleMovieDTO

interface MovieApi {
    suspend fun getMovie(movieId: Int): MovieDTO

    suspend fun getMovieNowPlaying(
        page: Int,
        region: String,
        language: String
    ): PaginationDTO<SimpleMovieDTO>
}