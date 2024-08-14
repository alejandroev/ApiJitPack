package co.dito.abako.apijitpack.domain.client.usecase

import co.dito.abako.apijitpack.domain.client.ClientRepository
import co.dito.abako.apijitpack.domain.client.ClientState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ValidateClientStateUseCase @Inject constructor(
    private val clientRepository: ClientRepository
) {

    suspend operator fun invoke(clientId: Int) : Flow<ClientState> =
        clientRepository.validateClientState(clientId = clientId)
}