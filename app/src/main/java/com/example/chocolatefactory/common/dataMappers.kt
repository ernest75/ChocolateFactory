package com.example.chocolatefactory.common

import com.example.chocolatefactory.domain.OmpaWorker
import com.example.chocolatefactory.network.models.Favorite
import com.example.chocolatefactory.network.models.OompaLoompaWorker

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