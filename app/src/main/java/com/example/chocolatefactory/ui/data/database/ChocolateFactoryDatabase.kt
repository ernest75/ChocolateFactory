package com.example.chocolatefactory.ui.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [OmpaWorker::class, OmpaWorkerDetail::class], version = 1)
@TypeConverters(FavoriteTypeConverter::class)
abstract class ChocolateFactoryDatabase : RoomDatabase() {

    companion object {
        fun build(context: Context) = Room.databaseBuilder(
            context,
            ChocolateFactoryDatabase::class.java,
            "chocolate-db"
        ).build()
    }

    abstract fun ompaWorkerDao(): OmpaWorkerDAO
}