package com.example.chocolatefactory.ui.detail

import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.chocolatefactory.R
import com.example.chocolatefactory.ui.data.network.RetrofitClass
import com.example.chocolatefactory.utils.MockWebServerRule
import com.example.chocolatefactory.utils.fromJson
import com.jakewharton.espresso.OkHttp3IdlingResource
import okhttp3.mockwebserver.MockResponse
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.koin.test.KoinTest
import org.koin.test.get

class DetailScreenTest : KoinTest {

    private val mockWebServerRule = MockWebServerRule()

    private val actRule = ActivityScenarioRule(DetailActivity::class.java)

    @get:Rule
    val testRule: RuleChain = RuleChain
        .outerRule(mockWebServerRule)
        .around(actRule)

    @Before
    fun setUp() {
        val resource = OkHttp3IdlingResource.create("OkHttp", get<RetrofitClass>().okHttpClient)
        mockWebServerRule.server.enqueue(
            MockResponse().fromJson("workersDetails.json")
        )

        IdlingRegistry.getInstance().register(resource)
    }

    @Test
    fun viewIsPopulatedWithCorrectData() {
        val workerLastName = "Karadzas"
        Espresso.onView(ViewMatchers.withId(R.id.cv_workerDetails))
            .check(
                ViewAssertions.matches(
                    ViewMatchers.withSubstring(workerLastName)
                )
            )
    }

}