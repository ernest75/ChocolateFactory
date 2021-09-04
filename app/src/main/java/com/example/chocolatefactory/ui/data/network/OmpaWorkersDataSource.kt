package com.example.chocolatefactory.ui.data.network

import com.example.chocolatefactory.common.toDomainWorker
import com.example.chocolatefactory.common.toDomainWorkerDetails
import com.example.chocolatefactory.data.source.RemoteDataSource
import com.example.chocolatefactory.domain.OmpaWorker
import com.example.chocolatefactory.domain.OmpaWorkerDetails

class OmpaWorkersDataSource(private val retrofitClass: RetrofitClass) : RemoteDataSource {
    override suspend fun getWorkers(): List<OmpaWorker> =
        retrofitClass.service
            .listOmpaWorkersAsync()
            .results
            .map { it.toDomainWorker() }

    override suspend fun getWorkersDetails(workerId: Int): OmpaWorkerDetails {
        return retrofitClass.service
            .ompaWorkerDetailsAsync(workerId).toDomainWorkerDetails()

    }


}