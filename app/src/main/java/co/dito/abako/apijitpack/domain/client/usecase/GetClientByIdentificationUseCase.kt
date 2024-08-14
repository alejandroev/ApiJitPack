package co.dito.abako.apijitpack.domain.client.usecase

import co.dito.abako.apijitpack.data.model.response.client.APIAbakoClientResponse
import co.dito.abako.apijitpack.domain.client.ClientRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetClientByIdentificationUseCase @Inject constructor(
    private val clientRepository: ClientRepository
) {

    suspend operator fun invoke(identification: String): Flow<APIAbakoClientResponse> =
        clientRepository.fetchClientResponse(identification = identification)
}