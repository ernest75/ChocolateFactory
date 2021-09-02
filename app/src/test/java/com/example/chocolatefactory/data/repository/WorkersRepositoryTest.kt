package com.example.chocolatefactory.data.repository

import com.example.chocolatefactory.data.source.RemoteDataSource
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
class WorkersRepositoryTest {

    @Mock
    lateinit var remoteDataSource: RemoteDataSource

    lateinit var workersRepository: WorkersRepository

    @Before
    fun setup() {
        workersRepository = WorkersRepository(remoteDataSource)
    }

    @Test
    fun `repo gets data from remote data source`(){
        runBlocking {

            val remoteWorkers = listOf(fakeOmpaWorker.copy(id = 1))
            whenever(remoteDataSource.getWorkers()).thenReturn(remoteWorkers)

            val result = workersRepository.getOmpaWorkers()

            assertEquals(remoteWorkers,result)

        }
    }
}