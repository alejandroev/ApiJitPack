package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.firebase.LoginBusinessRequest
import co.dito.abako.apijitpack.data.model.request.support.SupportRequest
import co.dito.abako.apijitpack.data.model.response.firebase.LoginBusinessResponse
import co.dito.abako.apijitpack.data.model.response.support.SupportResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface FirebaseApiService {

    @POST("notificationsEvents")
    suspend fun supportCodi(@Body supportRequest: SupportRequest): SupportResponse

    @POST("get_config_cliente")
    suspend fun loginBusiness(@Body loginBusinessRequest: LoginBusinessRequest): LoginBusinessResponse
}