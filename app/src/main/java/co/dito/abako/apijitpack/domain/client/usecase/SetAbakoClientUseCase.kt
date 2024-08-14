package co.dito.abako.apijitpack.domain.client.usecase

import co.dito.abako.apijitpack.data.model.request.client.SetAbakoClientRequest
import co.dito.abako.apijitpack.domain.client.ClientRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SetAbakoClientUseCase @Inject constructor(
    private val clientRepository: ClientRepository
) {

    suspend operator fun invoke(
        companyId: Int,
        isCreatedByAbakoClient: Boolean = true
    ): Flow<Boolean> =
        clientRepository.setAbakoClient(
            SetAbakoClientRequest(
                companyId = companyId,
                isCreatedByAbakoClient = isCreatedByAbakoClient
            )
        )
}