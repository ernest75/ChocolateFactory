package com.example.chocolatefactory.common

import com.example.chocolatefactory.domain.OmpaWorker
import com.example.chocolatefactory.domain.OmpaWorkerDetails
import com.example.chocolatefactory.network.models.Favorite
import com.example.chocolatefactory.network.models.OompaLoompaWorker
import com.example.chocolatefactory.network.models.WorkerDetails

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