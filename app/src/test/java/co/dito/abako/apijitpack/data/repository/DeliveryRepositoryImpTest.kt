package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryRequest
import co.dito.abako.apijitpack.data.model.response.general.JsonCompress
import co.dito.abako.apijitpack.data.network.DeliveryApiService
import co.dito.abako.apijitpack.domain.delivery.DeliveryRepository
import dagger.hilt.android.testing.HiltAndroidRule
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response
import javax.inject.Inject

class DeliveryRepositoryImpTest {

    /*@Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var deliveryApiServices: DeliveryApiService

    private lateinit var deliveryRepository: DeliveryRepository

    @Before
    fun setup() {
        deliveryRepository = DeliveryRepositoryImp(deliveryApiServices)
    }

    @Test
    fun `when getDeliveryResponse is called return a BaseResultResponse`() {
        val deliveryResponse = mockk<Response<JsonCompress>>(relaxed = true)
        val deliveryRequest = mockk<DeliveryRequest>()

        coEvery {
            deliveryApiServices.getDeliveryResponse(URL_FAKE, deliveryRequest)
        } answers {
            deliveryResponse
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
    }*/
}

private const val URL_FAKE = "http:api.com.co"