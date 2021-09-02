package com.example.chocolatefactory.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.chocolatefactory.domain.OmpaWorker
import com.example.chocolatefactory.network.models.Favorite
import com.example.chocolatefactory.ui.main.MainViewModel
import com.example.chocolatefactory.usecases.GetOmpaWorkers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var getOmpaWorkers: GetOmpaWorkers

    @Mock
    lateinit var observer: Observer<Any>

    private lateinit var vm: MainViewModel

    private val fakeFavourite = Favorite(
        "testColor",
        "testFood",
        "testRandomString",
        "testSong"
    )
    private val fakeOmpaWorker = OmpaWorker(
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

    @Before
    fun setup() {
        vm = MainViewModel(getOmpaWorkers, Dispatchers.Unconfined)

    }
    
  @Test
  fun `on started petition is done`() {
    runBlocking {
        val listWorkers = listOf(fakeOmpaWorker.copy(id = 1))
        whenever(getOmpaWorkers.invoke()).thenReturn(listWorkers)
        vm.model.observeForever(observer)
        verify(observer).onChanged(MainViewModel.UiModel.Content(listWorkers))
    }
  }
}