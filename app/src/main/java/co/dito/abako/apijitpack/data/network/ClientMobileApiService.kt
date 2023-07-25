package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.client.APICreateClientRequest
import co.dito.abako.apijitpack.data.model.response.client.APICreateClientResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ClientMobileApiService {

    @POST("CrearCliente")
    suspend fun createClient(@Body clientRequest: APICreateClientRequest) : APICreateClientResponse
}