package com.example.chocolatefactory.usecases

import com.example.chocolatefactory.data.repository.WorkersRepository
import com.example.chocolatefactory.domain.OmpaWorker
import com.example.chocolatefactory.domain.OmpaWorkerDetails

class GetOmpaWorkerDetails(private val workersRepository: WorkersRepository) {
    suspend fun invoke(workerId: Int): OmpaWorkerDetails =
        workersRepository.getOmpaDetails(workerId)
}