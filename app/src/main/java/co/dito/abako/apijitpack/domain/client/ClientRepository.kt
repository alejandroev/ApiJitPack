package co.dito.abako.apijitpack.domain.client

import co.dito.abako.apijitpack.data.model.request.client.APICreateClientRequest
import co.dito.abako.apijitpack.data.model.request.client.APICreateClientV2Request
import co.dito.abako.apijitpack.data.model.request.client.SetAbakoClientRequest
import co.dito.abako.apijitpack.data.model.response.CargarImagenesModelResponse
import co.dito.abako.apijitpack.data.model.response.ImagenesRequest
import co.dito.abako.apijitpack.data.model.response.client.APIAbakoClientResponse
import co.dito.abako.apijitpack.data.model.response.client.APICreateClientResponse
import co.dito.abako.apijitpack.data.model.response.client.APICreateClientV2Response
import kotlinx.coroutines.flow.Flow

interface ClientRepository {
    suspend fun fetchImagen(identification: ImagenesRequest): Flow<CargarImagenesModelResponse>
    suspend fun verifyClientExist(identification: String): Flow<String>

    suspend fun fetchClientResponse(identification: String): Flow<APIAbakoClientResponse>

    suspend fun createClient(clientRequest: APICreateClientRequest): Flow<APICreateClientResponse>

    suspend fun createClientV2(clientRequest: APICreateClientV2Request): Flow<APICreateClientV2Response>

    suspend fun createClientV1(clientRequest: APICreateClientRequest): Flow<APICreateClientResponse>

    suspend fun validateClientState(clientId: Int) : Flow<ClientState>

    suspend fun setAbakoClient(setAbakoClientRequest: SetAbakoClientRequest) : Flow<Boolean>
}

enum class ClientState {
    PENDING,
    APPROVED,
    DENIED
}