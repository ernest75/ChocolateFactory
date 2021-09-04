package com.example.chocolatefactory.data.repository

import com.example.chocolatefactory.data.source.LocalDataSource
import com.example.chocolatefactory.data.source.RemoteDataSource
import com.example.chocolatefactory.domain.OmpaWorker
import com.example.chocolatefactory.domain.OmpaWorkerDetails

class WorkersRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {

    suspend fun getOmpaWorkers(): List<OmpaWorker> {

        if (localDataSource.isEmpty()) {
            val workers = remoteDataSource.getWorkers()
            localDataSource.saveWorkers(workers)
        }
        return localDataSource.getLocalWorkers()
    }

    suspend fun getOmpaDetails(workerId: Int): OmpaWorkerDetails {
        return remoteDataSource.getWorkersDetails(workerId)
    }
}