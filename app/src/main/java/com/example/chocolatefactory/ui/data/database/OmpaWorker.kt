package com.example.chocolatefactory.ui.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson

@Entity
data class OmpaWorker(
    val firstName: String,
    val lastName: String,
    val favorite: FavoriteLocal,
    val gender: String,
    val image: String,
    val profession: String,
    val email: String,
    val age: Int,
    val country: String,
    val height: Int,
    @PrimaryKey val id: Int
)


class FavoriteTypeConverter {

    @TypeConverter
    fun favoriteToJson(value: FavoriteLocal) = Gson().toJson(value)

    @TypeConverter
    fun jsonToFavorite(value: String) = Gson().fromJson(value, FavoriteLocal::class.java)
}