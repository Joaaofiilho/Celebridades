package com.joaaoferreiira.celebridades.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.joaaoferreiira.celebridades.database.entity.CelebridadeEntity
import com.joaaoferreiira.celebridades.database.entity.FraseEntity

@Database(version = 2, entities = [CelebridadeEntity::class, FraseEntity::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun celebridadeDao(): CelebridadeDao
    abstract fun celebridadeWithFrasesDao(): CelebridadeWithFrasesDao
    abstract fun fraseDao(): FraseDAO

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "app-db")
                        .fallbackToDestructiveMigration()
                        .build()
                    return INSTANCE!!
                }
            } else {
                return INSTANCE!!
            }
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}