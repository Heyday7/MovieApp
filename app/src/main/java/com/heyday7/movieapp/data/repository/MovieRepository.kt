package com.heyday7.movieapp.data.repository


import com.heyday7.movieapp.model.Movie
import com.heyday7.movieapp.model.Pagination
import com.heyday7.movieapp.model.SimpleMovie

interface MovieRepository {
    suspend fun getMovie(movieId: Int): Movie
    suspend fun getMovieNowPlaying(
        page: Int,
        region:String = "KR",
        language: String = "ko"
    ): Pagination<SimpleMovie>
}