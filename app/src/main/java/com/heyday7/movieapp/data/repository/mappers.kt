package com.heyday7.movieapp.data.repository

import com.heyday7.movieapp.data.api.response.*
import com.heyday7.movieapp.model.*

fun MovieDTO.toMovie() = Movie(
    adult,
    id,
    imdbId,
    originalLanguage,
    originalTitle,
    overview,
    popularity,
    posterPath,
    productionCompanies.map { it.toCompany() },
    productionCountries.map { it.toCountry() },
    releaseDate,
    runtime,
    spokenLanguages.map { it.toLanguage() },
    status,
    title
)

fun CompanyDTO.toCompany() = Company(
    name, id, logoPath, originCountry
)

fun CountryDTO.toCountry() = Country(
    isoId, name
)

fun LanguageDTO.toLanguage() = Language(
    isoId, name
)

// SimpleMovie
fun SimpleMovieDTO.toSimpleMovie() = SimpleMovie(
    posterPath,
    adult,
    overview,
    releaseDate,
    genreIds,
    id,
    originalTitle,
    originalLanguage,
    title,
    popularity
)

// Pagination
fun <T, R> PaginationDTO<T>.toPagination(transformer: (T) -> (R)) = Pagination(
    page,
    results.map { transformer(it) },
    totalPages,
    totalResults
)
