package com.example.chocolatefactory.ui.data.network.models

import com.google.gson.annotations.SerializedName

data class Favorite (
    val color : String,
    val food : String,
    @SerializedName("random_string")
    val randomString : String,
    @SerializedName("song")
    val song : String
)