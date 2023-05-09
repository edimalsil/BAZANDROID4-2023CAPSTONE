package com.edith.movies.domain


import com.edith.local.model.MovieEntity
import com.edith.remote.model.GenderResponse
import com.edith.remote.model.LastMoviesResponse
import com.edith.remote.model.MovieResponse
import com.edith.movies.uimodel.Movie

interface MoviesDbRepository {

    suspend fun getGenderMoviesApi(): List<GenderResponse>
    suspend fun getAllNowPlayingMoviesApi(): List<Movie>
    suspend fun getAllNowPlayingMoviesDb(): List<Movie>
    suspend fun insertMovies(movies: List<MovieEntity>)
    suspend fun clearMovies()
    suspend fun getListTopRatedMovies(): List<MovieResponse>
    suspend fun getLastMovie(): LastMoviesResponse?


}