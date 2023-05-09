package com.edith.remote.model

import com.google.gson.annotations.SerializedName

data class NowPlayingResponse(
    @SerializedName("dates") val datesResponse: DatesResponse,
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<MovieResponse>,
    @SerializedName("total_pages") val total_pages: Int,
    @SerializedName("total_results") val total_results: Int
)