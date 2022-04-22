package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.common.utils.ZipUtils
import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryRequest
import co.dito.abako.apijitpack.data.model.response.delivery.DeliveryResponse
import co.dito.abako.apijitpack.data.network.DeliveryApiService
import co.dito.abako.apijitpack.domain.BaseResult
import co.dito.abako.apijitpack.domain.delivery.DeliveryRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DeliveryRepositoryImp @Inject constructor(private val deliveryApiService: DeliveryApiService) :
    DeliveryRepository {

    override suspend fun getDeliveryResponse(
        url: String,
        deliveryRequest: DeliveryRequest
    ): Flow<BaseResult<DeliveryResponse, WrappedResponse<DeliveryResponse>>> {
        return flow {
            val response = deliveryApiService.getDeliveryResponse(url, deliveryRequest)
            if (response.isSuccessful && response.body() != null) {
                val deliveryResponse = Gson().fromJson(
                    ZipUtils.decompress(response.body()!!.content),
                    DeliveryResponse::class.java
                )
                emit(BaseResult.Success(deliveryResponse))
            } else {
                val type = object : TypeToken<WrappedResponse<DeliveryResponse>>() {}.type
                val err: WrappedResponse<DeliveryResponse> =
                    Gson().fromJson(response.errorBody()!!.charStream(), type)
                err.code = response.code()
                emit(BaseResult.Error(err))
            }
        }
    }
}