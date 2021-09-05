package com.example.chocolatefactory.common

import com.example.chocolatefactory.domain.OmpaWorker
import com.example.chocolatefactory.domain.OmpaWorkerDetails
import com.example.chocolatefactory.ui.data.database.FavoriteLocal
import com.example.chocolatefactory.ui.data.database.OmpaWorkerDetail
import com.example.chocolatefactory.ui.data.network.models.Favorite
import com.example.chocolatefactory.ui.data.network.models.OompaLoompaWorker
import com.example.chocolatefactory.ui.data.network.models.WorkerDetails
import com.example.chocolatefactory.ui.data.database.OmpaWorker as OmpaWorkerLocal


fun OompaLoompaWorker.toDomainWorker(): OmpaWorker =
    OmpaWorker(
        firstName,
        lastName,
        favorite,
        gender,
        image,
        profession,
        email,
        age,
        country,
        height,
        id
    )

fun WorkerDetails.toDomainWorkerDetails(): OmpaWorkerDetails =
    OmpaWorkerDetails(
        lastName,
        description,
        image,
        profession,
        quota,
        height,
        firstName,
        country,
        age,
        favorite,
        gender,
        email
    )

fun OmpaWorker.toRoomWorker(): OmpaWorkerLocal =
    OmpaWorkerLocal(
        firstName,
        lastName,
        favorite = FavoriteLocal(
            color = favorite.color,
            food = favorite.food,
            randomString = favorite.randomString,
            song = favorite.song
        ),
        gender,
        image,
        profession,
        email,
        age,
        country,
        height,
        id
    )

fun OmpaWorkerLocal.toDomainWorker(): OmpaWorker =
    OmpaWorker(
        firstName,
        lastName,
        favorite = Favorite(
            color = favorite.color,
            food = favorite.food,
            randomString = favorite.randomString,
            song = favorite.song
        ),
        gender,
        image,
        profession,
        email,
        age,
        country,
        height,
        id
    )

fun OmpaWorkerDetail.toDomainWorkerDetails(): OmpaWorkerDetails =
    OmpaWorkerDetails(
        lastName,
        description,
        image,
        profession,
        quota,
        height,
        firstName,
        country,
        age,
        favorite = Favorite(
            color = favorite.color,
            food = favorite.food,
            randomString = favorite.randomString,
            song = favorite.song
        ),
        gender,
        email
    )

fun OmpaWorkerDetails.toRoomWorkerDetails(workerId: Int): OmpaWorkerDetail =
    OmpaWorkerDetail(
        workerId = workerId,
        lastName,
        description,
        image,
        profession,
        quota,
        height,
        firstName,
        country,
        age,
        favorite = FavoriteLocal(
            color = favorite.color,
            food = favorite.food,
            randomString = favorite.randomString,
            song = favorite.song
        ),
        gender,
        email
    )