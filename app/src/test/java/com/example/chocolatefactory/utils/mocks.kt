package com.example.chocolatefactory.utils

import com.example.chocolatefactory.domain.OmpaWorker
import com.example.chocolatefactory.domain.OmpaWorkerDetails
import com.example.chocolatefactory.ui.data.network.models.Favorite

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

internal val fakeDetailsOmpaWorker = OmpaWorkerDetails(
    "testLastName",
    "testDescription",
    "testImage",
    "testProffesion",
    "testQuota",
    -12L,
    "testFirstName",
    "testCountry",
    -25L,
    fakeFavourite,
    "testGender",
    "testEmail"
)