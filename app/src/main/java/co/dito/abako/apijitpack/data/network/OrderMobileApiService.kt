package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.offer.VirtualOfferRequest
import co.dito.abako.apijitpack.data.model.response.offer.VirtualOfferResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface OrderMobileApiService {

    @POST("OfertasVirtuales/ValidarOferta")
    suspend fun virtualOfferValid(@Body virtualOfferRequest: VirtualOfferRequest): VirtualOfferResponse
}