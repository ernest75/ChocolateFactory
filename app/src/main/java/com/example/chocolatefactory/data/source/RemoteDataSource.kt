package com.example.chocolatefactory.data.source

import com.example.chocolatefactory.domain.OmpaWorker
import com.example.chocolatefactory.domain.OmpaWorkerDetails
import com.example.chocolatefactory.ui.data.network.models.WorkerDetails

interface RemoteDataSource {
    suspend fun getWorkers(): List<OmpaWorker>
    suspend fun getWorkersDetails(workerId:Int): OmpaWorkerDetails
}