package com.heyday7.movieapp.data.repository

import com.heyday7.movieapp.data.api.KtorMovieApi
import com.heyday7.movieapp.data.api.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DataModule {
    @Provides
    internal fun provideMovieApi(ktorMovieApi: KtorMovieApi): MovieApi {
        return ktorMovieApi
    }

    @Provides
    internal fun provideMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository {
        return movieRepositoryImpl
    }
}