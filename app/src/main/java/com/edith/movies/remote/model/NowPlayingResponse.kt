package com.edith.movies.remote.model

import com.google.gson.annotations.SerializedName

data class NowPlayingResponse(
    @SerializedName("dates") val datesModel: DatesModel,
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<MovieModel>,
    @SerializedName("total_pages") val total_pages: Int,
    @SerializedName("total_results") val total_results: Int
)