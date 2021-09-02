package com.example.chocolatefactory.network.models

import com.google.gson.annotations.SerializedName

data class OmpalompaWorkersListResult (
    val current : Int,
    val total : Int,
    val results : List<OompaLoompaWorker>
)