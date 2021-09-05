package com.example.chocolatefactory.ui.data.network

import com.example.chocolatefactory.domain.OmpaWorkerDetails
import com.example.chocolatefactory.ui.data.network.models.OmpalompaWorkersListResult
import com.example.chocolatefactory.ui.data.network.models.WorkerDetails
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {

    @GET("?page=1")
    suspend fun listOmpaWorkersAsync(
    ): OmpalompaWorkersListResult

    @GET("{Id}")
    suspend fun ompaWorkerDetailsAsync(
        @Path("Id") customerId: Int
    ): WorkerDetails
}