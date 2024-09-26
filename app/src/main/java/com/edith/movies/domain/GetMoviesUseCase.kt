package com.edith.movies.domain

import com.edith.movies.uimodel.Movie
import com.edith.movies.uimodel.toDatabase
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val repository: MoviesDbRepository) {

    suspend operator fun invoke():List<Movie>{
        val movies = repository.getAllNowPlayingMoviesApi()

       return if (movies.isNotEmpty()){
           repository.clearMovies()
            repository.insertMovies(movies.map { it.toDatabase() })
           movies
        }else{
            repository.getAllNowPlayingMoviesDb()
        }
    }

}