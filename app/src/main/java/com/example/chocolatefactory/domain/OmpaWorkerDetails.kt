package com.example.chocolatefactory.domain

import com.example.chocolatefactory.network.models.Favorite
import com.google.gson.annotations.SerializedName

class OmpaWorkerDetails(
    val lastName: String,
    val description: String,
    val image: String,
    val profession: String,
    val quota: String,
    val height: Long,
    val firstName: String,
    val country: String,
    val age: Long,
    val favorite: Favorite,
    val gender: String,
    val email: String
)