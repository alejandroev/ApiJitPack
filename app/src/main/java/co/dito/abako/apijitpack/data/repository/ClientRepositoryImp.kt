package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.common.utils.ApiAbakoException
import co.dito.abako.apijitpack.data.model.response.client.APIAbakoClientResponse
import co.dito.abako.apijitpack.data.network.ClientApiService
import co.dito.abako.apijitpack.data.network.validResponse
import co.dito.abako.apijitpack.domain.client.ClientRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ClientRepositoryImp @Inject constructor(
    private val clientApiService: ClientApiService
) : ClientRepository {

    override suspend fun verifyClientExist(identification: String): Flow<String> = flow {
        val responseBody = clientApiService.verifyClientExist(identification)
        if (!responseBody.isSuccessful || responseBody.body() == null) {
            throw ApiAbakoException("Error al validar datos del cliente")
        }
        emit(responseBody.body()!!.string())
    }

    override suspend fun fetchClientResponse(identification: String): Flow<APIAbakoClientResponse> = flow {
        val clientResponse = clientApiService.fetchClientResponse(identification)
        clientResponse.state.forEach {
            it.validResponse()
        }
        emit(clientResponse)
    }
}