package com.tapac1k.bootcounter

import com.tapac1k.bootcounter.database.BootEntity
import com.tapac1k.bootcounter.database.MainDatabase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseRepository @Inject constructor(
    private val mainDatabase: MainDatabase
) {
    private val bootDao = mainDatabase.bootDao()

    suspend fun addBoot(time: Long) {
        bootDao.insert(BootEntity(time = time))
    }

    fun subscribeBoots(): Flow<List<BootEntity>> {
        return bootDao.getBoots()
    }
}