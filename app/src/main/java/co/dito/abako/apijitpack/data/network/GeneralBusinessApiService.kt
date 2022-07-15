package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.general.GpsTourRequest
import co.dito.abako.apijitpack.data.model.response.delivery.GpsTourResponse
import co.dito.abako.apijitpack.data.model.response.general.ExchangeRateSyncResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface GeneralBusinessApiService {

    @GET("TasaCambio/GetTasaActual")
    suspend fun getExchangeRateSync(): ExchangeRateSyncResponse
}