package co.dito.abako.apijitpack.domain.delivery.usecase

import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.model.request.delivery.MasterDeliveryRequest
import co.dito.abako.apijitpack.data.model.response.delivery.MasterDeliveryResponse
import co.dito.abako.apijitpack.domain.BaseResult
import co.dito.abako.apijitpack.domain.delivery.DeliveryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMasterDeliveryResponse @Inject constructor(private val deliveryRepository: DeliveryRepository) {

    suspend operator fun invoke(
        url: String,
        masterDeliveryRequest: MasterDeliveryRequest
    ): Flow<BaseResult<MasterDeliveryResponse, WrappedResponse<MasterDeliveryResponse>>> =
        deliveryRepository.getMasterDeliveryResponse(url, masterDeliveryRequest)
}