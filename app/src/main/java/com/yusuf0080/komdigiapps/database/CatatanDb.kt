package com.yusuf0080.komdigiapps.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yusuf0080.komdigiapps.model.Catatan
import com.yusuf0080.komdigiapps.model.User

@Database(entities = [Catatan::class, User::class], version = 3, exportSchema = false)
abstract class CatatanDb : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract val dao: CatatanDao

    companion object {
        @Volatile
        private var INSTANCE: CatatanDb? = null

        fun getInstance(context: Context): CatatanDb {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CatatanDb::class.java,
                    "catatan.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}