package com.heyday7.movieapp.data.api

import io.ktor.client.*
import io.ktor.client.request.*

class NetworkService(val httpClient: HttpClient) {

    suspend inline fun <reified T : Any> get(
        url: String
    ): T = try {
        httpClient.get(url)
    } catch (e: Throwable) {
        throw e
    }

    suspend inline fun <reified T> post(
        urlString: String,
        block: HttpRequestBuilder.() -> Unit = {},
    ): T = try {
        httpClient.post(urlString, block)
    } catch (e: Throwable) {
        throw e
    }

    suspend inline fun <reified T> put(
        urlString: String,
        block: HttpRequestBuilder.() -> Unit = {},
    ): T = try {
        httpClient.put(urlString, block)
    } catch (e: Throwable) {
        throw e
    }
}
