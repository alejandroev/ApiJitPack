package co.dito.abako.apijitpack.domain.delivery.usecase

import co.dito.abako.apijitpack.data.model.request.delivery.ReasonReturnDeliveryRequest
import co.dito.abako.apijitpack.data.model.response.delivery.ReasonReturnDeliveryResponse
import co.dito.abako.apijitpack.domain.delivery.DeliveryRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetReasonReturnDeliveryResponseUseCase @Inject constructor(private val deliveryRepository: DeliveryRepository) {

    suspend operator fun invoke(reasonReturnDeliveryRequest: ReasonReturnDeliveryRequest): Flow<ReasonReturnDeliveryResponse> =
        deliveryRepository.getReasonReturnDeliveryResponse(reasonReturnDeliveryRequest)
}