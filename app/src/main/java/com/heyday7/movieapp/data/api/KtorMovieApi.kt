package com.heyday7.movieapp.data.api

import com.heyday7.movieapp.data.api.response.MovieDTO
import com.heyday7.movieapp.data.api.response.PaginationDTO
import com.heyday7.movieapp.data.api.response.SimpleMovieDTO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KtorMovieApi @Inject constructor(
    private val networkService: NetworkService
) : MovieApi {
    private val url = "https://api.themoviedb.org/3"

    override suspend fun getMovie(movieId: Int): MovieDTO =
        networkService.get("$url/movie/$movieId")

    override suspend fun getMovieNowPlaying(
        page: Int,
        region: String,
        language: String
    ): PaginationDTO<SimpleMovieDTO> =
        networkService.get(
            "$url/movie/now_playing?page=$page&region=$region&language=$language"
        )
}