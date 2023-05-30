package com.tapac1k.bootcounter.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [BootEntity::class],
    version = 1
)
abstract class MainDatabase: RoomDatabase() {
    abstract fun bootDao(): BootDao
}