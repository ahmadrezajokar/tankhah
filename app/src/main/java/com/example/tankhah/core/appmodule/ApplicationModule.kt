package com.example.tankhah.core.appmodule
import android.app.Application
import android.app.Service
import android.content.Context
import androidx.room.Room
import com.example.tankhah.core.database.DataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(FragmentComponent::class)
object ApplicationModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = DataBase.getDatabase(appContext)

//    @Singleton
//    fun provideDatabase(@ApplicationContext context: Context): DataBase =
//        Room.inMemoryDatabaseBuilder(context, DataBase::class.java
//        ).build()

}