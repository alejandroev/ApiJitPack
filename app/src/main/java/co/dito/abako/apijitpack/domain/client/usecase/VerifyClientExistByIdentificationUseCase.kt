package co.dito.abako.apijitpack.domain.client.usecase

import co.dito.abako.apijitpack.domain.client.ClientRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VerifyClientExistByIdentificationUseCase @Inject constructor(
    private val repository: ClientRepository
) {

    suspend operator fun invoke(identification: String): Flow<String> = repository.verifyClientExist(identification = identification)
}