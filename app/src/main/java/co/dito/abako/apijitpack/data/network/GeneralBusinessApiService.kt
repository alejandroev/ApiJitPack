package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.response.general.ExchangeRateSyncResponse
import retrofit2.http.GET

interface GeneralBusinessApiService {

    @GET("TasaCambio/GetTasaActual")
    suspend fun getExchangeRateSync(): ExchangeRateSyncResponse
}