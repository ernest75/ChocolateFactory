package com.example.chocolatefactory.usecases

import com.example.chocolatefactory.data.repository.OmpaRepository
import com.example.chocolatefactory.domain.OmpaWorker

class GetOmpaWorkers(private val ompaRepository: OmpaRepository) {
    suspend fun invoke(): List<OmpaWorker> = ompaRepository.getOmpaWorkers()
}