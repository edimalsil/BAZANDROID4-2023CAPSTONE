package com.edith.movies.domain

import com.edith.local.dao.GenderDao
import com.edith.local.dao.MoviesDao
import com.edith.local.di.DataBaseModule
import com.edith.remote.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [DataBaseModule::class])
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        apiService: ApiService,
        moviesDao: MoviesDao,
        genderDao: GenderDao
    ): MoviesDbRepository {
        return MoviesDbRepositoryImp(apiService, moviesDao, genderDao)
    }

}