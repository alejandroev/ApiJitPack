package co.dito.abako.apijitpack.domain.general.usecase

import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.domain.BaseResult
import co.dito.abako.apijitpack.domain.general.GeneralBackupRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PingUseCase @Inject constructor(private val generalBackupRepository: GeneralBackupRepository) {

    suspend operator fun invoke(url: String): Flow<BaseResult<String, WrappedResponse<String>>> =
        generalBackupRepository.ping(url)
}