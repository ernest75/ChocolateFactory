package com.example.chocolatefactory.data.repository

import com.example.chocolatefactory.data.source.RemoteDataSource
import com.example.chocolatefactory.domain.OmpaWorker
import com.example.chocolatefactory.domain.OmpaWorkerDetails

class WorkersRepository(
    private val remoteDataSource: RemoteDataSource,
) {

    suspend fun getOmpaWorkers(): List<OmpaWorker> {
        return remoteDataSource.getWorkers()
    }

    suspend fun getOmpaDetails(workerId:Int): OmpaWorkerDetails {
        return remoteDataSource.getWorkersDetails(workerId)
    }
}