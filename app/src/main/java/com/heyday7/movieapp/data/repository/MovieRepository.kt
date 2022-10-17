package com.heyday7.movieapp.data.repository


import com.heyday7.movieapp.model.Movie
import com.heyday7.movieapp.model.Pagination
import com.heyday7.movieapp.model.SimpleMovie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMovie(movieId: Int): Movie
    fun getMovieNowPlaying(
        page: Int,
        region:String = "KR",
        language: String = "ko"
    ): Flow<Pagination<SimpleMovie>>
}