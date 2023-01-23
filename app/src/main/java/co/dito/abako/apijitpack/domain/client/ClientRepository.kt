package co.dito.abako.apijitpack.domain.client

import co.dito.abako.apijitpack.data.model.request.client.APICreateClientRequest
import co.dito.abako.apijitpack.data.model.request.client.APICreateClientV2Request
import co.dito.abako.apijitpack.data.model.response.client.APIAbakoClientResponse
import co.dito.abako.apijitpack.data.model.response.client.APICreateClientResponse
import co.dito.abako.apijitpack.data.model.response.client.APICreateClientV2Response
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body

interface ClientRepository {

    suspend fun verifyClientExist(identification: String): Flow<String>

    suspend fun fetchClientResponse(identification: String): Flow<APIAbakoClientResponse>

    suspend fun createClient(@Body clientRequest: APICreateClientRequest): Flow<APICreateClientResponse>

    suspend fun createClientV2(@Body clientRequest: APICreateClientV2Request): Flow<APICreateClientV2Response>
}