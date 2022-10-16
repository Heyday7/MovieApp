package com.heyday7.movieapp.data.api.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PaginationDTO<T>(
    @SerialName("page") val page: Int,
    @SerialName("results") val results: List<T>,
    @SerialName("total_pages") val totalPages: Int,
    @SerialName("total_results") val totalResults: Int
)