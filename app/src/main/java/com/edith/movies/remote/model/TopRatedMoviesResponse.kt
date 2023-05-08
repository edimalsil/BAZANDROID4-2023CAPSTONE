package com.edith.movies.remote.model

data class TopRatedMoviesResponse(
    val page: Int,
    val results: List<MovieModel>,
    val total_pages: Int,
    val total_results: Int
)