package com.edith.movies.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.edith.movies.local.dao.GenderDao
import com.edith.movies.local.dao.MoviesDao
import com.edith.movies.local.model.GenderEntity
import com.edith.movies.local.model.MovieEntity


@Database(entities = [MovieEntity::class, GenderEntity::class], version = 1)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun movieDao(): MoviesDao

    abstract fun genderDao(): GenderDao

}