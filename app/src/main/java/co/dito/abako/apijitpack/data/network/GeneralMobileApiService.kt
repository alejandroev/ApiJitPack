package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.general.GpsTourRequest
import co.dito.abako.apijitpack.data.model.request.general.UserRequest
import co.dito.abako.apijitpack.data.model.response.delivery.GpsTourResponse
import co.dito.abako.apijitpack.data.model.response.general.UserResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface GeneralMobileApiService {

    @POST("Usuario")
    suspend fun loginUser(@Body userRequest: UserRequest): UserResponse

    @POST("Geo/SetRecorridoGPS")
    suspend fun gpsTourResponse(@Body gpsTourRequest: GpsTourRequest): GpsTourResponse
}