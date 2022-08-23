package co.dito.abako.apijitpack.domain.delivery.usecase

import co.dito.abako.apijitpack.data.model.request.delivery.SettlementDeliveryRequest
import co.dito.abako.apijitpack.data.model.response.delivery.SettlementDeliveryResponse
import co.dito.abako.apijitpack.domain.delivery.DeliveryRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class InsertSettlementOtherChangeRequestUseCase @Inject constructor(private val deliveryRepository: DeliveryRepository) {

    suspend operator fun invoke(setSettlementDeliveryRequest: SettlementDeliveryRequest): Flow<SettlementDeliveryResponse> =
        deliveryRepository.setSettlementDeliveryRequest(setSettlementDeliveryRequest)
}