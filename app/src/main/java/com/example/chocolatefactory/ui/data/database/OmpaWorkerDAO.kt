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
    fun insertWorkers(workers: List<OmpaWorker>)

    @Query("SELECT COUNT(id) FROM OmpaWorker")
    fun workersCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertWorkerDetails(workerDetails: OmpaWorkerDetail)

    @Query("SELECT * FROM OmpaWorkerDetail WHERE workerID = :id")
    fun findWorkerDetailById(id: Int): OmpaWorkerDetail

    @Query("SELECT COUNT(workerId) FROM OmpaWorkerDetail WHERE workerID = :workerId")
    fun detailsCount(workerId:Int): Int

}