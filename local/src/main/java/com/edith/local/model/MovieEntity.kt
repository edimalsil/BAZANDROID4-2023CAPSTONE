package com.edith.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val backdrop_path: String,
    //val genre_ids: List<Int>,
    val original_title: String,
    val poster_path: String,
    val title: String
)
