package com.tapac1k.bootcounter.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BootDao {
    @Insert
    suspend fun insert(bootEntity: BootEntity)

    @Query("SELECT * FROM boot")
    fun getBoots(): kotlinx.coroutines.flow.Flow<List<BootEntity>>
}