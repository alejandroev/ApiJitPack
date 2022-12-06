package co.dito.abako.apijitpack.domain.order

import co.dito.abako.apijitpack.data.model.request.offer.VirtualOfferRequest
import co.dito.abako.apijitpack.data.model.response.offer.VirtualOfferResponse
import kotlinx.coroutines.flow.Flow

interface OrderRepository {

    suspend fun virtualOfferValid(virtualOfferRequest: VirtualOfferRequest): Flow<VirtualOfferResponse>
}