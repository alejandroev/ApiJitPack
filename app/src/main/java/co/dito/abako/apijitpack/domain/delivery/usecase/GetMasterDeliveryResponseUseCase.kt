package co.dito.abako.apijitpack.domain.delivery.usecase

import co.dito.abako.apijitpack.data.model.request.delivery.MasterDeliveryRequest
import co.dito.abako.apijitpack.data.model.response.delivery.MasterDeliveryResponse
import co.dito.abako.apijitpack.domain.delivery.DeliveryRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetMasterDeliveryResponseUseCase @Inject constructor(private val deliveryRepository: DeliveryRepository) {

    suspend operator fun invoke(masterDeliveryRequest: MasterDeliveryRequest): Flow<MasterDeliveryResponse> =
        deliveryRepository.getMasterDeliveryResponse(masterDeliveryRequest)
}