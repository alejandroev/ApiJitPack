package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.client.APICreateClientRequest
import co.dito.abako.apijitpack.data.model.request.client.APICreateClientV2Request
import co.dito.abako.apijitpack.data.model.response.client.APICreateClientResponse
import co.dito.abako.apijitpack.data.model.response.client.APICreateClientV2Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ClientAdministrationAPIService {

    @POST("Cliente/CrearClienteV2")
    suspend fun createClientV2(@Body clientRequest: APICreateClientV2Request) : APICreateClientV2Response

    @POST("Cliente/CrearEditarClienteV1")
    suspend fun createClientV1(@Body clientRequest: APICreateClientRequest) : APICreateClientResponse
}