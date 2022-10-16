package com.heyday7.movieapp.model


data class Movie(
    val adult: Boolean,
//    @SerialName("genres") val genres
    val id: Int,
    val imdbId: String?,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Float,
    val posterPath: String?,
    val productionCompanies: List<Company>,
    val productionCountries: List<Country>,
    val releaseDate: String,
    val runtime: Int?,
    val spokenLanguages: List<Language>,
    val status: String,
    val title: String
)

data class Company(
    val name: String,
    val id: Int,
    val logoPath: String?,
    val originCountry: String
)

data class Country(
    val isoId: String,
    val name: String
)

data class Language(
    val isoId: String,
    val name: String
)