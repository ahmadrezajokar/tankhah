package com.example.tankhah.core.database

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tankhah.BuildConfig.VERSION_CODE
import com.example.tankhah.core.Faktor.model.ItemFaktorModel
import com.example.tankhah.core.model.modelfokh
import com.example.tankhah.core.tan.model
import androidx.sqlite.db.SupportSQLiteDatabase

import androidx.room.migration.Migration




@Database( entities = [model::class,ItemFaktorModel::class,modelfokh::class],version = VERSION_CODE,exportSchema = true)
    abstract class DataBase() : RoomDatabase() {

    abstract val dao: Dao?

    //        companion object {
//            private var dataBase: DataBase? = null
//            fun getAppDataBase(context: Context): DataBase? {
//                if (dataBase == null) {
//                    dataBase = Room.databaseBuilder(
//                        context.getApplicationContext(),
//                        DataBase::class.java, "db_tankhah"
//                    )
//                        .allowMainThreadQueries()
//                        .build()
//                }
//                return dataBase
//            }
//        }
//companion object {
//    private const val DB_NAME = "tankhah.db"
//    @Volatile private var instance: DataBase? = null
//    private val LOCK = Any()
//
//    operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
//        instance ?: buildDatabase(context).also {
//            instance = it
//        }
//    }
//
//    private fun buildDatabase(context: Context) = Room.databaseBuilder(
//        context.applicationContext,
//        DataBase::class.java,
//        DB_NAME
//    ).build()
//}



}