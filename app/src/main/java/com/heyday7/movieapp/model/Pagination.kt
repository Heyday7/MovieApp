package com.heyday7.movieapp.model

import kotlinx.serialization.SerialName

data class Pagination<T>(
    val page: Int,
    val results: List<T>,
    val totalPages: Int,
    val totalResults: Int
)