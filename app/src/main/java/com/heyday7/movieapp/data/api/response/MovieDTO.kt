package com.heyday7.movieapp.data.api.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDTO(
    @SerialName("adult") val adult: Boolean,
//    @SerialName("genres") val genres
    @SerialName("id") val id: Int,
    @SerialName("imdb_id") val imdbId: String?,
    @SerialName("original_language") val originalLanguage: String,
    @SerialName("original_title") val originalTitle: String,
    @SerialName("overview") val overview: String,
    @SerialName("popularity") val popularity: Float,
    @SerialName("poster_path") val posterPath: String?,
    @SerialName("production_companies") val productionCompanies: List<CompanyDTO>,
    @SerialName("production_countries") val productionCountries: List<CountryDTO>,
    @SerialName("release_date") val releaseDate: String,
    @SerialName("runtime") val runtime: Int?,
    @SerialName("spoken_languages") val spokenLanguages: List<LanguageDTO>,
    @SerialName("status") val status: String,
    @SerialName("title") val title: String
)

@Serializable
data class CompanyDTO(
    @SerialName("name") val name: String,
    @SerialName("id") val id: Int,
    @SerialName("logo_path") val logoPath: String?,
    @SerialName("origin_country") val originCountry: String
)

@Serializable
data class CountryDTO(
    @SerialName("iso_3166_1") val isoId: String,
    @SerialName("name") val name: String
)

@Serializable
data class LanguageDTO(
    @SerialName("iso_639_1") val isoId: String,
    @SerialName("name") val name: String
)