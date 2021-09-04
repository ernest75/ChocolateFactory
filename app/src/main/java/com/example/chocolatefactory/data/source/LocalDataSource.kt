package com.example.chocolatefactory.data.source

import com.example.chocolatefactory.domain.OmpaWorker

interface LocalDataSource {
    suspend fun isEmpty(): Boolean
    suspend fun saveWorkers(ompaWorkerList: List<OmpaWorker>)
    suspend fun getLocalWorkers(): List<OmpaWorker>
}