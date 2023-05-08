package com.edith.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.edith.local.model.GenderEntity

@Dao
interface GenderDao {
    @Query("SELECT * FROM gender")
    fun getAll(): List<GenderEntity>

    @Insert
    fun insertAll(vararg genderEntity: GenderEntity)

    @Delete
    fun delete(genderEntity: GenderEntity)
}