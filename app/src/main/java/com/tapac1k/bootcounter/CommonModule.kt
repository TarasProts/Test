package com.tapac1k.bootcounter

import android.content.Context
import androidx.room.Room
import com.tapac1k.bootcounter.database.MainDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideMainDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, MainDatabase::class.java, "main.db")
            .setTransactionExecutor(Executors.newSingleThreadExecutor())
            .build()
}