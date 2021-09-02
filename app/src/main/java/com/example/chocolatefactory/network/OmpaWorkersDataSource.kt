package com.example.chocolatefactory.network

import com.example.chocolatefactory.common.toDomainWorker
import com.example.chocolatefactory.data.source.RemoteDataSource
import com.example.chocolatefactory.domain.OmpaWorker

class OmpaWorkersDataSource(private val retrofitClass: RetrofitClass) : RemoteDataSource {
    override suspend fun getWorkers(): List<OmpaWorker> =
        retrofitClass.service
            .listOmpaWorkersAsync()
            .results
            .map { it.toDomainWorker() }

}