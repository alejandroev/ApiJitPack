package co.dito.abako.apijitpack.domain.order.usecase

import co.dito.abako.apijitpack.data.model.request.order.FollowUpOrderRequest
import co.dito.abako.apijitpack.data.model.response.order.FollowUpOrderResponse
import co.dito.abako.apijitpack.domain.order.OrderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FollowUpOrderUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) {

    suspend operator fun invoke(orderId: Int, orderConsecutive: Int, email: String): Flow<List<FollowUpOrderResponse>> =
        orderRepository.followUp(
            FollowUpOrderRequest(
                orderId = orderId,
                orderConsecutive = orderConsecutive,
                email = email
            )
        )
}