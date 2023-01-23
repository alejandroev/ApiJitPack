package co.dito.abako.apijitpack.domain.client.usecase

import co.dito.abako.apijitpack.data.model.request.client.APICreateClientV2Request
import co.dito.abako.apijitpack.data.model.response.client.APICreateClientV2Response
import co.dito.abako.apijitpack.domain.client.ClientRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CreateClientV2UseCase @Inject constructor(
    private val clientRepository: ClientRepository
) {

    suspend operator fun invoke(clientRequest: APICreateClientV2Request): Flow<APICreateClientV2Response> =
        clientRepository.createClientV2(clientRequest)
}