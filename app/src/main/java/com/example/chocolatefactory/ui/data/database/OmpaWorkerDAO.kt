package com.example.chocolatefactory.ui.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface OmpaWorkerDAO {

    @Query("SELECT * FROM OmpaWorker")
    fun getAllWorkers(): List<OmpaWorker>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertWorkers(movies: List<OmpaWorker>)

    @Query("SELECT COUNT(id) FROM OmpaWorker")
    fun movieCount(): Int
}