package com.edith.movies.domain

import com.edith.local.dao.GenderDao
import com.edith.local.dao.MoviesDao
import com.edith.local.model.MovieEntity
import com.edith.remote.model.GenderResponse
import com.edith.remote.model.LastMoviesResponse
import com.edith.remote.model.MovieDb
import com.edith.remote.model.MovieModel
import com.edith.remote.service.ApiService
import com.edith.movies.uimodel.Movie
import com.edith.movies.uimodel.toDomain
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class MoviesDbRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val moviesDao: MoviesDao,
    private val genderDao: GenderDao
) : MoviesDbRepository {

    override suspend fun getGenderMoviesApi(): List<GenderResponse>{
        val response = apiService.listGenresMovies("7175cc36abf3c4b497b768214f16ef0b")
        return if (response.isSuccessful){
            response.body()!!.genres
        }else{
            emptyList()
        }
    }


    override suspend fun getAllNowPlayingMoviesApi(): List<Movie> {
        val response = apiService.listNowPlayingMovies("7175cc36abf3c4b497b768214f16ef0b")
        return if (response.isSuccessful){
            response.body()!!.results.map { it.toDomain() }
        }else{
            emptyList()
        }
    }

    override suspend fun getAllNowPlayingMoviesDb(): List<Movie> {
        val response = moviesDao.getAll()
        return response.map { it.toDomain() }
    }

    override suspend fun insertMovies(movies: List<MovieEntity>){
        moviesDao.insertAll(movies)
    }

    override suspend fun clearMovies(){
        moviesDao.deleteAllMovies()
    }

    override suspend fun getlistTopRatedMovies(): List<MovieModel> {
        val response = apiService.listTopRatedMovies("7175cc36abf3c4b497b768214f16ef0b")
        return if (response.isSuccessful){
            response.body()!!.results
        }else{
            emptyList()
        }
    }

    override suspend fun getLastMovie(): LastMoviesResponse? {
        val response = apiService.lastMovie("7175cc36abf3c4b497b768214f16ef0b")
        return if (response.isSuccessful) {
            response.body()
        }else null
    }

    override suspend fun getAllMovies(): List<MovieDb> {
        val response = apiService.listPopularMovies("7175cc36abf3c4b497b768214f16ef0b")
        return if (response.isSuccessful) {
            response.body()!!.results
        } else {
            emptyList()
        }
    }

}