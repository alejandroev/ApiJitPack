package co.dito.abako.apijitpack.domain.delivery.usecase

import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryRequest
import co.dito.abako.apijitpack.data.model.response.delivery.DeliveryResponse
import co.dito.abako.apijitpack.domain.delivery.DeliveryRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetDeliveryResponseUseCase @Inject constructor(private val deliveryRepository: DeliveryRepository) {

    suspend operator fun invoke(deliveryRequest: DeliveryRequest): Flow<DeliveryResponse> =
        deliveryRepository.getDeliveryResponse(deliveryRequest)
}