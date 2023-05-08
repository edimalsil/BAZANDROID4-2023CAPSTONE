package com.edith.movies.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gender")
data class GenderEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
)


