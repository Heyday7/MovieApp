package com.heyday7.movieapp.data.api.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SimpleMovieDTO(
    @SerialName("poster_path") val posterPath: String?,
    @SerialName("adult") val adult: Boolean,
    @SerialName("overview") val overview: String,
    @SerialName("release_date") val releaseDate: String,
    @SerialName("genre_ids") val genreIds: List<Int>,
    @SerialName("id") val id: Int,
    @SerialName("original_title") val originalTitle: String,
    @SerialName("original_language") val originalLanguage: String,
    @SerialName("title") val title: String,
    @SerialName("popularity") val popularity: Float
)