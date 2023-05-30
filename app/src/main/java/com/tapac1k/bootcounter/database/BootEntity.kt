package com.tapac1k.bootcounter.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "boot"
)
data class BootEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val time: Long
)