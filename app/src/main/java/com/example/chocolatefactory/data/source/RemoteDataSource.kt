package com.example.chocolatefactory.data.source

import com.example.chocolatefactory.domain.OmpaWorker

interface RemoteDataSource {
    suspend fun getWorkers(): List<OmpaWorker>
}