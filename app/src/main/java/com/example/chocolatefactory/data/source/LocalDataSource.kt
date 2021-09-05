package com.example.chocolatefactory.data.source

import com.example.chocolatefactory.domain.OmpaWorker
import com.example.chocolatefactory.domain.OmpaWorkerDetails

interface LocalDataSource {
    suspend fun isEmpty(): Boolean
    suspend fun saveWorkers(ompaWorkerList: List<OmpaWorker>)
    suspend fun getLocalWorkers(): List<OmpaWorker>
    suspend fun saveWorkersDetails(workerId:Int, ompaWorkerDetails: OmpaWorkerDetails)
    suspend fun finWorkersDetailsByIdIdEmpty(id:Int) :Boolean
    suspend fun findWorkersDetailsById(id: Int): OmpaWorkerDetails
}