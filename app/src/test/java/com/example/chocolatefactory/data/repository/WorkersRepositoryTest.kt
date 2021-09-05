package com.example.chocolatefactory.data.repository

import com.example.chocolatefactory.data.source.LocalDataSource
import com.example.chocolatefactory.data.source.RemoteDataSource
import com.example.chocolatefactory.utils.fakeDetailsOmpaWorker
import com.example.chocolatefactory.utils.fakeOmpaWorker
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.atLeastOnce
import org.mockito.kotlin.never
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

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
    fun `repo gets workers data from remote data source when local is empty`(){
        runBlocking {
            whenever(localDataSource.isEmpty()).thenReturn(true)

            workersRepository.getOmpaWorkers()

            verify(remoteDataSource, atLeastOnce()).getWorkers()

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
    fun `repo saves workers to Db  when db is empty`(){
        runBlocking {
            val remoteWorkers = listOf(fakeOmpaWorker.copy(id = 1))
            whenever(localDataSource.isEmpty()).thenReturn(true)
            whenever(remoteDataSource.getWorkers()).thenReturn(remoteWorkers)

            workersRepository.getOmpaWorkers()

            verify(localDataSource, atLeastOnce()).saveWorkers(remoteWorkers);
        }

    }

    @Test
    fun `repo gets workersDetails data from remote data source when local is empty`() {
        runBlocking {
            val workerId = 1
            whenever(localDataSource.finWorkersDetailsByIdIdEmpty(workerId)).thenReturn(true)

            workersRepository.getOmpaDetails(workerId)

            verify(remoteDataSource, atLeastOnce()).getWorkersDetails(workerId)
        }
    }

    @Test
    fun `repo gets workersDetails from local data source when db is not empty`() {
        runBlocking {
            val workerId = 1
            whenever(localDataSource.finWorkersDetailsByIdIdEmpty(workerId))
                .thenReturn(false)

            workersRepository.getOmpaDetails(workerId)

            verify(remoteDataSource, never()).getWorkersDetails(workerId)
        }
    }

    @Test
    fun `repo saves workersDetails to Db  when db is empty`(){
        runBlocking {
            val remoteWorkerDetail = fakeDetailsOmpaWorker
            val workerId = 1
            whenever(localDataSource.finWorkersDetailsByIdIdEmpty(workerId))
                .thenReturn(true)
            whenever(remoteDataSource.getWorkersDetails(workerId))
                .thenReturn(remoteWorkerDetail)

            workersRepository.getOmpaDetails(workerId)

            verify(localDataSource, atLeastOnce()).saveWorkersDetails(workerId, remoteWorkerDetail);
        }

    }

}
