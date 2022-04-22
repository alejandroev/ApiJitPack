package co.dito.abako.apijitpack.domain.delivery

import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryRequest
import co.dito.abako.apijitpack.data.model.response.delivery.DeliveryResponse
import co.dito.abako.apijitpack.domain.BaseResult
import kotlinx.coroutines.flow.Flow

interface DeliveryRepository {

    suspend fun getDeliveryResponse(
        url: String,
        deliveryRequest: DeliveryRequest
    ): Flow<BaseResult<DeliveryResponse, WrappedResponse<DeliveryResponse>>>
}