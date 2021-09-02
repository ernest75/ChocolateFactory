package com.example.chocolatefactory.domain

import com.example.chocolatefactory.network.models.Favorite

data class OmpaWorker(
    val firstName: String,
    val lastName: String,
    val favorite: Favorite,
    val gender: String,
    val image: String,
    val profession: String,
    val email: String,
    val age: Int,
    val country: String,
    val height: Int,
    val id: Int
)
