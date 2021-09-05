package com.example.chocolatefactory.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
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

class MainScreenTest : KoinTest {

    private val mockWebServerRule = MockWebServerRule()

    @get:Rule
    val testRule:RuleChain  = RuleChain
        .outerRule(mockWebServerRule)
        .around(ActivityScenarioRule(MainActivity::class.java))

    @Before
    fun setUp() {

        val resource = OkHttp3IdlingResource.create("OkHttp", get<RetrofitClass>().okHttpClient)
        mockWebServerRule.server.enqueue(
            MockResponse().fromJson("workersList.json")
        )

        IdlingRegistry.getInstance().register(resource)
    }

    @Test
    fun recyclerIsPopulatedWithCorrectData(){
        val firstPositionName = "Marcy Karadzas"
        Espresso.onView(withId(R.id.rv_main))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))

            .check(ViewAssertions.matches(
                ViewMatchers.hasDescendant(ViewMatchers.withText(firstPositionName)))
            )
    }

    @Test
    fun clickAWorkerNavigatesToDetail() {
        Espresso.onView(withId(R.id.rv_main))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )

        Espresso.onView(withId(R.id.cl_data))
            .check(ViewAssertions.matches(ViewMatchers
                .hasDescendant(withId(R.id.iv_worker_detail))))

    }

    @Test
    fun clickBackArrowDetailNavigatesToMain() {
        Espresso.onView(withId(R.id.rv_main))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    ViewActions.click()
                )
            )

        Espresso.onView(withId(R.id.cl_data))
            .check(
                ViewAssertions.matches(
                    ViewMatchers
                        .hasDescendant(withId(R.id.iv_worker_detail))
                )
            )
        Espresso.pressBack()
        Espresso.onView(withId(R.id.rv_main))
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )

    }

}