package com.edith.movies.uimodel

import com.edith.movies.local.model.MovieEntity
import com.edith.movies.remote.model.MovieModel

data class Movie(
    val id: Int,
    val backdrop_path: String,
    val original_title: String,
    val poster_path: String,
    val title: String
)

fun MovieModel.toDomain() = Movie(id, backdrop_path, original_title, poster_path, title)

fun MovieEntity.toDomain() = Movie(id, backdrop_path, original_title, poster_path, title)
