package com.heyday7.movieapp.data.repository

import com.heyday7.movieapp.data.api.MovieApi
import com.heyday7.movieapp.data.api.response.*
import com.heyday7.movieapp.model.*
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi
) : MovieRepository {

    override suspend fun getMovie(movieId: Int): Movie =
        movieApi.getMovie(movieId).toMovie()

    override suspend fun getMovieNowPlaying(
        page: Int,
        region:String,
        language: String
    ): Pagination<SimpleMovie> =
        movieApi.getMovieNowPlaying(page, region, language).toPagination { it.toSimpleMovie() }
}

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