package com.example.chocolatefactory.usecases

import com.example.chocolatefactory.data.repository.OmpaRepository
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
    lateinit var ompaRepository: OmpaRepository

    lateinit var getOmpaWorkers: GetOmpaWorkers

    @Before
    fun setup() {
        getOmpaWorkers = GetOmpaWorkers(ompaRepository)

    }

    @Test
    fun`use case uses repo`(){
        runBlocking {
            val workers = listOf(fakeOmpaWorker.copy(id = 1), fakeOmpaWorker.copy(id = 2))

            whenever(ompaRepository.getOmpaWorkers()).thenReturn(workers)

            val result = getOmpaWorkers.invoke()

            assertEquals(workers,result)
        }
    }

}