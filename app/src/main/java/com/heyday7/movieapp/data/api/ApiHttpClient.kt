package com.heyday7.movieapp.data.api

import com.heyday7.movieapp.BuildConfig
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.features.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule

object ApiHttpClient {
    internal fun <T> create(
        engineFactory: HttpClientEngineFactory<T>,
        block: T.() -> Unit = {},
    ): HttpClient where T : HttpClientEngineConfig {
        return HttpClient(engineFactory) {
            engine(block)
            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    Json {
                        serializersModule = SerializersModule {}
                        ignoreUnknownKeys = true
                        coerceInputValues = true
                        useAlternativeNames = false
                    }
                )
            }
            defaultRequest {
                headers {
                    set("Authorization", "Bearer $APIKEY")
                }
            }
        }
    }
}

private const val APIKEY = BuildConfig.API_KEY