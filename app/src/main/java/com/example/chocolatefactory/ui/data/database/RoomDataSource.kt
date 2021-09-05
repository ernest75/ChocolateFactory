package com.example.chocolatefactory.ui.data.database

import com.example.chocolatefactory.common.toDomainWorker
import com.example.chocolatefactory.common.toDomainWorkerDetails
import com.example.chocolatefactory.common.toRoomWorker
import com.example.chocolatefactory.common.toRoomWorkerDetails
import com.example.chocolatefactory.data.source.LocalDataSource
import com.example.chocolatefactory.domain.OmpaWorker
import com.example.chocolatefactory.domain.OmpaWorkerDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSource (db: ChocolateFactoryDatabase) : LocalDataSource {

    private val workerDAO = db.ompaWorkerDao()

    override suspend fun isEmpty(): Boolean =
        withContext(Dispatchers.IO) { workerDAO.workersCount() <= 0 }

    override suspend fun saveWorkers(ompaWorkerList: List<OmpaWorker>) {
        withContext(Dispatchers.IO) { workerDAO.insertWorkers(ompaWorkerList.map { it.toRoomWorker() }) }
    }

    override suspend fun getLocalWorkers(): List<OmpaWorker> =
        withContext(Dispatchers.IO){
            workerDAO.getAllWorkers().map { it.toDomainWorker() }
        }

    override suspend fun saveWorkersDetails(workerId:Int, ompaWorkerDetails:OmpaWorkerDetails) {
        withContext(Dispatchers.IO){
            workerDAO.insertWorkerDetails(ompaWorkerDetails.toRoomWorkerDetails(workerId))
        }
    }

    override suspend fun finWorkersDetailsByIdIdEmpty(id: Int): Boolean =
        withContext(Dispatchers.IO){
            workerDAO.detailsCount(id) <= 0
        }

    override suspend fun findWorkersDetailsById(id: Int): OmpaWorkerDetails  =
        withContext(Dispatchers.IO){
            workerDAO.findWorkerDetailById(id).toDomainWorkerDetails()
        }

}