package co.dito.abako.apijitpack.domain.delivery.usecase

import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.model.request.delivery.ReasonReturnDeliveryRequest
import co.dito.abako.apijitpack.data.model.response.delivery.ReasonReturnDeliveryResponse
import co.dito.abako.apijitpack.domain.BaseResult
import co.dito.abako.apijitpack.domain.delivery.DeliveryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetReasonReturnDeliveryResponse @Inject constructor(private val deliveryRepository: DeliveryRepository) {

    suspend operator fun invoke(
        url: String,
        reasonReturnDeliveryRequest: ReasonReturnDeliveryRequest
    ): Flow<BaseResult<ReasonReturnDeliveryResponse, WrappedResponse<ReasonReturnDeliveryResponse>>> =
        deliveryRepository.getReasonReturnDeliveryResponse(url, reasonReturnDeliveryRequest)
}