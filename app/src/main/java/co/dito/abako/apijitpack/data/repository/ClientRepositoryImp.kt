package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.common.utils.ApiAbakoException
import co.dito.abako.apijitpack.data.model.request.client.APICreateClientRequest
import co.dito.abako.apijitpack.data.model.request.client.APICreateClientV2Request
import co.dito.abako.apijitpack.data.model.request.client.SetAbakoClientRequest
import co.dito.abako.apijitpack.data.model.response.client.APIAbakoClientResponse
import co.dito.abako.apijitpack.data.model.response.client.APICreateClientResponse
import co.dito.abako.apijitpack.data.model.response.client.APICreateClientV2Response
import co.dito.abako.apijitpack.data.network.ClientAdministrationAPIService
import co.dito.abako.apijitpack.data.network.ClientBusinessApiService
import co.dito.abako.apijitpack.data.network.ClientMobileApiService
import co.dito.abako.apijitpack.data.network.validResponse
import co.dito.abako.apijitpack.domain.client.ClientRepository
import co.dito.abako.apijitpack.domain.client.ClientState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ClientRepositoryImp(
    private val clientBusinessApiService: ClientBusinessApiService,
    private val clientMobileApiService: ClientMobileApiService,
    private val clientAdministrationAPIService: ClientAdministrationAPIService
) : ClientRepository {

    override suspend fun verifyClientExist(identification: String): Flow<String> = flow {
        val responseBody = clientBusinessApiService.verifyClientExist(identification)
        if (!responseBody.isSuccessful || responseBody.body() == null) {
            throw ApiAbakoException("Error al validar datos del cliente")
        }
        emit(responseBody.body()!!.string())
    }

    override suspend fun fetchClientResponse(identification: String): Flow<APIAbakoClientResponse> =
        flow {
            val clientResponse = clientBusinessApiService.fetchClientResponse(identification)
            clientResponse.state.forEach {
                it.validResponse()
            }
            emit(clientResponse)
        }

    override suspend fun createClient(clientRequest: APICreateClientRequest): Flow<APICreateClientResponse> =
        flow {
            val response = clientMobileApiService.createClient(clientRequest = clientRequest)
            response.states.forEach {
                it.validResponse()
            }
            emit(response)
        }

    override suspend fun createClientV2(clientRequest: APICreateClientV2Request): Flow<APICreateClientV2Response> =
        flow {
            val response =
                clientAdministrationAPIService.createClientV2(clientRequest = clientRequest)
            response.message.validResponse()
            emit(response)
        }

    override suspend fun createClientV1(clientRequest: APICreateClientRequest): Flow<APICreateClientResponse> =
        flow {
            val response =
                clientAdministrationAPIService.createClientV1(clientRequest = clientRequest)
            response.states.forEach {
                it.validResponse()
            }
            emit(response)
        }

    override suspend fun validateClientState(clientId: Int): Flow<ClientState> = flow {
        val response = clientAdministrationAPIService.validateClientState(clientId)
        emit(
            when(response.active) {
                "1" -> ClientState.PENDING
                "2" -> ClientState.APPROVED
                else -> ClientState.DENIED
            }
        )
    }

    override suspend fun setAbakoClient(setAbakoClientRequest: SetAbakoClientRequest): Flow<Boolean> = flow {
        val response = clientMobileApiService.setAbakoClient(setAbakoClientRequest = setAbakoClientRequest)
        response.validResponse()

        emit(response.msgId == 1)
    }
}