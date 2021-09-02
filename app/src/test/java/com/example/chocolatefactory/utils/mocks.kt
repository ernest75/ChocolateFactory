package com.example.chocolatefactory.utils

import com.example.chocolatefactory.domain.OmpaWorker
import com.example.chocolatefactory.network.models.Favorite

internal val fakeFavourite = Favorite(
    "testColor",
    "testFood",
    "testRandomString",
    "testSong"
)
internal val fakeOmpaWorker = OmpaWorker(
    "testName",
    "testLastName",
    fakeFavourite,
    "testGender",
    "testImage",
    "testProfession",
    "testEmail",
    100,
    "testCountry",
    10,
    0
)