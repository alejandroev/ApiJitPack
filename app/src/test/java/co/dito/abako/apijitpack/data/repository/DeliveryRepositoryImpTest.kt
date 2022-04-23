package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryRequest
import co.dito.abako.apijitpack.data.model.response.general.JsonCompress
import co.dito.abako.apijitpack.data.network.DeliveryApiService
import co.dito.abako.apijitpack.domain.delivery.DeliveryRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import retrofit2.Response

@ExperimentalCoroutinesApi
class DeliveryRepositoryImpTest {

    private val deliveryApiServices: DeliveryApiService = mockk()

    private lateinit var deliveryRepository: DeliveryRepository

    @Before
    fun setup() {
        deliveryRepository = DeliveryRepositoryImp(deliveryApiServices)
    }

    @Test
    fun `when getDeliveryResponse is called return a BaseResultResponse`() = runTest {
        val deliveryResponse = mockk<Response<JsonCompress>>(relaxed = true)
        val deliveryRequest = mockk<DeliveryRequest>(relaxed = true)

        coEvery {
            deliveryApiServices.getDeliveryResponse(URL_FAKE, deliveryRequest)
        } answers {
            deliveryResponse
        }

        deliveryRepository.getDeliveryResponse(URL_FAKE, deliveryRequest)

        coVerify(exactly = 1) {
            deliveryApiServices.getDeliveryResponse(URL_FAKE, deliveryRequest)
        }
    }

    @Test
    fun getDeliveryDetailResponse() {
    }

    @Test
    fun getMasterDeliveryResponse() {
    }

    @Test
    fun getReasonReturnDeliveryResponse() {
    }
}

private const val URL_FAKE = "http:api.com.co"