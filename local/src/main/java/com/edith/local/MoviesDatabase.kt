package com.edith.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.edith.local.dao.GenderDao
import com.edith.local.dao.MoviesDao
import com.edith.local.model.GenderEntity
import com.edith.local.model.MovieEntity

@Database(entities = [MovieEntity::class, GenderEntity::class], version = 1)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun movieDao(): MoviesDao

    abstract fun genderDao(): GenderDao

}