package com.example.chocolatefactory.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.chocolatefactory.ui.detail.DetailViewModel
import com.example.chocolatefactory.usecases.GetOmpaWorkerDetails
import com.example.chocolatefactory.utils.fakeDetailsOmpaWorker
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
class DetailViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var getOmpaWorkerDetails: GetOmpaWorkerDetails

    @Mock
    lateinit var observer: Observer<Any>

    private lateinit var vm: DetailViewModel

    private val workerId = -1

    @Before
    fun setup() {
        vm = DetailViewModel(workerId,getOmpaWorkerDetails, Dispatchers.Unconfined)
    }

    @Test
    fun `onCreate correct data is returned`() {
        runBlocking {
            val workerDetails = fakeDetailsOmpaWorker
            whenever(getOmpaWorkerDetails.invoke(workerId)).thenReturn(workerDetails)
            vm.model.observeForever(observer)
            verify(observer).onChanged(DetailViewModel.UiModel.Content(workerDetails))
        }
    }
}