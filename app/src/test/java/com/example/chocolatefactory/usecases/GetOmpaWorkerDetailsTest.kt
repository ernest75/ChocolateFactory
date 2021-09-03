package com.example.chocolatefactory.usecases

import com.example.chocolatefactory.data.repository.WorkersRepository
import com.example.chocolatefactory.utils.fakeDetailsOmpaWorker
import com.example.chocolatefactory.utils.fakeOmpaWorker
import junit.framework.Assert
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetOmpaWorkerDetailsTest {

    @Mock
    lateinit var workersRepository: WorkersRepository

    lateinit var getOmpaWorkerDetails: GetOmpaWorkerDetails

    @Before
    fun setup() {
        getOmpaWorkerDetails = GetOmpaWorkerDetails(workersRepository)

    }

    @Test
    fun`getOmpaWorkerDetails use case returns correct data`(){
        runBlocking {
            val workerDetalis = fakeDetailsOmpaWorker
            val idWorker = -1

            whenever(workersRepository.getOmpaDetails(idWorker)).thenReturn(workerDetalis)

            val result = getOmpaWorkerDetails.invoke(idWorker)

            Assert.assertEquals(workerDetalis,result)
        }
    }


}