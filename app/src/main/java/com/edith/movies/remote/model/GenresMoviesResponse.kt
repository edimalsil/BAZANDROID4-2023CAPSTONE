package com.edith.movies.remote.model

data class GenresMoviesResponse(
    val genres: List<GenderResponse>
)

data class GenderResponse(
    val id: Int,
    val string: String
)

