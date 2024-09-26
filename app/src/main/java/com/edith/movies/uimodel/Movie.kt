package com.edith.movies.uimodel

import com.edith.local.model.MovieEntity
import com.edith.remote.model.MovieResponse

data class Movie(
    val id: Int,
    val backdrop_path: String,
    val original_title: String,
    val poster_path: String,
    val title: String
)

fun MovieResponse.toDomain() = Movie(id, backdrop_path, original_title, poster_path, title)

fun MovieEntity.toDomain() = Movie(id, backdrop_path, original_title, poster_path, title)

fun Movie.toDatabase() = MovieEntity(
    id = id, backdrop_path = backdrop_path, original_title = original_title,
    poster_path = poster_path, title = title
)