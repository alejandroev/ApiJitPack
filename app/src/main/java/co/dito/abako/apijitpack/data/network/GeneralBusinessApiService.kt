package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.general.GpsTourRequest
import co.dito.abako.apijitpack.data.model.response.delivery.GpsTourResponse
import co.dito.abako.apijitpack.data.model.response.general.ExchangeRateSyncResponse
import co.dito.abako.apijitpack.data.model.response.general.MasterIdResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface GeneralBusinessApiService {

    @GET("TasaCambio/GetTasaActual")
    suspend fun getExchangeRateSync(): ExchangeRateSyncResponse

    @GET("Maestros/GetIdMaestro/{type}/{master}")
    suspend fun fetchMasterId(
        @Path("type") type: String,
        @Path("master") master: String
    ): MasterIdResponse
}