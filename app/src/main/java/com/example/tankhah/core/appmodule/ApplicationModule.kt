package com.example.tankhah.core.appmodule
import android.app.Application
import android.app.Service
import android.content.Context
import androidx.room.Room
import com.example.tankhah.core.database.DataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): DataBase =
        Room.inMemoryDatabaseBuilder(context, DataBase::class.java
        ).build()
}