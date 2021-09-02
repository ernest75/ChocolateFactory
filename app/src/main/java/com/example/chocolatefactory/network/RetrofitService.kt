package com.example.chocolatefactory.network

import com.example.chocolatefactory.network.models.OmpalompaWorkersListResult
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("?page=1")
    suspend fun listOmpaWorkersAsync(
    ): OmpalompaWorkersListResult
}