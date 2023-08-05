package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.client.APICreateClientRequest
import co.dito.abako.apijitpack.data.model.request.client.SetAbakoClientRequest
import co.dito.abako.apijitpack.data.model.response.client.APICreateClientResponse
import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ClientMobileApiService {

    @POST("CrearCliente")
    suspend fun createClient(@Body clientRequest: APICreateClientRequest) : APICreateClientResponse

    @POST("Clientes/SetAbakoCliente")
    suspend fun setAbakoClient(@Body setAbakoClientRequest: SetAbakoClientRequest) : MessageResponse
}