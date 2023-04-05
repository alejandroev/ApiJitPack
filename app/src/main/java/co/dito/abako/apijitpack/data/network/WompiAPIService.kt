package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.wompi.WompiRequest
import co.dito.abako.apijitpack.data.model.response.wompi.WompiResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface WompiAPIService {

    @POST("Wompi")
    suspend fun getWompi(@Body wompiRequest: WompiRequest) : WompiResponse
}