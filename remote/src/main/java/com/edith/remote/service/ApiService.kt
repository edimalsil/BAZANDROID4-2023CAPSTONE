package com.edith.remote.service

import com.edith.remote.model.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/latest")
    suspend fun lastMovie(@Query("api_key") apiKey: String): Response<LastMoviesResponse>

    @GET("movie/now_playing")
    suspend fun listNowPlayingMovies(@Query("api_key") apiKey: String): Response<NowPlayingResponse>

    @GET("movie/top_rated")
    suspend fun listTopRatedMovies(@Query("api_key") apiKey: String): Response<TopRatedMoviesResponse>

    @GET("genre/movie/list")
    suspend fun listGenresMovies(@Query("api_key") apiKey: String): Response<GenresMoviesResponse>

}