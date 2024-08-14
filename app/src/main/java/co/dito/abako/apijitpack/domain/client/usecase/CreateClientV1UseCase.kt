package co.dito.abako.apijitpack.domain.client.usecase

import co.dito.abako.apijitpack.data.model.request.client.APICreateClientRequest
import co.dito.abako.apijitpack.data.model.response.client.APICreateClientResponse
import co.dito.abako.apijitpack.domain.client.ClientRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CreateClientV1UseCase @Inject constructor(
    private val clientRepository: ClientRepository
) {

    suspend operator fun invoke(clientRequest: APICreateClientRequest) : Flow<APICreateClientResponse> = clientRepository.createClientV1(clientRequest)
}