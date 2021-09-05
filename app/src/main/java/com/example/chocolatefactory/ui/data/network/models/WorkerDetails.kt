package com.example.chocolatefactory.ui.data.network.models

import com.google.gson.annotations.SerializedName

data class WorkerDetails(

    @SerializedName("last_name")
    val lastName: String,
    val description: String,
    val image: String,
    val profession: String,
    val quota: String,
    val height: Long,
    @SerializedName("first_name")
    val firstName: String,
    val country: String,
    val age: Long,
    val favorite: Favorite,
    val gender: String,
    val email: String
)