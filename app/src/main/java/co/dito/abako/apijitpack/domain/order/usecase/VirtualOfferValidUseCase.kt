package co.dito.abako.apijitpack.domain.order.usecase

import co.dito.abako.apijitpack.data.model.request.offer.VirtualOfferRequest
import co.dito.abako.apijitpack.data.model.response.offer.VirtualOfferResponse
import co.dito.abako.apijitpack.domain.order.OrderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VirtualOfferValidUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) {

    suspend operator fun invoke(virtualOfferRequest: VirtualOfferRequest) : Flow<VirtualOfferResponse> =
        orderRepository.virtualOfferValid(virtualOfferRequest)
}