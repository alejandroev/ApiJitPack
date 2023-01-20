package co.dito.abako.apijitpack.domain.client

import co.dito.abako.apijitpack.data.model.response.client.APIAbakoClientResponse
import kotlinx.coroutines.flow.Flow

interface ClientRepository {

    suspend fun verifyClientExist(identification: String): Flow<String>

    suspend fun fetchClientResponse(identification: String): Flow<APIAbakoClientResponse>
}