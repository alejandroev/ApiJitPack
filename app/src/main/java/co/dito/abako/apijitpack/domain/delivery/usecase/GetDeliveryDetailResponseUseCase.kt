package co.dito.abako.apijitpack.domain.delivery.usecase

import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryDetailRequest
import co.dito.abako.apijitpack.data.model.response.delivery.DeliveryDetailResponse
import co.dito.abako.apijitpack.data.model.response.delivery.DeliveryResponse
import co.dito.abako.apijitpack.domain.BaseResult
import co.dito.abako.apijitpack.domain.delivery.DeliveryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDeliveryDetailResponseUseCase @Inject constructor(private val deliveryRepository: DeliveryRepository) {

    suspend operator fun invoke(
        url: String,
        deliveryDetailRequest: DeliveryDetailRequest
    ): Flow<BaseResult<DeliveryDetailResponse, WrappedResponse<DeliveryDetailResponse>>> =
        deliveryRepository.getDeliveryDetailResponse(url, deliveryDetailRequest)
}
