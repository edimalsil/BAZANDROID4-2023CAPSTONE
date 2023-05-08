package com.edith.movies.remote.di

import com.edith.movies.local.dao.GenderDao
import com.edith.movies.local.dao.MoviesDao
import com.edith.movies.remote.service.ApiService
import com.edith.movies.local.di.DataBaseModule
import com.edith.movies.domain.MoviesDbRepositoryImp
import com.edith.movies.domain.MoviesDbRepository
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