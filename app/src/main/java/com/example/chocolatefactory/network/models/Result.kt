package com.example.chocolatefactory.network.models

data class Result (

    val current : Int,
    val total : Int,
    val results : List<OompaLoompaWorker>
)