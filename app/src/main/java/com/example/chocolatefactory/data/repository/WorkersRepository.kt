package com.example.chocolatefactory.data.repository

import com.example.chocolatefactory.data.source.RemoteDataSource
import com.example.chocolatefactory.domain.OmpaWorker

class WorkersRepository(
    private val remoteDataSource: RemoteDataSource,
) {

    suspend fun getOmpaWorkers(): List<OmpaWorker> {
        return remoteDataSource.getWorkers()
    }
}