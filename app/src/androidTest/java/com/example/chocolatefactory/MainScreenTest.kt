package com.example.chocolatefactory

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.rule.GrantPermissionRule
import com.example.chocolatefactory.network.RetrofitClass
import com.example.chocolatefactory.ui.main.MainActivity
import com.example.chocolatefactory.utils.MockWebServerRule
import com.example.chocolatefactory.utils.fromJson
import com.jakewharton.espresso.OkHttp3IdlingResource
import okhttp3.mockwebserver.MockResponse
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.koin.test.KoinTest
import org.koin.test.get

class MainScreenTest : KoinTest {

    private val mockWebServerRule = MockWebServerRule()

    val resource = OkHttp3IdlingResource.create("OkHttp", get<RetrofitClass>().okHttpClient)


    @get:Rule
    val testRule: RuleChain = RuleChain
        .outerRule(mockWebServerRule)
        .around(ActivityScenarioRule(MainActivity::class.java))

    @Before
    fun setUp() {
        mockWebServerRule.server.enqueue(
            MockResponse().fromJson("workersList.json")
        )

        IdlingRegistry.getInstance().register(resource)
    }

    @Test
    fun recyclerIsPopulatedWithCorrectData(){
        Espresso.onView(withId(R.id.rv_main))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
            .check(ViewAssertions.matches(ViewMatchers.hasDescendant(ViewMatchers.withText("Marcy"))))
    }

}