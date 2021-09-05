package com.example.chocolatefactory.data.repository

import com.example.chocolatefactory.data.source.LocalDataSource
import com.example.chocolatefactory.data.source.RemoteDataSource
import com.example.chocolatefactory.utils.fakeDetailsOmpaWorker
import com.example.chocolatefactory.utils.fakeOmpaWorker
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.*

@RunWith(MockitoJUnitRunner::class)
class WorkersRepositoryTest {

    @Mock
    lateinit var remoteDataSource: RemoteDataSource

    @Mock
    lateinit var localDataSource: LocalDataSource

    lateinit var workersRepository: WorkersRepository

    @Before
    fun setup() {
        workersRepository = WorkersRepository(remoteDataSource,localDataSource)
    }

    @Test
    fun `repo gets correct list workers data from remote data source when local is empty`(){
        runBlocking {

            val remoteWorkers = listOf(fakeOmpaWorker.copy(id = 1))
            whenever(localDataSource.isEmpty()).thenReturn(true)
            whenever(localDataSource.getLocalWorkers()).thenReturn(remoteWorkers)

            val result = workersRepository.getOmpaWorkers()

            assertEquals(remoteWorkers,result)

        }
    }

    @Test
    fun `repo gets workers from local data source when db is not empty`(){
        runBlocking {
            whenever(localDataSource.isEmpty()).thenReturn(false)

            workersRepository.getOmpaWorkers()

            verify(remoteDataSource, never()).getWorkers();
        }

    }

    @Test
    fun `repo calls remote data source if db is empty`(){
        runBlocking {
            whenever(localDataSource.isEmpty()).thenReturn(true)

            workersRepository.getOmpaWorkers()

            verify(remoteDataSource, atLeastOnce()).getWorkers();
        }

    }

    @Test
    fun `getOmpaWorkers saves data in DB if it's empty`(){
        runBlocking {
            val remoteWorkers = listOf(fakeOmpaWorker.copy(id = 1))
            whenever(localDataSource.isEmpty()).thenReturn(true)
            whenever(remoteDataSource.getWorkers()).thenReturn(remoteWorkers)

            workersRepository.getOmpaWorkers()

            verify(localDataSource).saveWorkers(remoteWorkers)
        }

    }

    @Test
    fun `repo gets correct details worker from remote data source`(){
        runBlocking {

            val detailsWorkers = fakeDetailsOmpaWorker
            val workerId = -1
            whenever(remoteDataSource.getWorkersDetails(workerId)).thenReturn(detailsWorkers)

            val result = workersRepository.getOmpaDetails(workerId)

            assertEquals(detailsWorkers,result)
        }


    }
}