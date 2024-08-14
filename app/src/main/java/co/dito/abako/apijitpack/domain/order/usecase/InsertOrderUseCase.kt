package co.dito.abako.apijitpack.domain.order.usecase

import co.dito.abako.apijitpack.data.model.request.order.APIOrderRequest
import co.dito.abako.apijitpack.data.model.response.order.APIOrderResponse
import co.dito.abako.apijitpack.domain.order.OrderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InsertOrderUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) {

    suspend operator fun invoke(apiOrderRequest: APIOrderRequest) : Flow<APIOrderResponse> =
        orderRepository.insertOrder(apiOrderRequest)
}