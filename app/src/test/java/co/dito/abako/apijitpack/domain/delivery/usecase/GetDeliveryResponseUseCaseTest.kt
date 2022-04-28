package co.dito.abako.apijitpack.domain.delivery.usecase

import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryRequest
import co.dito.abako.apijitpack.data.model.response.delivery.DeliveryResponse
import co.dito.abako.apijitpack.domain.BaseResult
import co.dito.abako.apijitpack.domain.delivery.DeliveryRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetDeliveryResponseUseCaseTest {

    private val deliveryRepository: DeliveryRepository = mockk(relaxed = true)
    private lateinit var getDeliveryResponseUseCase: GetDeliveryResponseUseCase

    @Before
    fun setUp() {
        getDeliveryResponseUseCase = GetDeliveryResponseUseCase(deliveryRepository)
    }

    @Test
    fun `given a request and URL when getDeliveryResponse is call then return response`() {
        val request = mockk<DeliveryRequest>()
        val responseUseCase =
            mockk<Flow<BaseResult<DeliveryResponse, WrappedResponse<DeliveryResponse>>>>()

        coEvery {
            deliveryRepository.getDeliveryResponse(URL_FAKE, request)
        } answers {
            responseUseCase
        }

        val responseRepository =
            runBlocking { getDeliveryResponseUseCase(URL_FAKE, request) }

        coVerify(exactly = 1) {
            deliveryRepository.getDeliveryResponse(URL_FAKE, request)
        }

        Assert.assertEquals(responseUseCase, responseRepository)
    }
}

private const val URL_FAKE = "http:api.com.co"