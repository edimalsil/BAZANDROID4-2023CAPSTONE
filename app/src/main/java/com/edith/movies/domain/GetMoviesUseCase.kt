package com.edith.movies.domain

import com.edith.movies.uimodel.Movie
import com.edith.movies.uimodel.toDatabase
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val repository: MoviesDbRepository) {

   //tener todas las peliculas
    //A cada una de las peliculas sacarle una lista de generos y que sean valores unicos
    //insertar lista de generos en la base de datos

    //Hacer un query directo con las 2 tablas, crear una lista de los valores que tengan dentro del onjeto
    // las peliculas y lista de generos
    //un mapa query de las 2 tablas con un join, mapa con pelicula y lista de generos
    // usar el embeded
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