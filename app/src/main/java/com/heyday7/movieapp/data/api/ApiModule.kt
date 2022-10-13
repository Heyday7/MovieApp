package com.heyday7.movieapp.data.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import okhttp3.Interceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Singleton
    @Provides
    internal fun provideOkHttpNetworkInterceptors(): List<Interceptor> {
        return listOf()
    }

    @Singleton
    @Provides
    internal fun provideHttpClient(
        networkInterceptors: List<@JvmSuppressWildcards Interceptor>,
    ): HttpClient {
        return ApiHttpClient.create(
            engineFactory = OkHttp
        ) {
            networkInterceptors.forEach { addNetworkInterceptor(it) }
        }
    }

    @Singleton
    @Provides
    internal fun provideNetworkService(
        httpClient: HttpClient
    ): NetworkService {
        return NetworkService(httpClient)
    }
}