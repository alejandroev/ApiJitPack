package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.general.UserRequest
import co.dito.abako.apijitpack.data.model.response.general.ExchangeRateSyncResponse
import co.dito.abako.apijitpack.data.model.response.general.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface GeneralApiService {

    @POST("Usuario")
    suspend fun loginUser(@Body userRequest: UserRequest): UserResponse

    @GET
    suspend fun ping(@Url url: String): Response<String?>

    @GET("TasaCambio/GetTasaActual")
    suspend fun getExchangeRateSync(): Response<ExchangeRateSyncResponse>
}