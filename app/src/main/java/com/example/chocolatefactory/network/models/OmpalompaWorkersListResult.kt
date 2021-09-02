package com.example.chocolatefactory.network.models

import com.google.gson.annotations.SerializedName

data class OmpalompaWorkersListResult (
    @SerializedName("current")
    val current : Int,
    @SerializedName("total")
    val total : Int,
    @SerializedName("results")
    val results : List<OompaLoompaWorker>
)