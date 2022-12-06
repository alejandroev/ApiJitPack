package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.model.request.offer.VirtualOfferRequest
import co.dito.abako.apijitpack.data.model.response.offer.VirtualOfferResponse
import co.dito.abako.apijitpack.data.network.OrderMobileApiService
import co.dito.abako.apijitpack.data.network.validResponse
import co.dito.abako.apijitpack.domain.order.OrderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OrderRepositoryImp @Inject constructor(
    private val orderMobileApiService: OrderMobileApiService
) : OrderRepository {

    override suspend fun virtualOfferValid(virtualOfferRequest: VirtualOfferRequest): Flow<VirtualOfferResponse> {
        val response = orderMobileApiService.virtualOfferValid(virtualOfferRequest)
        response.message.validResponse()

        return flow {
            emit(response)
        }
    }
}