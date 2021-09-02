package com.example.chocolatefactory.usecases

import com.example.chocolatefactory.data.repository.WorkersRepository
import com.example.chocolatefactory.utils.fakeOmpaWorker
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetOmpaWorkersTest {

    @Mock
    lateinit var workersRepository: WorkersRepository

    lateinit var getOmpaWorkers: GetOmpaWorkers

    @Before
    fun setup() {
        getOmpaWorkers = GetOmpaWorkers(workersRepository)

    }

    @Test
    fun`use case uses repo`(){
        runBlocking {
            val workers = listOf(fakeOmpaWorker.copy(id = 1), fakeOmpaWorker.copy(id = 2))

            whenever(workersRepository.getOmpaWorkers()).thenReturn(workers)

            val result = getOmpaWorkers.invoke()

            assertEquals(workers,result)
        }
    }

}