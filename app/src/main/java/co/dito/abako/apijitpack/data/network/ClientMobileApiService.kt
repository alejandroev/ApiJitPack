package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.client.APICreateClientRequest
import co.dito.abako.apijitpack.data.model.request.client.APICreateClientV2Request
import co.dito.abako.apijitpack.data.model.response.client.APICreateClientResponse
import co.dito.abako.apijitpack.data.model.response.client.APICreateClientV2Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ClientMobileApiService {

    @POST("CrearCliente")
    suspend fun createClient(@Body clientRequest: APICreateClientRequest) : APICreateClientResponse

    @POST("CrearCliente/CrearClienteV2")
    suspend fun createClientV2(@Body clientRequest: APICreateClientV2Request) : APICreateClientV2Response
}