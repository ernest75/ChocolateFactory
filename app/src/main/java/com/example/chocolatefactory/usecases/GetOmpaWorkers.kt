package com.example.chocolatefactory.usecases

import com.example.chocolatefactory.data.repository.WorkersRepository
import com.example.chocolatefactory.domain.OmpaWorker

class GetOmpaWorkers(private val workersRepository: WorkersRepository) {
    suspend fun invoke(): List<OmpaWorker> = workersRepository.getOmpaWorkers()
}