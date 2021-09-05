package com.example.chocolatefactory.ui.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.chocolatefactory.ui.data.network.models.Favorite

@Entity
data class OmpaWorkerDetail (
    @PrimaryKey
    val workerId:Int,
    val lastName: String,
    val description: String,
    val image: String,
    val profession: String,
    val quota: String,
    val height: Long,
    val firstName: String,
    val country: String,
    val age: Long,
    val favorite: FavoriteLocal,
    val gender: String,
    val email: String
)