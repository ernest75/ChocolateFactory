package com.example.chocolatefactory.network.models

import com.google.gson.annotations.SerializedName

data class Favorite (
    @SerializedName("color")
    val color : String,
    @SerializedName("food")
    val food : String,
    @SerializedName("random_string")
    val randomString : String,
    @SerializedName("song")
    val song : String
)