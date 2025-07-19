package com.example.jetpackcomposeretrofit.di

import com.example.jetpackcomposeretrofit.data.remote.api.ApiService
import com.example.jetpackcomposeretrofit.data.repo.CatRepositoryImpl
import com.example.jetpackcomposeretrofit.domain.repo.CatRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCatRepository(apiService: ApiService): CatRepository {
        return CatRepositoryImpl(apiService)
    }
}