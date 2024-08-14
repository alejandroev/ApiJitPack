package co.dito.abako.apijitpack.domain.delivery.usecase

import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryDetailRequest
import co.dito.abako.apijitpack.data.model.response.delivery.DeliveryDetailResponse
import co.dito.abako.apijitpack.domain.delivery.DeliveryRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetDeliveryDetailResponseUseCase @Inject constructor(private val deliveryRepository: DeliveryRepository) {

    suspend operator fun invoke(deliveryDetailRequest: DeliveryDetailRequest): Flow<DeliveryDetailResponse> =
        deliveryRepository.getDeliveryDetailResponse(deliveryDetailRequest)
}
